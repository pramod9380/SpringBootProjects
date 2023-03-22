package com.perfios.srpingdemo.dependencyinjuction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
   public Employee getEmployeeObjectUsingSetter(){
       return new Employee(new Address());
   }

   @Bean
   public Address getAddressObject(){
        return new Address();
   }

}
