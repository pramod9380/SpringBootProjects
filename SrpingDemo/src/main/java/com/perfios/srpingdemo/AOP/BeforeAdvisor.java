package com.perfios.srpingdemo.AOP;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvisor implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Additional concern before actual logic!!!!!!!");

        System.out.println("Method Info:"+method.getName()+" "+ method.getModifiers());
        System.out.println("Arguments Info: ");

        for (Object arg:args){
            System.out.println(arg);
        }

        System.out.println("target object: "+target);
        System.out.println("target object class name: "+target.getClass().getName());
    }
}
