package com.doromv.controller;

import com.doromv.mapper.UserMapper;
import com.doromv.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Doromv
 * @create 2022-03-12-16:01
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/queryAll")
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }
    @GetMapping("/delete/{id}")
    public int deleteUser(@PathVariable("id") Integer id){
        return userMapper.deleteUser(id);
    }
}
