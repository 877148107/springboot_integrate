package com.wmy.integrate.tools.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @ClassName: ExcelToJavaBean
 * ==============================================================================
 * @Description: Excel数据行转换成hibernateJava对象
 * ==============================================================================
 * CreateInfo:
 * @Author: Wangmy
 * @CreateDate: 2020/2/24 23:10
 * @Version: V1.0
 */
public class ExcelToJavaBean {

    private static String FILE_PATH = "F:/pms.xlsx";

    private static boolean isTable = false;

    /**
     * get set是否大写
     */
    private static boolean isUpperCase = false;

    /**
     * 是否开启驼峰命名法
     */
    private static boolean IS_HUMP_NAMED = false;

    /**
     * 指定实体生成所在包的路径
      */
    private String packageOutPath = "main.java.com.wmy.integrate.tools.model";

    /**
     * 实体包名
     */
    private String MODEL_PATH = "com.boco.scms.connector.osberp.model.pms.";

    @Test
    public void analysisExcel() throws Exception{
        //1.获取文件流
        FileInputStream io = new FileInputStream(new File(FILE_PATH));
        //2.文件流转换Workbook
        Workbook workbook = new XSSFWorkbook(io);
        //3.获取Excel的数据
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            String sheetName = sheet.getSheetName();
            //如果包含下划线则需要创建数据库，sheet名为表名
            isTable = false;
            //java文件内容
            StringBuffer javaFileContext = new StringBuffer();
            //建表sql
            StringBuffer tableSqlContext = new StringBuffer();
            //hibernate映射文件
            StringBuffer hibernateContext = new StringBuffer();

            if(sheetName.contains("_")){
                isTable = true;
            }

            //表名
            String tableName = "";
            if (isTable) {
                tableName = sheet.getRow(0).getCell(0).getStringCellValue();
            }
            //文件名
            String fileName = sheet.getRow(0).getCell(1).getStringCellValue();
            //备注
            String fileContext = sheet.getRow(0).getCell(2).getStringCellValue();
            //创建文件头内容
            createFileOrTableContextTitle(isTable,tableName,fileName,fileContext,javaFileContext,tableSqlContext);
            //创建hibernate头信息
            if (isTable) {
                createHibernateContext(hibernateContext,tableName,fileName);
            }
            //创建文件属性
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                createFileOrTableContext(row,isTable,javaFileContext,tableSqlContext,tableName,fileContext,fileName,hibernateContext);
            }

            //表备注
            if (isTable) {
                tableSqlContext.append(");").append("\r\n");
                tableSqlContext.append("comment on table ").append(tableName).append("\r\n");
                tableSqlContext.append("  is '").append(fileContext).append("';").append("\r\n");
                tableSqlContext.append("comment on column ").append(tableName).append(".").append("ENTITY_CREATE_DATE").append("\r\n");
                tableSqlContext.append("  is '").append("数据更新时间").append("';").append("\r\n");
                tableSqlContext.append("comment on column ").append(tableName).append(".").append("ENTITY_UPDATE_DATE").append("\r\n");
                tableSqlContext.append("  is '").append("数据创建时间").append("';").append("\r\n");

                hibernateContext.append("  </class>\n");
                hibernateContext.append("</hibernate-mapping>\n");
            }

            //创建文件set、get方法
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                createFileOrTableGetAndSet(row,isTable,javaFileContext,tableSqlContext,tableName,fileContext,fileName);
            }



            javaFileContext.append("\r\n}");
            //创建主键
            tableSqlContext.append("alter table ").append(tableName).append("\r\n");
            tableSqlContext.append("  add constraint PRI_").append(tableName.replace("PMS_I_","")).append(" primary key (ID); ");
            //创建java文件
            createJavaFile(javaFileContext.toString(),fileName,null);
            //创建sql文件
            if (isTable) {
                createJavaFile(tableSqlContext.toString(),tableName,1L);
                createJavaFile(hibernateContext.toString(),fileName,2L);
            }
        }
    }

    /**
     * 组装hibernate映射文件头信息
     * @param tableName
     * @param fileName
     */
    private void createHibernateContext(StringBuffer  hibernateContext,String tableName, String fileName) {
        hibernateContext.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\r\n");
        hibernateContext.append("<!DOCTYPE hibernate-mapping PUBLIC \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\" \"\r\n");
        hibernateContext.append("http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\">\r\n");
        hibernateContext.append("<hibernate-mapping>\r\n");

        hibernateContext.append("  <class dynamic-update=\"false\" table=\"").append(tableName.toUpperCase())
                .append("\" ").append("name=\"").append(MODEL_PATH).append(fileName).append("\"\r\n");
        hibernateContext.append("   dynamic-insert=\"false\">\r\n");

        hibernateContext.append("    <id name=\"id\">\n");
        hibernateContext.append("      <generator class=\"native\"/>\n");
        hibernateContext.append("    </id>\n");

        hibernateContext.append("    <property name=\"erpUpdateDate\" column=\"ENTITY_UPDATE_DATE\"/>\n");
        hibernateContext.append("    <property name=\"erpCreateDate\" column=\"ENTITY_CREATE_DATE\"/>\n");
    }

    /**
     * 创建文件set、get方法
     * @param row
     * @param isTable
     * @param javaFileContext
     * @param tableSqlContext
     * @param tableName
     * @param fileContext
     * @param fileName
     */
    private void createFileOrTableGetAndSet(Row row, boolean isTable, StringBuffer javaFileContext, StringBuffer tableSqlContext, String tableName, String fileContext, String fileName) {
        //字段名称
        String attributeName = row.getCell(0).getStringCellValue();
        //字段备注
        String attributeContext = row.getCell(1).getStringCellValue();
        //字段数据类型
        String attributeType = row.getCell(2).getStringCellValue();

        javaFileContext.append("\r\n");
        if (isTable && !"数据实体".equals(attributeType)) {
            javaFileContext.append("\t/**").append("\r\n");
            javaFileContext.append("\t * @hibernate.property column = ").append("\"").append(attributeName).append("\"").append("\r\n");
            javaFileContext.append("\t * @return").append("\r\n");
            javaFileContext.append("\t */").append("\r\n");
        }
        if("数据实体".equals(attributeType)){
            //封装set、get方法
            javaFileContext.append("\tpublic List ")
                    .append(" get").append(initcap(convertToJavaAttribute(attributeName)))
                    .append("(){\r\n");
            javaFileContext.append("\t    return ").append(convertToJavaAttribute(attributeName)).append(";\r\n");
            javaFileContext.append("\t}").append("\r\n");
            javaFileContext.append("\r\n");
            javaFileContext.append("\tpublic void set").append(initcap(convertToJavaAttribute(attributeName)))
                    .append("(List ").append(" ")
                    .append(convertToJavaAttribute(attributeName)).append("){").append("\r\n");
            javaFileContext.append("\t    this.").append(convertToJavaAttribute(attributeName)).append(" = ")
                    .append(convertToJavaAttribute(attributeName)).append(";\r\n");
            javaFileContext.append("\t}\r\n");
        }else{
            System.out.println("attributeName:"+attributeName);
            //封装set、get方法
            javaFileContext.append("\tpublic ").append(sqlType2JavaType(attributeType,attributeName))
                    .append(" get").append(initcap(convertToJavaAttribute(attributeName)))
                    .append("(){\r\n");
            javaFileContext.append("\t    return ").append(convertToJavaAttribute(attributeName)).append(";\r\n");
            javaFileContext.append("\t}").append("\r\n");
            javaFileContext.append("\r\n");
            javaFileContext.append("\tpublic void set").append(initcap(convertToJavaAttribute(attributeName)))
                    .append("(").append(sqlType2JavaType(attributeType,attributeName)).append(" ")
                    .append(convertToJavaAttribute(attributeName)).append("){").append("\r\n");
            javaFileContext.append("\t    this.").append(convertToJavaAttribute(attributeName)).append(" = ")
                    .append(convertToJavaAttribute(attributeName)).append(";\r\n");
            javaFileContext.append("\t}\r\n");
        }


        //备注信息
        if (isTable) {
            tableSqlContext.append("comment on column ").append(tableName).append(".").append(attributeName).append("\r\n");
            tableSqlContext.append("  is '").append(attributeContext).append("';").append("\r\n");
        }
    }

    /**
     * 创建文件头内容
     * @param tableName
     * @param fileName
     * @param fileContext
     * @param javaFileContext
     */
    private void createFileOrTableContextTitle(boolean isTable,String tableName, String fileName,
                                               String fileContext, StringBuffer javaFileContext,StringBuffer tableSqlContext) {
        //文件头内容
        if(isTable){
            javaFileContext.append(" package com.boco.scms.connector.osberp.model.pms."+ fileName.toLowerCase() +";\r\n");
        }else{
            javaFileContext.append(" package com.boco.scms.connector.osberp.business.pms."+ fileName.toLowerCase() +";\r\n");
        }

        javaFileContext.append("\r\n");
        javaFileContext.append("\r\n");
        javaFileContext.append("\r\n");
        javaFileContext.append("\r\n");

        //备注信息
        javaFileContext.append("/**").append("\r\n");
        javaFileContext.append(" * @ClassName:").append(fileName).append("\r\n");
        javaFileContext.append(" * ==============================================================================").append("\r\n");
        javaFileContext.append(" * @Description: PMS集中化-").append(fileContext).append("\r\n");
        javaFileContext.append(" * 服务标识：").append("\r\n");
        javaFileContext.append(" * 服务名称：").append(fileName).append("\r\n");
        javaFileContext.append(" * ==============================================================================").append("\r\n");
        javaFileContext.append(" * @CreateInfo:").append("\r\n");
        javaFileContext.append(" * @Author: ").append(System.getProperty("user.name")).append("\r\n");
        javaFileContext.append(" * @CreateDate: ").append(LocalDateTime.now()).append("\r\n");
        javaFileContext.append(" * @Version: V1.0").append("\r\n");
        javaFileContext.append(" *").append("\r\n");
        if (isTable) {
            javaFileContext.append(" * @hibernate.class ").append("table = \""+tableName.toUpperCase()+"\"")
                    .append(" dynamic-update = \"false\"").append("\r\n");
            javaFileContext.append(" *                  dynamic-insert = \"false\" ").append("\r\n");
            javaFileContext.append(" *").append("\r\n");
        }
        javaFileContext.append(" */").append("\r\n");

        if (isTable) {
            javaFileContext.append("public class " + fileName + " extends ErpDomainObject {\r\n");
        }else{
            javaFileContext.append("public class " + fileName + " {\r\n");
        }
        javaFileContext.append("\r\n");

        //如果要创建表添加建表语句
        if (isTable) {
            tableSqlContext.append("create table ").append(tableName).append("（").append("\r\n");
            tableSqlContext.append("  ").append("id           NUMBER(19) not null, ").append("\r\n");
            tableSqlContext.append("  ").append("ENTITY_CREATE_DATE Date, ").append("\r\n");
            tableSqlContext.append("  ").append("ENTITY_UPDATE_DATE Date, ").append("\r\n");
        }
    }

    /**
     * 创建建表sql和java文件内容
     * @param row
     * @param isTable
     * @param javaFileContext
     * @param tableSqlContext
     * @param tableName
     * @param fileContext
     * @param fileName
     */
    private void createFileOrTableContext(Row row, boolean isTable, StringBuffer javaFileContext, StringBuffer tableSqlContext,
                                          String tableName, String fileContext, String fileName,StringBuffer hibernateContext) {
        //字段名称
        String attributeName = row.getCell(0).getStringCellValue();
        //字段备注
        String attributeContext = row.getCell(1).getStringCellValue();
        //字段数据类型
        String attributeType = row.getCell(2).getStringCellValue();

        if("数据实体".equals(attributeType)){
            //封装属性
            javaFileContext.append("\t/**").append("\n");
            javaFileContext.append("\t * ").append(attributeContext).append("\n");
            javaFileContext.append("\t*/").append("\n");
            javaFileContext.append("\t private List ")
                    .append(convertToJavaAttribute(attributeName))
                    .append(";\r\n");
        }else{
            //封装属性
            javaFileContext.append("\t/**").append("\n");
            javaFileContext.append("\t * ").append(attributeContext).append("\n");
            javaFileContext.append("\t*/").append("\n");
            javaFileContext.append("\t private " + sqlType2JavaType(attributeType,attributeName) + "  ")
                    .append(convertToJavaAttribute(attributeName))
                    .append(";\r\n");
        }



        if (isTable) {
            if("OUTPUT_EXT".equals(attributeName)){
                tableSqlContext.append("  ").append(attributeName).append(" ").append(attributeType).append("\r\n");
            }else{
                tableSqlContext.append("  ").append(attributeName).append(" ").append(attributeType).append(",\r\n");
            }
            if(!"数据实体".equals(attributeType)){
                hibernateContext.append("    <property name=\"").append(convertToJavaAttribute(attributeName))
                        .append("\" column=\"").append(attributeName).append("\"/>\r\n");
            }
        }

    }

    /**
     * 功能：将输入字符串的首字母改成大写
     * @return
     */
    private String initcap(String string2) {
        char[] ch = string2.toCharArray();
        if (!string2.contains("_")) {
            ch[0] = (char) (ch[0] - 32);
        } else {
            for (int j = 0; j < 3; j++) {
                ch[j] = (char) (ch[j] - 32);
            }
        }
        if (!IS_HUMP_NAMED) {
            return string2;
        }
        return isUpperCase?new String(ch).toUpperCase():new String(ch);
    }

    /**
     * 功能：获得列的数据类型
     *
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType,String attribute) {

        if (sqlType.equalsIgnoreCase("binary_double")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("binary_float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("blob")) {
            return "byte[]";
        } else if (sqlType.equalsIgnoreCase("blob")) {
            return "byte[]";
        } else if (sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar2")
                || sqlType.equalsIgnoreCase("varchar2")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("date")
                || sqlType.equalsIgnoreCase("timestamp")
                || sqlType.equalsIgnoreCase("timestamp with local time zone")
                || sqlType.equalsIgnoreCase("timestamp with time zone")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("number") && attribute.toUpperCase().contains("AMOUNT")) {
            return "Double";
        }else if (sqlType.equalsIgnoreCase("number") && attribute.toUpperCase().contains("TAX")) {
            return "Double";
        }else if (sqlType.equalsIgnoreCase("number") && attribute.toUpperCase().contains("PRICE")) {
            return "Double";
        }else if (sqlType.equalsIgnoreCase("number") && attribute.toUpperCase().contains("QUANTITY")) {
            return "Double";
        }else if (sqlType.equalsIgnoreCase("number")) {
            return "Long";
        }

        return "String";
    }

    /**
     * 转换成java文件名称
     * @param sheetName
     * @return
     */
    private String convertToJavaName(String sheetName) {
        String str = convertToJavaAttribute(sheetName);
        char[] ch = str.toCharArray();
        if (!sheetName.contains("_")) {
            ch[0] = (char) (ch[0] - 32);
        } else {
            for (int j = 0; j < 3; j++) {
                ch[j] = (char) (ch[j] - 32);
            }
        }
        return new String(ch);
    }

    /**
     * 将字符转换成Java属性
     * @param sheetName
     */
    private String convertToJavaAttribute(String sheetName) {
        String string2 = sheetName.toLowerCase();
        StringBuilder builder = new StringBuilder(string2);

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '_') {
                // 第一次出现该符号的位置
                char c = builder.charAt(i + 1);
                c = (char) (c - 32);
                StringBuilder replace1 = builder.replace(i + 1, i + 2, c + "");
                builder = replace1.replace(i, i + 1, "");

                // 最后一次出现该符号的位置
                int of = builder.lastIndexOf("_", string2.length());
                if (of != -1) {
                    char c1 = builder.charAt(of + 1);
                    c1 = (char) (c1 - 32);
                    StringBuilder replace2 = builder.replace(of + 1, of + 2, c1
                            + "");
                    builder = replace2.replace(of, of + 1, "");
                    ;
                }

            }
        }
        return IS_HUMP_NAMED?builder.toString():sheetName;
    }

    /**
     * 创建文件
     * @param content
     * @param fileName
     * @param type
     */
    public void createJavaFile(String content,String fileName,Long type){
        try {
            File directory = new File("");
            String path = this.getClass().getResource("").getPath();

            System.out.println(path);
            System.out.println("src/main/"
                    + path.substring(path.lastIndexOf("/com/",
                    path.length())));
            String outputPath = directory.getAbsolutePath() + "/src/"
                    + this.packageOutPath.replace(".", "/") + "/"
                    + fileName + ".java";
            //建表sql
            if(type!=null && type==1L){
                outputPath = directory.getAbsolutePath() + "/src/"
                        + this.packageOutPath.replace(".", "/") + "/"
                        + fileName + ".sql";
            }
            //hibernate映射文件
            if(type!=null && type==2L){
                outputPath = directory.getAbsolutePath() + "/src/"
                        + this.packageOutPath.replace(".", "/") + "/"
                        + fileName + ".hbm.xml";
            }

            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(outputPath),"GBK");
//            FileWriter fw = new FileWriter(outputPath);
            PrintWriter pw = new PrintWriter(out);
            pw.println(content);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
