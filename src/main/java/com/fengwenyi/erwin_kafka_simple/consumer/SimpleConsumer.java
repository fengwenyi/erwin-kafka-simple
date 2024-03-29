package com.fengwenyi.erwin_kafka_simple.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 简单消费者
 * @KafkaListener,
 *
 * id: 有的话，会覆盖 groupId
 *
 * groupId:消费组ID
 *
 * @author Erwin Feng
 * @since 2019-06-28 20:09
 */
@Slf4j
//@Component
public class SimpleConsumer {

    @KafkaListener(topics = "${kafka.topic.default}")
    public void receiver(String message) {
//        log.info(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-simple", topics = "${kafka.topic.default}")
    public void receiver(ConsumerRecord<?, ?> record) {
        Object key = record.key();
        if (key != null) {
            String keyStr = key.toString();
        }
        String message = (String) record.value();
    }

}
