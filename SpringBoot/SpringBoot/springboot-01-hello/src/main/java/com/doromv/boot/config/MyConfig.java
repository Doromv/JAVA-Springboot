package com.doromv.boot.config;

import com.doromv.boot.bean.Car;
import com.doromv.boot.bean.Pet;
import com.doromv.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Doromv
 * @create 2022-03-07-20:44
 */
@Configuration(proxyBeanMethods = true)
@Import({User.class})
@EnableConfigurationProperties(Car.class)
public class MyConfig {
//   @ConditionalOnBean(Pet.class)
    @Bean("Doromv")
    public User user01(){
        return new User("Doromv",21,Pet01());
    }
    @Bean("tomcat1")
    public Pet Pet01(){
        return new Pet("tomcat");
    }
}
