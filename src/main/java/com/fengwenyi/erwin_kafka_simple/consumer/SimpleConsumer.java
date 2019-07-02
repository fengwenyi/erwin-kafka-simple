package com.fengwenyi.erwin_kafka_simple.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Erwin Feng
 * @since 2019-06-28 20:09
 */
@Slf4j
@Component
public class SimpleConsumer {

    @KafkaListener(topics = "${kafka.topic.default}")
    public void receiver(String message) {
//        log.info(message);
    }

}
