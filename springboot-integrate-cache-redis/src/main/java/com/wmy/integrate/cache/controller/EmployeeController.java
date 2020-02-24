package com.wmy.integrate.cache.controller;

import com.wmy.integrate.cache.bean.Employee;
import com.wmy.integrate.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EmployeeController
 * ==============================================================================
 * @Description: TODO
 * ==============================================================================
 * CreateInfo:
 * @Author: Wangmy
 * @CreateDate: 2020/2/24 22:40
 * @Version: V1.0
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp")
    public Employee insertEmp(Employee employee){
        employeeService.insertEmp(employee);
        return employee;
    }

    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeService.delEmp(id);
        return "success";
    }

    @GetMapping("/upEpm")
    public Employee updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return employee;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }
}
