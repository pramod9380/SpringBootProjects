package com.perfios.springcoreusinginterface.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageTest {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TextMessage textMessage = context.getBean(TextMessage.class);
        EmailMessage emailMessage = context.getBean(EmailMessage.class);

        System.out.println(textMessage.message());
        System.out.println(emailMessage.message());
    }
}
