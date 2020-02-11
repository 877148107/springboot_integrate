package com.wmy.integrate.mybatis.controller;

import com.wmy.integrate.mybatis.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName: UserController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/10 22:55
 * @Version: V1.0
 */
@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @ResponseBody
    @RequestMapping("/query")
    public Map<String,Object> query(){
        return userDao.query();
    }

}
