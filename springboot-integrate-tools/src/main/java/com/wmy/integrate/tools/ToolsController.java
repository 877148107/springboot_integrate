package com.wmy.integrate.tools;

import com.wmy.integrate.tools.txt.SftpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ToolsController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/4/7 22:36
 * @Version: V1.0
 */
@RestController
public class ToolsController {

    @GetMapping("/txt1")
    public List txtFile1() throws Exception {
        SftpUtils sftp = new SftpUtils("192.168.0.113","22","root","123456",1000);
        List list = sftp.getTxtFileContentBySplit("/opt/2222.txt", "\\|");
        return list;
    }

    @GetMapping("/txt2")
    public List txtFile2() throws Exception {
        SftpUtils sftp = new SftpUtils("192.168.0.113","22","root","123456",1000);
        List list = sftp.getTxtFileContentBySplit("/opt/123.txt", "\\$");
        return list;
    }
}
