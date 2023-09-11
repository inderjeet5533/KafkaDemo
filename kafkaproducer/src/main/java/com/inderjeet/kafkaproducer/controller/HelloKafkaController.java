package com.inderjeet.kafkaproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloKafkaController {

    @GetMapping("/getHelloKafka")
    public ResponseEntity<String> getHelloKafka(){
        log.info("getHello called from HelloSpringController");
        return ResponseEntity.ok("Hello SpringBoot Kafka");
    }
}
