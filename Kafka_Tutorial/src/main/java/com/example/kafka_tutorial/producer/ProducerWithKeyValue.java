package com.example.kafka_tutorial.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerWithKeyValue {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // To create the kafka-producer class need to follow 4 steps

        /**
         * 1. Create the producer properties
         * 2. Create the producer
         * 3. Create the producer record
         * 4. Send the data
         */

        // 1. Creating the producer properties

        String bootstrapServers = "localhost:9092";
        Properties properties = new Properties();

        //It is a list of the port pairs which are used for establishing an initial connection to the Kafka cluster.
        // The users can use the bootstrap servers only for making an initial connection only.
        // This server is present in the host:port, host:port,... form
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 2. Creating a kafka producer
        KafkaProducer<Object,Object> producer2 =new KafkaProducer<>(properties);

        // 3. Creating a Producer Record

        for(int i=0;i<10;i++) {

            String topicName = "topic2";
            String key = "_id"+Integer.toString(i);
            String value = "value"+Integer.toString(i);

            ProducerRecord<Object, Object> record = new ProducerRecord<>(topicName,key,value);

            // 4. Sending the data
            producer2.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    Logger logger = LoggerFactory.getLogger(ProducerWithoutKeyValue.class);
                    if (exception == null) {
                        logger.info("Successfully received the details: " +
                                "\nTopic: " + metadata.topic() + "" +
                                "\nPartition: " + metadata.partition() + "" +
                                "\nOffset: " + metadata.offset() + "" +
                                "\nTimeStamp: " + metadata.timestamp());
                    } else
                        logger.error("Data not produced correctly!!", exception);
                }
            }).get();           // sending data synchronously forcefully
        }
        producer2.flush();          // The flush() will force all the data to get produced
        producer2.close();          // close() stops the producer
    }
}
