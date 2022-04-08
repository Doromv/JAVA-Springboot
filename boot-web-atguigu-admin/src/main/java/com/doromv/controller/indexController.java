package com.doromv.controller;

import com.doromv.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Doromv
 * @create 2022-03-17-11:35
 */
@Controller
public class indexController {
    @GetMapping ("/")
    public String tologin(){
        return "login";
    }
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName())&&"123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账户或密码错误");
            return "login";
        }
    }
    @RequestMapping("/main.html")
    public String main(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
        return "main";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }

    }
}
