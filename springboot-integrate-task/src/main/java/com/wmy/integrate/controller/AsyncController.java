package com.wmy.integrate.controller;

import com.wmy.integrate.controller.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @ClassName: AsyncController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/15 12:20
 * @Version: V1.0
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String sayHello(){
        asyncService.sayHello();
        return LocalDateTime.now()+"hello AsyncService。。。。。。";
    }
}
