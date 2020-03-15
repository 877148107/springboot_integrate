package com.wmy.integrate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootIntegrateTaskApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    /**
     * 测试发送邮件
     */
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //主题
        message.setSubject("放假通知");
        //内容
        message.setText("4月4、5、6放假三天");

        //发送给谁
        message.setTo("wangmingyong2017@126.com");
        //从谁发送
        message.setFrom("wmy940816@qq.com");

        mailSender.send(message);
    }


    /**
     * 测试发送复杂邮件
     */
    @Test
    public void testSendEmail() throws Exception{
        //创建一个复杂的消息邮件
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);


        //主题
        helper.setSubject("放假通知");
        //内容
        helper.setText("<h1 style='color:red'>4月4、5、6放假三天</h1>",true);

        //发送给谁
        helper.setTo("wangmingyong2017@126.com");
        //从谁发送
        helper.setFrom("wmy940816@qq.com");

        //上传附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\a\\Desktop\\1.jpg"));

        mailSender.send(mailMessage);
    }

}
