package com.example.service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class HelloController {

    @GetMapping("/message")
    public String service2(){
        return "I'm from service 2";
    }
}
