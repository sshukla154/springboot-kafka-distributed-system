package sshukla.java.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author 'Seemant Shukla' on '07/10/2022'
 */

@Service
public class StringKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(StringKafkaConsumer.class);

    @KafkaListener(topics = "mytopic", groupId = "myGroup")
    public void receiveMessage(String message) {
        logger.info("KafkaService.receiveMessage() - {}", message);
    }

}
