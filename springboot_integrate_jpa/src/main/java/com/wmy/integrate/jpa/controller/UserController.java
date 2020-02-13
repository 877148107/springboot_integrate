package com.wmy.integrate.jpa.controller;

import com.wmy.integrate.jpa.model.User;
import com.wmy.integrate.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: UserController
 * =================================================
 * @Description: controller控制层
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/13 22:33
 * @Version: V1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return  userRepository.findById(id).get();
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }

}
