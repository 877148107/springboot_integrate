package com.wmy.integrate.jpa.repository;

import com.wmy.integrate.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName: UserRepository
 * =================================================
 * @Description: JAP增删改查接口
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/13 22:50
 * @Version: V1.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
