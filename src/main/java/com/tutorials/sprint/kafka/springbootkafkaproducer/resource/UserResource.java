package com.tutorials.sprint.kafka.springbootkafkaproducer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    public static final String TOPIC = "Kafka demo";
    @Autowired
    KafkaTemplate<String , String> kafkaTemplate;

    @GetMapping("/publish/{message}")
    public String post(@PathVariable ("message") final String message){
        kafkaTemplate.send(TOPIC, message);
        return "Published successfully";
    }
}
