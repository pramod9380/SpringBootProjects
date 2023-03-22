package com.example.springkafkaintegration.topic;

import com.example.springkafkaintegration.utils.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Topic --> These are like tables in RDMS which will have unique name
 * Producer when produces the messages have to choose one topic to send to kafka broker
 */
@Configuration
public class KafkaTopicConfig {


    /**
     * This will help to create the topic name if the topic name already exist it will ignore otherwise creates a new one
     * @return the topic Name
     */
    @Bean
    public NewTopic createKafkaTopicName(){
        return TopicBuilder.name(AppConstants.TOPIC_NAME).build();
    }
}
