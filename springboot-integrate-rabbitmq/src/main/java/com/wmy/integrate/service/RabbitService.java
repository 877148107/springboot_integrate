package com.wmy.integrate.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: RabbitService
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/11 20:58
 * @Version: V1.0
 */
@Service
public class RabbitService {

    /**
     * 监听消息队列hello.emps
     * @param map
     */
    @RabbitListener(queues = {"hello.emps"})
    public void receive(Map map){
        System.out.println("消息监听结果："+map);
    }

    /**
     * 监听也可以获取消息头信息
     * @param message
     */
    @RabbitListener(queues = {"hello.emps"})
    public void receive01(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
