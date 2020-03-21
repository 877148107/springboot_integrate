package com.wmy.integrate.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * =================================================
 * @Description: 服务消费者
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/19 21:39
 * @Version: V1.0
 */
@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void getTicket(){
        String ticket = ticketService.buyTicket();
        System.out.println("电影票："+ticket);
    }
}
