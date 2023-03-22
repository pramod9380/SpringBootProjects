package com.perfios.srpingdemo.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        // Using Setter DI
        ApplicationContext context = new ClassPathXmlApplicationContext("collection/collection.xml");
        Student student1 = context.getBean("student1", Student.class);

        System.out.println(student1);

        // using Constructor DI
        Student student2 = context.getBean("student2", Student.class);

        System.out.println(student2);

        ApplicationContext context1 = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = context1.getBean(Student.class);
        College college = context1.getBean(College.class);

        List<String> cources = new ArrayList<>();
        Collections.addAll(cources,"PHP","DBMS","OS");

        //
        List<College> colleges = new ArrayList<>();
        Collections.addAll(colleges,new College("MSRIT","Bangalore"),new College("RVCE","Bangalore"));

        //

        student.setId(2);
        student.setName("Pavan");
        student.setCourse(cources);
        student.setColleges(colleges);

        System.out.println(student);

    }
}
