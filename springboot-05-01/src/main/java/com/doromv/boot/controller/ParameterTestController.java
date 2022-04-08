package com.doromv.boot.controller;

import org.springframework.boot.web.server.Cookie;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Doromv
 * @create 2022-03-09-8:00
 */
@RestController
public class ParameterTestController {
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable Integer id,
                                     @PathVariable String username,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String Agent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam Integer age,
                                     @RequestParam List<String> inters,
                                     @RequestParam Map<String,String> params){
        Map<String, Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("name",username);
//        map.put("pv",pv);
//        map.put("User-Agent",Agent);
//        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        return map;
    }
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
}
