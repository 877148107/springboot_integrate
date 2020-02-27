package com.wmy.integrate.cache;

import com.wmy.integrate.cache.bean.Employee;
import com.wmy.integrate.cache.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootIntegrateCacheRedisApplicationTests {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedis(){
        redisTemplate.opsForValue().set("emp-05",employeeService.getEmp(6));
    }

    @Test
    void contextLoads() {
        Employee emp = employeeService.getEmp(3);
        System.out.println(emp);
    }

}
