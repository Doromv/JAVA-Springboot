package com.doromv.boot;

import com.doromv.boot.bean.Pet;
import com.doromv.boot.bean.User;
import com.doromv.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Doromv
 * @create 2022-03-07-15:31
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//        Pet tomcat01 = run.getBean("tomcat", Pet.class);
//        Pet tomcat02 = run.getBean("tomcat", Pet.class);
//        System.out.println(tomcat01==tomcat02);
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//        User user01 = bean.user01();
//        User user02 = bean.user01();
//        System.out.println(user01==user02);
//        User doromv = run.getBean("Doromv",User.class);
//        System.out.println(doromv.getPet() == tomcat01);
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
        Object doromv = run.getBean("Doromv");
        System.out.println(doromv);
    }
}
