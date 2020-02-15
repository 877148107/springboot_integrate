package com.wmy.integrate.starter;

/**
 * @ClassName: CustomService
 * =================================================
 * @Description: 自定义Service
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/15 11:27
 * @Version: V1.0
 */
public class CustomService {

    CustomProperties customProperties;

    public CustomProperties getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(CustomProperties customProperties) {
        this.customProperties = customProperties;
    }

    public String sayHello(String str){
        return customProperties.getPrefix()+"_"+str+"_"+customProperties.getSuffix();
    }
}
