package com.perfios.bootcamp.springcore3.bank_application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApplication {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Customer customer = context.getBean(Customer.class);
        Address address = context.getBean(Address.class);

        // Setting Address Fields
        address.setArea("Near Infant Medicals");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setZipCode("560029");


        // Setting Customer Fields
        customer.setId(1);
        customer.setFirstName("Pramod");
        customer.setLastName("Kulkarni");
        customer.setAge(22);
        customer.setDob("25-08-2000");
        customer.setGender("Male");
        customer.setEmailId("pramod.k@perfios.com");
        customer.setMobileNumber("6362063788");
    //    customer.setAddress(address);

        customer.getDetails();

        // Using xml configuration file
        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean.xml");
        Customer customer1 = context1.getBean("customer2", Customer.class);
        customer1.getDetails();
    }
}
