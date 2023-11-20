package com.inderjeet.kafkaproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenersService {

    Logger LOG = LoggerFactory.getLogger(KafkaListenersService.class);

    //Single Topic Listener
    @KafkaListener(topics = "Topic-1", groupId = "group1")
    void listenerTopic1(String data) {
        LOG.info("message from Topic-1 -- group1 : {}", data);
    }

    @KafkaListener(topics = "Topic-2", groupId = "group1")
    void listenerTopic2(String data) {
        LOG.info("message from Topic-2 -- group1 : {}", data);
    }

    //Multiple Topics Listener
//    @KafkaListener(topics = {"Topic-1", "Topic-2"}, groupId = "group1")
//    void commonListenerForMultipleTopics(String message) {
//        LOG.info("MultipleTopicListener - {}", message);
//    }

    @KafkaListener(
            groupId = "group2",
            topicPartitions = @TopicPartition(
                    topic = "Topic-3",
                    partitionOffsets = { @PartitionOffset(
                            partition = "1",
                            initialOffset = "0") }))
    void listenToPartitionWithOffset(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message [{}] from partition-{} with offset-{}",
                message,
                partition,
                offset);
    }
}
