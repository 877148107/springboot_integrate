package com.wmy.integrate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: UserController
 * =================================================
 * @Description: SpringCloud消费者
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/21 22:31
 * @Version: V1.0
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取服务提供者的数据
     * @return
     */
    @GetMapping("/ticket")
    public String userBuyTicket(){
        //发送http请求并获取数据
        String object = restTemplate.getForObject("http://springcloud-provider/buyTicket", String.class);
        return "成功订购电影票："+object;
    }
}
