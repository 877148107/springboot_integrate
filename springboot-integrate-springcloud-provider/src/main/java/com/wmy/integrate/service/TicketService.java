package com.wmy.integrate.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName: TicketService
 * =================================================
 * @Description: SpringCloud提供服务
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/21 21:55
 * @Version: V1.0
 */
@Service
public class TicketService {

    public String buyTicket(){
        System.out.println("SpringCloud服务8002.......................");
        return "<<大赢家>>";
    }
}
