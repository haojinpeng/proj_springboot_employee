package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController {
    @RequestMapping("/index1")
    public String index(){
        return "test";
    }

    @RequestMapping("/test1")
    public String test1(Model model){
        model.addAttribute("msg","hello");
        return "test";
    }
}
