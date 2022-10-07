package sshukla.java.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import sshukla.java.payload.User;

/**
 * @author 'Seemant Shukla' on '07/10/2022'
 */

@Service
public class JsonKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "mytopic_json", groupId = "myGroup")
    public void receiveMessage(User user) {
        logger.info("KafkaService.receiveMessage() - {}", user.toString());
    }

}
