package com.perfios.springcoreusinginterface.test;

public class TextMessage implements MessageService {

    @Override
    public String message() {
        return "This is a simple text service!!!!";
    }

}
