package com.wmy.integrate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping("/main")
    public String mianPage(){
        return "redirect:/main.html";
    }

    /**
     * 跳转到订单页面
     * @return
     */
    @RequestMapping("/order")
    public String orderPage(){
        return "/page/order/order";
    }

    /**
     * 跳转到产品页面
     * @return
     */
    @RequestMapping("/product")
    public String productPage(){
        return "/page/product/product";
    }

    /**
     * 跳转到顾客页面
     * @return
     */
    @RequestMapping("/customer")
    public String customerPage(){
        return "/page/customer/customer";
    }

    /**
     * 跳转到报表页面
     * @return
     */
    @RequestMapping("report")
    public String reportPage(){
        return "/page/report/report";
    }

    /**
     * 跳转到系统页面
     * @return
     */
    @RequestMapping("/system")
    public String systemPage(){
        return "/page/system";
    }
}
