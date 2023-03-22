package com.example.springkafkaintegration.controller;

import com.example.springkafkaintegration.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@AllArgsConstructor
public class KafkaProducerController {

    private KafkaProducer kafkaProducer;


    @GetMapping("/publish")
    public ResponseEntity<String> publishMessageToKafka(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
