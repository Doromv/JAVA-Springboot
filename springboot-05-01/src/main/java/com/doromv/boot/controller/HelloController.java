package com.doromv.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doromv
 * @create 2022-03-08-20:19
 */
@RestController
public class HelloController {
    @RequestMapping("/IMG_20191116_133038.jpg")
    public String hello(){
        return "hello";
    }
}
