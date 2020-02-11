package com.wmy.integrate.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName: MyDruidConfig
 * =================================================
 * @Description: Druid数据源配置
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/11 23:16
 * @Version: V1.0
 */
@Configuration
public class MyDruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**配置Druid数据源监控**/
    /**
     * 配置后台管理的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,Object> param = new HashMap<>();
        param.put("loginUsername","admin");
        param.put("loginPassword","123456");
        param.put("allow","");


        bean.setInitParameters(param);
        return bean;
    }

    /**
     * 配置web监控的filte
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,Object> param = new HashMap<>();
        param.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(param);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
