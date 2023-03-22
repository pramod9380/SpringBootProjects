package com.example.kafka_tutorial.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerWithoutKeyValue {
    public static void main(String[] args) {

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
        KafkaProducer<Object,Object> producer1 =new KafkaProducer<>(properties);

        // 3. Creating a Producer Record
        ProducerRecord<Object,Object> record = new ProducerRecord<>("topic1","Hello Kafka");

        // 4. Sending the data
        producer1.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                Logger logger = LoggerFactory.getLogger(ProducerWithoutKeyValue.class);
                if(exception==null){
                    logger.info("Successfully received the details: " +
                            "\nTopic: "+metadata.topic()+"" +
                            "\nPartition: "+metadata.partition()+"" +
                            "\nOffset: "+metadata.offset()+"" +
                            "\nTimeStamp: "+metadata.timestamp());
                }
                else
                    logger.error("Data not produced correctly!!",exception);
            }
        });
        producer1.flush();          // The flush() will force all the data to get produced
        producer1.close();          // close() stops the producer

    }
}
