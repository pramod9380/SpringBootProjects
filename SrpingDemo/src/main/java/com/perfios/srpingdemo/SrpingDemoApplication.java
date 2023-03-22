package com.perfios.srpingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController

public class SrpingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrpingDemoApplication.class, args);
    }

    @GetMapping("/home")
    public String getName(){
        return "Welcome to Spring boot Mr. Pramod";
    }

}
