package com.wmy.integrate.jpa.model;

import javax.persistence.*;

/**
 * @ClassName: User
 * =================================================
 * @Description: 用户实体对象
 * --@Entity 告诉JPA这是一个实体类，数据库表的映射类
 * --@Table 指定实体对应的数据库表，不设置默认是user
 * --@Id 主键
 * --@GeneratedValue 指定主键生产策略
 * --@Column 指定列名，如果不设置字段名默认就是属性名
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/13 22:35
 * @Version: V1.0
 */
@Entity
@Table(name="s_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name",length = 16)
    private String userName;

    @Column
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
