package com.example.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home(){
        return "abcd";
    }

    @GetMapping("/hello")
    public String display(){
        return "hello";
    }

}
