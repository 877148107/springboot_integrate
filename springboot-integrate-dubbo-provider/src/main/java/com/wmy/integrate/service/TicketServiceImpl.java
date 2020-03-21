package com.wmy.integrate.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TicketServiceImpl
 * =================================================
 * @Description: SpringBoot整合dubbo、zookeeper服务提供类
 * =================================================
 * @Service 将服务发布出去
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/19 21:21
 * @Version: V1.0
 */
@Component
@Service
public class TicketServiceImpl implements TicketService{

    @Override
    public String buyTicket() {
        return "《熊出没》";
    }
}
