package sshukla.java.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author 'Seemant Shukla' on '07/10/2022'
 */

@Service
public class StringKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(StringKafkaProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        logger.info("KafkaService.sendMessage() - {}", message);
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("mytopic", message);
        logger.info("Result - {}", result);
    }

}
