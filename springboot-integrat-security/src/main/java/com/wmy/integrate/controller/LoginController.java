package com.wmy.integrate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName: LoginController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/8 21:43
 * @Version: V1.0
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if("admin".equals(userName) && "123456".equals(password)){
            session.setAttribute("userName",userName);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

    @RequestMapping("/order")
    public String orderPage(){
        return "/page/order";
    }

    @RequestMapping("/product")
    public String productPage(){
        return "/page/product";
    }

    @RequestMapping("/customer")
    public String customerPage(){
        return "/page/customer";
    }

    @RequestMapping("report")
    public String reportPage(){
        return "/page/report";
    }

    @RequestMapping("/system")
    public String systemPage(){
        return "/page/system";
    }

}
