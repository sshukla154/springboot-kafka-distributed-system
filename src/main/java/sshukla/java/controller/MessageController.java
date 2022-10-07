package sshukla.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshukla.java.payload.User;
import sshukla.java.service.JsonKafkaProducer;
import sshukla.java.service.StringKafkaProducer;

/**
 * @author 'Seemant Shukla' on '07/10/2022'
 */

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private final StringKafkaProducer stringKafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public MessageController(StringKafkaProducer stringKafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.stringKafkaProducer = stringKafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    //POST: http://localhost:8080/api/v1/kafka/string/message?message=Hello-World
    @PostMapping("/string/message")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        stringKafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message Sent to topic", HttpStatus.OK);
    }

    //POST: http://localhost:8080/api/v1/kafka/string/message?message=Hello-World
    @PostMapping("/json/message")
    public ResponseEntity<String> publishJSONMessage(@RequestBody User message) {
        jsonKafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message Sent to topic", HttpStatus.OK);
    }


}
