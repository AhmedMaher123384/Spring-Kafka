package com.spring__kafka.product.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Topic {

    @Bean
    public NewTopic Topic(){

        return TopicBuilder
            .name("topic-product")
            .build();

    }

}
