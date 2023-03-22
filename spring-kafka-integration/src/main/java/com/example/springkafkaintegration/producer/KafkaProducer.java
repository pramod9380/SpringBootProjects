package com.example.springkafkaintegration.producer;

import com.example.springkafkaintegration.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Producer --> producer is one whose writes the data to the kafka-broker
 */
@Service
public class KafkaProducer {

    // Helps to monitor the logs
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    /**
     * The KafkaTemplate wraps a producer and provides convenience methods to send data to kafka topics
     * It is like dependency injection and automatic configuration
     */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME,message);
    }

}
