package com.fengwenyi.erwin_kafka_simple.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 批量消费
 * @author Erwin Feng
 * @since 2019-07-25 15:08
 */
@Slf4j
@Component
public class BatchConsumer {

    private void handleMessage(String message) {
//        log.info(message);
    }

    /**
     * 监听topic5,批量消费
     */
    @KafkaListener(id = "erwin-kafka-demo-group-batch", topics = "${kafka.topic.default}", containerFactory = "batchFactory")
    public void listenApiLog(List<String> records) {
        records.forEach(this::handleMessage);
    }


}
