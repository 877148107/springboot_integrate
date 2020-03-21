package com.wmy.integrate.controller;

import com.wmy.integrate.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TicketController
 * =================================================
 * @Description: 服务提供的http通信controller
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/21 21:56
 * @Version: V1.0
 */
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/buyTicket")
    public String buyTicket(){
        return ticketService.buyTicket();
    }
}
