package com.doromv.boot;

import com.doromv.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doromv
 * @create 2022-03-07-15:33
 */
@RestController
public class HelloController {
    @Autowired
    Car car;
    @RequestMapping("/hello")
    public String handle01(){
        return "hello,你好";
    }
    @RequestMapping("/Car")
    public Car car(){
        return car;
    }
}
