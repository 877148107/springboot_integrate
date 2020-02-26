package com.wmy.integrate.cache.service;

import com.wmy.integrate.cache.bean.Employee;
import com.wmy.integrate.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @ClassName: EmployeeService
 * ==============================================================================
 * @Description: TODO
 * ==============================================================================
 * CreateInfo:
 * @Author: Wangmy
 * @CreateDate: 2020/2/24 22:39
 * @Version: V1.0
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public void insertEmp(Employee employee) {
        System.out.println("添加："+employee);
        employeeMapper.insertEmp(employee);
    }

    @CacheEvict(value = "emp",key = "#id")
    public void delEmp(Integer id) {
        System.out.println("删除："+id);
        employeeMapper.delEmp(id);
    }

    
    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("更新："+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @Cacheable(cacheNames = "emp",key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询："+id);
        Employee employee = employeeMapper.getEmp(id);
        return employee;
    }
}
