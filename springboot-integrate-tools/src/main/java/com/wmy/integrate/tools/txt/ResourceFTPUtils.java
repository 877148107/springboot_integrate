package com.wmy.integrate.tools.txt;

import com.boco.framework.exception.BusinessException;
import com.boco.scms.comm.SysConfig;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ResourceFTPUtils
 * =================================================
 * @Description: ����ϵͳ��ftp��ȡtxt����
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/4/7 16:36
 * @Version: V1.0
 */
public class ResourceFTPUtils extends FtpTxtFileFactory {

    /**
     * ����FTP host��ַ
     */
    private static String RESOURCE_FTP_HOST = SysConfig.getProperty("RESOURCE_FTP_HOST");

    /**
     * ����FTP�˿�
     */
    private static String RESOURCE_FTP_PORT = SysConfig.getProperty("RESOURCE_FTP_PORT");

    /**
     * ����FTP�û���
     */
    private static String RESOURCE_FTP_USERNAME = SysConfig.getProperty("RESOURCE_FTP_USERNAME");

    /**
     * ����FTP����
     */
    private static String RESOURCE_FTP_PASSWORD = SysConfig.getProperty("RESOURCE_FTP_PASSWORD");

    /**
     * ��ȡ�ļ�����ȡ
     * @throws Exception
     */
    public List pullTxtFileContext(String pathUrl) throws Exception{
        List list = new ArrayList();
        try {
            //1.��ȡ�ļ�������
            InputStream is = getInputStream(pathUrl);
            //2.�����ļ�����
            list = analysisFile(is);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return list;
    }

    public InputStream getInputStream(String pathUrl) throws IOException {
        InputStream is = null;
        try {
            FTPClient ftpClient = ftpConnection(RESOURCE_FTP_HOST,RESOURCE_FTP_PORT,RESOURCE_FTP_USERNAME,RESOURCE_FTP_PASSWORD);
            is = ftpClient.retrieveFileStream(pathUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }


    public List analysisFile(InputStream os) throws Exception {

        return null;
    }

}
