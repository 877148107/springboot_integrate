package com.wmy.integrate.cache.service;

import com.wmy.integrate.cache.bean.Employee;
import com.wmy.integrate.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void delEmp(Integer id) {
        System.out.println("删除："+id);
        employeeMapper.delEmp(id);
    }

    public void updateEmp(Employee employee) {
        System.out.println("更新："+employee);
        employeeMapper.updateEmp(employee);
    }

    public Employee getEmp(Integer id) {
        System.out.println("查询："+id);
        Employee employee = employeeMapper.getEmp(id);
        return employee;
    }
}
