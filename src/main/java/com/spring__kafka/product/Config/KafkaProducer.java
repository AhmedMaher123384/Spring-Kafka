package com.spring__kafka.product.Config;

import com.spring__kafka.product.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    public void sendMassege(Product product){
        Message<Product> message =
                        MessageBuilder.
                        withPayload(product).
                        setHeader(TOPIC,"topic-product").
                        build();

        kafkaTemplate.send(message);
    }
}
