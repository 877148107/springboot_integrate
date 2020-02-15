package com.wmy.integrate.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: CustomProperties
 * =================================================
 * @Description: 自定义属性配置实体
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/2/15 11:27
 * @Version: V1.0
 */
@ConfigurationProperties(prefix = "spring.custom")
public class CustomProperties {

    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
