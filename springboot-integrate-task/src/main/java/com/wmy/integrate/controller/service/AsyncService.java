package com.wmy.integrate.controller.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @ClassName: AsyncService
 * =================================================
 * @Description: 异步处理
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/15 12:21
 * @Version: V1.0
 */
@Service
public class AsyncService {

    @Async
    public void sayHello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now()+"调用sayHello方法.......");
    }
}
