package com.wmy.integrate.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: MySecurityConfig
 * =================================================
 * @Description: SpringSecurity的配置类
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/16 20:17
 * @Version: V1.0
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定制请求授权规则
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //所有角色都能访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/main.html").permitAll()
                //订单管理员的访问权限
                .antMatchers("/page/order/**","/page/report/**","/page/customer/**").hasRole("orderManager")
                //产品管理员的访问权限
                .antMatchers("/page/product/**","/page/report/**").hasRole("productManager")
                //系统管理员的访问权限
                .antMatchers("/page/**").hasRole("systemManager");
        //开启自动配置的登录模式
        http.formLogin()
                //定制表单的名称
                .usernameParameter("userName").passwordParameter("password")
                //the URL "/login", redirecting to "/login?error" for authentication failure.
                //这里配置默认是SpringSecurity的登录页面，需要配置成自己的登录页面
                .loginPage("/")
                //定制URL处理器登录请求
                .loginProcessingUrl("/user/login");
    }

    /**
     * 定制认证规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存里面校验
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("systemManager")
                .and()
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("productManager")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("orderManager");
    }
}
