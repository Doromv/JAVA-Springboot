package com.doromv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Doromv
 * @create 2022-03-10-14:44
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model){
        if("Doromv".equals(username)&&"QAQ".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或者密码错误");
        }
        return "index";
    }
    @GetMapping("user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}
