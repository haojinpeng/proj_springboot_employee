package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        System.out.println("username-->"+username);
        System.out.println("password-->"+password);
        //登陆
        if (!"".equals(username) && username != null && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            //重定向
            return "redirect:/main.html";
        }else {
            //登陆失败
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }

    //注销功能
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
