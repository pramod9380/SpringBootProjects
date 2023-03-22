package com.perfios.srpingdemo.AOP;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsAdvisor implements ThrowsAdvice {

    public void afterThrowing(Exception exception){
        System.out.println("Additional concern added if any exception accusers");
    }
}
