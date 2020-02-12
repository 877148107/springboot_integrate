package com.wmy.integrate.mybatis.mapper;

import com.wmy.integrate.mybatis.model.Department;

/**
 * @InterfaceName: DepartmentMapper
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: Wangmy
 * @Email: wangmingyong@boco.com.cn
 * @CreateDate: 2020/2/12 23:10
 * @Version: V1.0
 */
public interface DepartmentMapper {

    public Department getDeptById(Integer id);

    public void insertDept(Department department);
}
