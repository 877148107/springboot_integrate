package com.wmy.integrate.cache.mapper;

import com.wmy.integrate.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName: EmployeeMapper
 * ==============================================================================
 * @Description: TODO
 * ==============================================================================
 * CreateInfo:
 * @Author: Wangmy
 * @CreateDate: 2020/2/24 22:39
 * @Version: V1.0
 */
@Mapper
public interface EmployeeMapper {

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    public void delEmp(Integer id) ;

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee) ;

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmp(Integer id) ;
}
