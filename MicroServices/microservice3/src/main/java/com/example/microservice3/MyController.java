package com.example.microservice3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/message")
    public String getMessage(){
        return "I'm from microservice3";
    }
}
