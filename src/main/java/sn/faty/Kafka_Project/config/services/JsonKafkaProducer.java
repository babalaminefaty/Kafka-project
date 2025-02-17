package sn.faty.Kafka_Project.config.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import sn.faty.Kafka_Project.payload.User;

@Service
public class JsonKafkaProducer {

      private KafkaTemplate<String, User> kafkaTemplate ;

    private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {

        LOGGER.info(String.format("Sending data to Kafka --> %s ", data.toString()) );

        //Transformation dun objet java en JSON
        Message<User> message= MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "jsonTopic")
                .build();
        kafkaTemplate.send(message);
    }



}
