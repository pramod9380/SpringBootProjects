package com.perfios.bootcamp.springcore3.bank_application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public  Customer getCustomerObjectForSetterDI(){
        return new Customer();
    }

//    @Bean
//    public Customer getCustomerObjectForConstructorDI(){
//        return new Customer(new Address());
//    }

    @Bean
    public Address getAddressObject(){
        return new Address();
    }

}
