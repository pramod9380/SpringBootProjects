package com.perfios.srpingdemo.collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Student getStudentObject(){
        return new Student();
    }

    @Bean
    public College getCollegeObject(){
        return new College();
    }

}
