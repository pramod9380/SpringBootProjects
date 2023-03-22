package com.perfios.srpingdemo.AOP;

public class Student {

    public void testMethod(){
        System.out.println("Actual business logic called!!!!!!");
    }

    public void validate(int age) throws Exception{
        if(age<18){
            throw new RuntimeException("Not eligible to vote");
        }

        else {
            System.out.println("Eligible to vote");
        }
    }
}
