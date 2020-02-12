package com.wmy.integrate.mybatis.controller;

import com.wmy.integrate.mybatis.mapper.DepartmentMapper;
import com.wmy.integrate.mybatis.mapper.PersonMapper;
import com.wmy.integrate.mybatis.model.Department;
import com.wmy.integrate.mybatis.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: PersonController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/12 22:21
 * @Version: V1.0
 */
@RestController
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id")Integer id){
        return personMapper.getPersonById(id);
    }

    @GetMapping("/person")
    public Person insertPerson(Person person){
        personMapper.insertPerson(person);
        return person;
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id")Integer id){
        return departmentMapper.getDeptById(id);
    }
}
