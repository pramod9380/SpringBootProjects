package com.example.springmvcmultiplecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController1 {

    @GetMapping("/hello1")
    public String display(){
        return "viewpage1";
    }

}
