package org.koszalka.coop.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerCoop {

    @KafkaListener(topics = "coop-resultados", groupId = "coop-group")
    public void listenGroupFoo(String message) {
        System.out.println("Resultado da eleição: " + message);
    }

}
