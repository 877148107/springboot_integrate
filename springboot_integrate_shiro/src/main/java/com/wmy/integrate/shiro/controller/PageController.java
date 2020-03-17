package com.wmy.integrate.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: PageController
 * =================================================
 * @Description: 页面跳转controller
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/16 20:29
 * @Version: V1.0
 */
@RequestMapping("/page")
@Controller
public class PageController {

    @RequestMapping("/main")
    public String mianPage(){
        return "redirect:/main.html";
    }

    @RequestMapping("/order")
    public String orderPage(){
        return "/page/order/order";
    }

    @RequestMapping("/product")
    public String productPage(){
        return "/page/product/product";
    }

    @RequestMapping("/customer")
    public String customerPage(){
        return "/page/customer/customer";
    }

    @RequestMapping("report")
    public String reportPage(){
        return "/page/report/report";
    }

    @RequestMapping("/system")
    public String systemPage(){
        return "/page/system";
    }
}
