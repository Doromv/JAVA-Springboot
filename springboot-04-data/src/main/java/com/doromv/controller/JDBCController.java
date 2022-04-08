package com.doromv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Doromv
 * @create 2022-03-12-10:09
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/query")
    public List<Map<String,Object>> userList(){
        String sql="select * from mybatis.teacher";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
        return userList;
    }

    @GetMapping("/add")
    public String addUser(){
        String sql="insert into mybatis.teacher values(2,'周老师')";
        jdbcTemplate.update(sql);
        return "ok";
    }
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        String sql="update mybatis.teacher set name=? where id="+id;
        String name="狂老师";
        jdbcTemplate.update(sql,name);
        return "ok";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        String sql="delete  from mybatis.teacher where id=?";
        jdbcTemplate.update(sql,id);
        return "ok";
    }
}
