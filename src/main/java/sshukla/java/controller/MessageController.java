package sshukla.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sshukla.java.service.KafkaService;

/**
 * @author 'Seemant Shukla' on '07/10/2022'
 */

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private final KafkaService kafkaService;

    @Autowired
    public MessageController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
        kafkaService.sendMessage(message);
        return new ResponseEntity<>("Message Sent to topic", HttpStatus.OK);
    }


}
