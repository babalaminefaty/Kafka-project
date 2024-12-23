package sn.faty.Kafka_Project.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.Kafka_Project.config.services.KafkaProducer;

@RequestMapping("/api/kafka")
@RestController
public class KafkaController {

    private  final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.send(message);
        return ResponseEntity.ok().body("Messsage sent to Kafka");
    }
}
