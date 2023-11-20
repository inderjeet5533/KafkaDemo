package com.inderjeet.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static Integer partition = 1;
    private static String key = null;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

    //publish message on specific topic
    public void sendMessageToPartition(String message, String topicName) {
        kafkaTemplate.send(topicName, partition, key, message);
    }
}
