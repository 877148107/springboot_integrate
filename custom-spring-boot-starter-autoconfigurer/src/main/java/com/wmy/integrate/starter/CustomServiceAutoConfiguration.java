package com.wmy.integrate.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: CustomServiceAutoConfiguration
 * =================================================
 * @Description: 自定义service的自动配置
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/15 11:32
 * @Version: V1.0
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(CustomProperties.class)
public class CustomServiceAutoConfiguration {

    @Autowired
    CustomProperties customProperties;

    @Bean
    public CustomService customService(){
        CustomService customService = new CustomService();
        customService.setCustomProperties(customProperties);
        return customService;
    }
}
