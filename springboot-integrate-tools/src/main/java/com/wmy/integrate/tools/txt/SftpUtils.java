package com.wmy.integrate.tools.txt;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: FtpTxtFileFactory
 * =================================================
 * @Description: FTP拉取TXT文件解析内容并存入数据库的工厂类
 * 1.创建ftp客户端
 * 2.下载文件
 * 3.上传文件
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/4/7 16:06
 * @Version: V1.0
 */
public class SftpUtils {

    private static Log log = LogFactory.getLog(SftpUtils.class);

    /**
     * FTP host地址
     */
    private static String SFTP_HOST;

    /**
     * FTP端口
     */
    private static String SFTP_PORT;

    /**
     * FTP用户名
     */
    private static String SFTP_USERNAME;

    /**
     * FTP密码
     */
    private static String SFTP_PASSWORD;

    /**
     * 超时时间 毫秒
     */
    private static Integer SFTP_TIME_OUT;

    public SftpUtils(String host,String port,String userName,String password,int timeOut){
        SFTP_HOST = host;
        SFTP_PORT = port;
        SFTP_USERNAME = userName;
        SFTP_PASSWORD = password;
        SFTP_TIME_OUT = timeOut;
    }

    /**
     * FTP连接
     * @return
     * @throws IOException
     */
    private static ChannelSftp ftpConnection() throws Exception{
        ChannelSftp sftp = new ChannelSftp();
        try {
            //创建JSch
            JSch jsch = new JSch();
            //根据JSch获取session对象
            Session session = jsch.getSession(SFTP_USERNAME, SFTP_HOST, Integer.parseInt(SFTP_PORT));
            //设置密码
            session.setPassword(SFTP_PASSWORD);
            //严格主机密钥检查
            session.setConfig("StrictHostKeyChecking","no");
            //开启session连接
            session.connect();
            //超时时间
            session.setTimeout(SFTP_TIME_OUT);
            //获取sftp通道
            Channel channel = session.openChannel("sftp");
            //开启通道
            channel.connect();
            sftp = (ChannelSftp) channel;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ConnectException("FTP连接异常："+e.getMessage());
        }
        return sftp;
    }

    /**
     * 下载文件
     * @param fileUrl 文件路径
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static InputStream downloadFile(String fileUrl) throws IOException, Exception {
        InputStream is;
        ChannelSftp sftp = null;
        try {
            sftp = SftpUtils.ftpConnection();
            is = sftp.get(fileUrl);
        }catch (Exception e){
            throw new IOException(e.getMessage());
        }finally {
        }
        return is;
    }

    /**
     * TXT文件内容以split为分割符合存储，解析内容
     * @param fileUrl 文件路径
     * @param split 分割字符
     * @return
     * @throws Exception
     */
    public List getTxtFileContentBySplit(String fileUrl,String split) throws Exception {
        List list = new ArrayList();
        InputStream is = null;
        ChannelSftp sftp = null;
        try {
            //获取sftp客户端工具
            sftp = SftpUtils.ftpConnection();
            //获取文件流
            is = sftp.get(fileUrl);
            String str = "";
            //读取文件内容
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
            while ((str = br.readLine())!=null){
                String[] contents = str.split(split);
                for (int i = 0; i < contents.length; i++) {
                    Map map = new HashMap();
                    map.put(i,contents[i]);
                    list.add(map);
                }
            }
        }catch (IOException e){
            throw new Exception(e.getMessage());
        }finally {
            if (is != null) {
                is.close();
            }
            if (sftp != null) {
                sftp.getSession().disconnect();
                sftp.quit();
                sftp.disconnect();
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        SftpUtils sftp = new SftpUtils("192.168.0.113","22","root","123456",1000);
        List list = sftp.getTxtFileContentBySplit("/opt/123.txt", "\\$");
        list.stream().forEach(System.out::println);
    }
}
