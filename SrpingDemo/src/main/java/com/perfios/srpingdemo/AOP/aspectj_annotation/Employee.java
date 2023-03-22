package com.perfios.srpingdemo.AOP.aspectj_annotation;

public class Employee {

    public String getName(){
        System.out.println("getName method invoked!!!!!!!");
        return "Pramod";
    }

    public String getAddress(){
        System.out.println("getAddress method invoked!!!!!!!!");
        return "Near Infant Medical";
    }

    public void setName(){
        System.out.println("setName method invoked!!!!!!!");
    }

    public void getEmployeeExperience(int year){
        if(year<2){
            throw new RuntimeException("Not Eligible to SSDE");
        }
        else {
            System.out.println("Eligible to SSDE");
        }
    }
}
