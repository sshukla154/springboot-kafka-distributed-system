package sshukla.java.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author 'Seemant Shukla' on '07/10/2022'
 */

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic createMyTopic(){
        return TopicBuilder
                .name("mytopic")
                .partitions(2)
                .replicas(1)
                .build();
    }

}
