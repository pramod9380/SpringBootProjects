package com.perfios.srpingdemo.dependencyinjuction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependencyInjectionExample {

    public static void main(String[] args) {

        /*
            // DependencyInjection through constructor
            ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
            Employee employee = (Employee) context.getBean("emp1");

            System.out.println(employee);

         */

        // DependencyInjection through setter method

        ApplicationContext context = new ClassPathXmlApplicationContext("common/bean.xml");
        Employee employee = (Employee) context.getBean("emp2");

        System.out.println(employee);

        /*
            // Using BeanFactory
            Resource resource = new ClassPathResource("bean.xml");
            Employee employee = (Employee) new XmlBeanFactory(resource).getBean("emp1");

            System.out.println(employee);

         */

        // Using Annotation

        ApplicationContext context1 = new AnnotationConfigApplicationContext(SpringConfig.class);
        Employee employee1 = context1.getBean(Employee.class);
        Address address = context1.getBean(Address.class);

        // Setting Address fields
        address.setArea("Near Infant Medicals");
        address.setCity("Banagalore");
        address.setState("Karnataka");
        address.setZipCode("560029");


        // Setting Employee fields
        employee1.setEmployeeId(1);
        employee1.setEmployeeName("Pramod");
        employee1.setAddress(address);

        System.out.println("employee1: "+employee1);
    }

}
