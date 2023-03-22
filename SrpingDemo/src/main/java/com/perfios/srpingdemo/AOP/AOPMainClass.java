package com.perfios.srpingdemo.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMainClass {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("AOP/aop.xml");
        Student student = context.getBean("proxy",Student.class);

        student.testMethod();

        try {
            student.validate(17);
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
