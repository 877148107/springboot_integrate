package com.wmy.integrate.tools.txt;

import com.jcraft.jsch.ChannelSftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ResourceFTPUtils
 * =================================================
 * @Description: 综资系统的ftp获取txt工具
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/4/7 16:36
 * @Version: V1.0
 */
public class ResourceSftpUtils {

    /**
     * 综资FTP host地址
     */
    private static String RESOURCE_FTP_HOST = "192.168.0.113";

    /**
     * 综资FTP端口
     */
    private static String RESOURCE_FTP_PORT = "22";

    /**
     * 综资FTP用户名
     */
    private static String RESOURCE_FTP_USERNAME = "root";

    /**
     * 综资FTP密码
     */
    private static String RESOURCE_FTP_PASSWORD = "123456";


    public static void main(String[] args) throws Exception {
        SftpUtils sftp = new SftpUtils(RESOURCE_FTP_HOST,RESOURCE_FTP_PORT,RESOURCE_FTP_USERNAME,RESOURCE_FTP_PASSWORD,1000);
        List list = sftp.getTxtFileContentBySplit("/opt/123.txt", "\\$");
        list.stream().forEach(System.out::println);
//        list = SftpUtils.getTxtFileContentBySplit("/opt/2222.txt", "\\|");
//        list.stream().forEach(System.out::println);
    }
}
