package com.fengwenyi.erwin_kafka_simple.producer;

import com.fengwenyi.erwin_kafka_simple.common.MessageEntity;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author Erwin Feng
 * @since 2019-06-28 19:49
 */
@Component
public class SimpleProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, MessageEntity messageEntity) {
        kafkaTemplate.send(topic, messageEntity);
    }

    public void send(String topic, String key, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, message);
        long startTime = System.currentTimeMillis();
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);
        future.addCallback(new ProducerCallback(startTime, key, message));
    }

}
