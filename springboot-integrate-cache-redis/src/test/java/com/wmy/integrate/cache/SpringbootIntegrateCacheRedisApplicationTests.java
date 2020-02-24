package com.wmy.integrate.cache;

import com.wmy.integrate.cache.bean.Employee;
import com.wmy.integrate.cache.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootIntegrateCacheRedisApplicationTests {

    @Autowired
    EmployeeService employeeService;

    @Test
    void contextLoads() {
        Employee emp = employeeService.getEmp(1);
        System.out.println(emp);
    }

}
