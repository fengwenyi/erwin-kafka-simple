package com.fengwenyi.erwin_kafka_simple.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * 分区消费
 *
 * 分区消费可能会重复消费
 *
 * @author Erwin Feng
 * @since 2019-07-25 12:22
 */
@Slf4j
//@Component
public class PartitionConsumer {

    @KafkaListener(id = "erwin-kafka-demo-group-0", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"0"})})
    public void receiver0(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-1", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"1"})})
    public void receiver1(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-2", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"2"})})
    public void receiver2(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-3", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"3"})})
    public void receiver3(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-4", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"4"})})
    public void receiver4(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-5", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"5"})})
    public void receiver5(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-6", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"6"})})
    public void receiver6(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-7", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"7"})})
    public void receiver7(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-8", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"8"})})
    public void receiver8(String message) {
        handleMessage(message);
    }

    @KafkaListener(id = "erwin-kafka-demo-group-9", topicPartitions ={@TopicPartition(topic = "${kafka.topic.default}", partitions = {"9"})})
    public void receiver9(String message) {
        handleMessage(message);
    }

    private void handleMessage(String message) {
//        log.info(message);
    }

}
