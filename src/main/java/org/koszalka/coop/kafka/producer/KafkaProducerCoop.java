package org.koszalka.coop.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerCoop {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    public KafkaProducerCoop(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send("coop-resultados", msg);
    }

}
