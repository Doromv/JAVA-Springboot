package com.doromv.boot.controller;

import com.doromv.boot.been.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doromv
 * @create 2022-03-08-16:34
 */
@RestController
public class HelloController {
    @Autowired
    Person person;
    @RequestMapping("/p1")
    public Person person(){
        return person;
    }
}
