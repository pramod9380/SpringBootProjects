package com.example.kafka_tutorial.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {

        // These are the four steps to follow while creating the kafka consumer
        /**
         * 1. Create Consumer Properties
         * 2. Create Consumer
         * 3. Subscribe consumer to a specific topic
         * 4. Poll out the new data
         */

        // Creating Logger
        Logger logger = LoggerFactory.getLogger(Consumer.class);

        String bootstrapServers = "localhost:9092";
        String group_id = "second_app";
        String topic = "topic1";

        // 1. Creating the consumer properties
        Properties properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, group_id);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // 2. Creating the Kafka consumer
        KafkaConsumer<Object, Object> consumer = new KafkaConsumer<>(properties);

        // 3. Subscribe the consumer to the specific topic
        consumer.subscribe(Arrays.asList(topic));

        // 4. Polling for the new Data
        while (true) {
            ConsumerRecords<Object, Object> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<Object, Object> record : records) {
                logger.info("Key: " + record.key() + ", Value:" + record.value());
                logger.info("Partition:" + record.partition() + ",Offset:" + record.offset());
            }
        }
    }
}
