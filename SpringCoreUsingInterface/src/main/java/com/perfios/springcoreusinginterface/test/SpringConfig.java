package com.perfios.springcoreusinginterface.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public TextMessage getTextMessage(){
        return new TextMessage();
    }

    @Bean
    public EmailMessage getEmailMessage(){
        return new EmailMessage();
    }
}
