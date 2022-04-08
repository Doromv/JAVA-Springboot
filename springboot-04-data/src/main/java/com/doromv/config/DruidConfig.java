package com.doromv.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Doromv
 * @create 2022-03-12-11:33
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> InitParameters = new HashMap<>();
        InitParameters.put("loginUsername","admin");
        InitParameters.put("loginPassword","123456");
        InitParameters.put("allow","");//允许谁可以访问
//        InitParameters.put("Doromv","192.168.11.123");//禁止谁可以访问
        bean.setInitParameters(InitParameters);
        return bean;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());//set阿里巴巴的stat过滤器
        HashMap<String,String> initParameters = new HashMap<>();
        initParameters.put("exclusions","*.js,*.css,/druid/*");//这些东西不进行过滤
        bean.setInitParameters(initParameters);
        return bean;
    }
}
