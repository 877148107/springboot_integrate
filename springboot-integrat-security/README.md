## SpringBoot整合Security

## 1.引入SpringSecurity的依赖

```xml
<!--引入security-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## 2.编写SpringSecurity的配置类

​		编写配置类继承WebSecurityConfigurerAdapter 即可。`@EnableWebSecurity`是`Spring Security`用于启用`Web`安全的注解

```java
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
}
```

## 3.定制请求授权规则

```java
/**
 * 定制请求授权规则
 * @param http
 * @throws Exception
 */
@Override
protected void configure(HttpSecurity http) throws Exception {
    //所有角色都能访问
    http.authorizeRequests().antMatchers("/").permitAll()
        //订单管理员的访问权限
        .antMatchers("/page/order/**","/page/report/**","/page/customer/**").hasRole("orderManager")
        //产品管理员的访问权限
        .antMatchers("/page/product/**","/page/report/**").hasRole("productManager")
        //系统管理员的访问权限
        .antMatchers("/page/**").hasRole("systemManager");
    //开启自动配置的登录模式
    //the URL "/login", redirecting to "/login?error" for authentication failure.
    http.formLogin();
}
```

### 		1）、访问页面权限的控制

```java
//所有角色都能访问
http.authorizeRequests().antMatchers("/").permitAll()
    //订单管理员的访问权限
    .antMatchers("/page/order/**","/page/report/**","/page/customer/**").hasRole("orderManager")
    //产品管理员的访问权限
    .antMatchers("/page/product/**","/page/report/**").hasRole("productManager")
    //系统管理员的访问权限
    .antMatchers("/page/**").hasRole("systemManager");
```

### 		2）、开启自动配置的登录模式

```java
//开启自动配置的登录模式
//the URL "/login", redirecting to "/login?error" for authentication failure.
http.formLogin();
```

## 4.定制认证规则



## 5.错误信息

java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"

解决方案：https://docs.spring.io/spring-security/site/docs/5.2.2.RELEASE/reference/htmlsingle/#servlet-hello





