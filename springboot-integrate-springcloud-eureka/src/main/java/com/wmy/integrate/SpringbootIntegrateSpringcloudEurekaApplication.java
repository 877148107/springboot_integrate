package com.wmy.integrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启用注册中功能
@EnableEurekaServer
@SpringBootApplication
public class SpringbootIntegrateSpringcloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegrateSpringcloudEurekaApplication.class, args);
    }

}
