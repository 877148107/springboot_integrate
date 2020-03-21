package com.wmy.integrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//开启发现服务功能
@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootIntegrateSpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegrateSpringcloudConsumerApplication.class, args);
    }

    /**
     * 发送http请求的组件
     * @LoadBalanced 发送请求的时候使用负载均衡机制
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
