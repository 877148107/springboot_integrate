package com.wmy.integrate;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit//开启基于注解的rabbitMQ模式
@SpringBootApplication
public class SpringbootIntegrateRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegrateRabbitmqApplication.class, args);
    }

}
