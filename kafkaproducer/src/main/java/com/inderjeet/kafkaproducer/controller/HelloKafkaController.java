package com.inderjeet.kafkaproducer.controller;

import com.inderjeet.kafkaproducer.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloKafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/publish/topic1")
    public ResponseEntity<String> getTopic1(@RequestParam String message){
        log.info("getHello called from HelloSpringController.getTopic1");
        kafkaProducerService.sendMessage(message, "Topic-1");
        return ResponseEntity.ok("Hello from Kafka Topic-1");
    }

    @GetMapping("/publish/topic2")
    public ResponseEntity<String> getTopic2(@RequestParam String message){
        log.info("getHello called from HelloSpringController.getTopic2");
        kafkaProducerService.sendMessage(message, "Topic-2");
        return ResponseEntity.ok("Hello from Kafka Topic-2");
    }

    @GetMapping("/publish/topic3")
    public ResponseEntity<String> getTopic3(@RequestParam String message){
        log.info("getHello called from HelloSpringController.getTopic3");
        kafkaProducerService.sendMessageToPartition(message, "Topic-3");
        return ResponseEntity.ok("Hello from Kafka Topic-3");
    }
}
