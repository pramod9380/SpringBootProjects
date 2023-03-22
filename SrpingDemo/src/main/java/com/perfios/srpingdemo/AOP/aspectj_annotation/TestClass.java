package com.perfios.srpingdemo.AOP.aspectj_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("aspectj/applicationcontext.xml");
        Employee emp = context.getBean("employee", Employee.class);

        emp.getName();
        emp.getAddress();
        emp.getEmployeeExperience(0);
    }
}
