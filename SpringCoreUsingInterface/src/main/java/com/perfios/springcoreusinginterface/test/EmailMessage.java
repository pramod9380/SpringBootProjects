package com.perfios.springcoreusinginterface.test;

public class EmailMessage implements MessageService{
    @Override
    public String message() {
        return "This is simple email service!!!!";
    }
}
