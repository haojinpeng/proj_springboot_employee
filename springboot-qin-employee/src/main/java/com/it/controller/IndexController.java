package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("index")
public class IndexController {
    //测试代码
    /*@RequestMapping("/index1")
    public String index(){
        return "test";
    }
    @RequestMapping("/test1")
    public String test1(Model model){
        model.addAttribute("msg","hello");
        model.addAttribute("users", Arrays.asList("one","two"));
        return "test";
    }*/

    //正式代码开始

}
