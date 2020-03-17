package com.wmy.integrate.reposity;

import com.wmy.integrate.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: UserRoleRepository
 * =================================================
 * @Description: 用户角色JPA增删改查接口
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/17 13:48
 * @Version: V1.0
 */
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
