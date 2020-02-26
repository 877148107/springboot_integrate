package com.wmy.integrate.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootIntegrateCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegrateCacheRedisApplication.class, args);
    }

}
