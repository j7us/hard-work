package org.example.calculate.kafka;

public interface KafkaOutboxSender {

    void saveAndSend(Object obj);
}
