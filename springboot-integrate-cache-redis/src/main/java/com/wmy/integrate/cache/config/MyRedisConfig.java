package com.wmy.integrate.cache.config;

import com.wmy.integrate.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @ClassName: MyRedisConfig
 * ==============================================================================
 * @Description: Redis自动配置
 * ==============================================================================
 * @CreateInfo:
 * @Author: Wangmy
 * @CreateDate: 2020/2/26 23:18
 * @Version: V1.0
 */
@Configuration
public class MyRedisConfig {

    @Bean(value = "empRedisTemplate")
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
}
