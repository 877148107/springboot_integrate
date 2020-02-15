package com.wmy.integrate.project.controller;

import com.wmy.integrate.starter.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: CustomController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/15 12:17
 * @Version: V1.0
 */
@RestController
public class CustomController {

    @Autowired
    CustomService customService;

    @GetMapping("/hello")
    public String sayHello(){
        return customService.sayHello("自定义Starter");
    }
}
