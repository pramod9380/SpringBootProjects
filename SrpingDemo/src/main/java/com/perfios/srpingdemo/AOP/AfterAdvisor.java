package com.perfios.srpingdemo.AOP;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AfterAdvisor implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        System.out.println("Additional concern after actual logic!!!!!");

//        System.out.println("return value : "+returnValue.getClass().getName());

        System.out.println("args:");
        Arrays.stream(args).forEach(System.out::println);

        System.out.println("Target Object: "+target);
        System.out.println("Target Class Name: "+target.getClass().getName());

    }
}
