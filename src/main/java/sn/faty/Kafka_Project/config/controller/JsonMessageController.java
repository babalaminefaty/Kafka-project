package sn.faty.Kafka_Project.config.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.Kafka_Project.config.services.JsonKafkaProducer;
import sn.faty.Kafka_Project.payload.User;

@RequestMapping("api/kafka")
@RestController
public class JsonMessageController {


    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody User message) {

        jsonKafkaProducer.sendMessage(message);

        return ResponseEntity.ok("message json bien envoye au topic ");
    }


}
