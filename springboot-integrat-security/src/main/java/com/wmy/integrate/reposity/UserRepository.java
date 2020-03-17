package com.wmy.integrate.reposity;

import com.wmy.integrate.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: UserRepository
 * =================================================
 * @Description: 用户JPA增删改查接口
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/17 13:47
 * @Version: V1.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
