package sshukla.java.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import sshukla.java.payload.User;

/**
 * @author 'Seemant Shukla' on '07/10/2022'
 */

@Service
public class JsonKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User userMessage) {
        logger.info("KafkaService.sendMessage() - {}", userMessage.toString());

        Message<User> jsonMessageBuilder = MessageBuilder
                .withPayload(userMessage)
                .setHeader(KafkaHeaders.TOPIC, "mytopic_json")
                .build();

        kafkaTemplate.send(jsonMessageBuilder);
    }

}
