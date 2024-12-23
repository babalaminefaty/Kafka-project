package sn.faty.Kafka_Project.config.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import sn.faty.Kafka_Project.payload.User;

@Service

public class JsonKafkaConsumer {
    private  static  final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);

    //Consommation du json produit par JsonProducer
    @KafkaListener(topics = "jsonTopic", groupId = "MyConsumerGroup")
    public void consumme(User user){

        LOGGER.info(String.format("data receveid -->> %s",user.toString()));

    }

}
