package sn.faty.Kafka_Project.config.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static  final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "myTopic", groupId = "MyConsumerGroup")
    public void consume(String message) {

        LOGGER.info(String.format("Message bien recu: %s", message));

    }
}
