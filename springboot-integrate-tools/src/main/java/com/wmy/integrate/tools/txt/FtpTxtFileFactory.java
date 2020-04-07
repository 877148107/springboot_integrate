package com.wmy.integrate.tools.txt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @ClassName: FtpTxtFileFactory
 * =================================================
 * @Description: FTP��ȡTXT�ļ��������ݲ��������ݿ�Ĺ�����
 * 1.����ftp�ͻ���
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/4/7 16:06
 * @Version: V1.0
 */
public abstract class FtpTxtFileFactory {

    private static Log log = LogFactory.getLog(FtpTxtFileFactory.class);

    /**
     * ��ȡFTP�ļ��������������ļ�·����ȡ
     * @param pathUrl
     * @return
     * @throws IOException
     */
    public abstract List pullTxtFileContext(String pathUrl) throws IOException, Exception;

    /**
     * FTP����
     * @return
     * @throws IOException
     */
    public static FTPClient ftpConnection(String host,String port,String userName,String password) throws Exception{
        FTPClient ftpClient = new FTPClient();
        try {
            //����FTP������
            ftpClient.connect(host, Integer.parseInt(port));
            //��¼
            ftpClient.login(userName,password);
            //�Ƿ�ɹ���¼������
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)) {
                ftpClient.disconnect();
                log.error("--ftp����ʧ��--");
                throw new Exception("ftp����ʧ��");
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return ftpClient;
    }

}
