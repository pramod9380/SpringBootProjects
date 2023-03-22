package com.perfios.srpingdemo.inversionofcontrol;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class InversionOfControlExample {
    public static void main(String[] args) {

        // Traditional way of writing

        Student student = new Student();

        student.setStudentName("Pramod");
        student.setStudentUsn("1MS18CS093");
        student.setStudentLocation("Bangalore");

        System.out.println(student);

        System.out.println("---------------------Spring IOC--------------------");



        // By Using Spring IOC


        // 1. Configure Java Object in xml file
        // 2. Use Spring IOC Container e.g: BeanFactory or ApplicationContext to get the Objects constructed by them
        // 3.

        // Using Application Context
        // It will create the object if u not call getBean method

        System.out.println("----------Using ApplicationContext----------------");

        ApplicationContext context = new ClassPathXmlApplicationContext("common/bean.xml");
        Student student1 = (Student) context.getBean("student1");
    //                          (or)
    //    Student student1 = context.getBean("student1",Student.class);

        System.out.println(student1);

        ClassPathXmlApplicationContext context1 = (ClassPathXmlApplicationContext) context;
        context1.destroy();     // Manually Destroying the Bean Objects

        // Using Bean Factory
        // It doesn't create the object until and unless u call getBean method

        System.out.println("-----------using Bean Factory---------------------");

        Resource resource = new ClassPathResource("common/bean.xml");
        Student student2 = (Student) new XmlBeanFactory(resource).getBean("student2");
        System.out.println(student2);

    }
}
