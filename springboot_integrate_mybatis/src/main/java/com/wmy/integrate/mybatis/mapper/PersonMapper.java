package com.wmy.integrate.mybatis.mapper;

import com.wmy.integrate.mybatis.model.Person;
import org.apache.ibatis.annotations.*;

/**
 * @InterfaceName: PersonMapper
 * =================================================
 * @Description:
 * =================================================
 * CreateInfo:
 * @Author: Wangmy
 * @Email: wangmingyong@boco.com.cn
 * @CreateDate: 2020/2/12 22:12
 * @Version: V1.0
 */
//@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM person WHERE id = #{id}")
    public Person getPersonById(Integer id);

    @Delete("delete FROM person WHERE id = #{id}")
    public int deletePersonById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO person(NAME,birthday,age)VALUES(#{name},#{birthday},#{age})")
    public int insertPerson(Person person);

    @Update("UPDATE person SET birthday=#{birthday},age=#{age} where id = #{id}")
    public int updatePerson(Person person);
}
