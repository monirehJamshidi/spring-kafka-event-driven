package org.j2os.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    // =============================
    // Topic
    // =============================
    @Bean
    public NewTopic orderTopic(){
        return TopicBuilder.name("order-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }

    public NewTopic paymentTopic(){
            return TopicBuilder.name("payments")
                    .partitions(3)
                    .replicas(1)
                    .build();
    }

}
