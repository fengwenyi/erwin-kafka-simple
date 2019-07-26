package com.fengwenyi.erwin_kafka_simple.controller;

import com.alibaba.fastjson.JSON;
import com.fengwenyi.erwin_kafka_simple.common.ErrorCode;
import com.fengwenyi.erwin_kafka_simple.common.MessageEntity;
import com.fengwenyi.erwin_kafka_simple.common.Response;
import com.fengwenyi.erwin_kafka_simple.producer.SimpleProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Erwin Feng
 * @since 2019-06-28 19:37
 */
@RestController
@RequestMapping("/kafka/produce")
@Slf4j
public class KafkaProduceController {

    @Autowired
    private SimpleProducer simpleProducer;

    @Value("${kafka.topic.default}")
    private String topic;

    @GetMapping("/hello")
    public Response sendKafka() {
        return new Response(ErrorCode.SUCCESS, "hello");
    }

    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response send(@RequestBody MessageEntity messageEntity) {
        try {
            String message = JSON.toJSONString(messageEntity);
            log.info("kafka的消息={}", message);
            for (int i = 0; i < 10000000; i++)
                simpleProducer.send(topic, "key_" + System.currentTimeMillis() + "_" + UUID.randomUUID().toString(), message);
            log.info("发送kafka成功");
            return new Response(ErrorCode.SUCCESS, "发送kafka成功");
        } catch (Exception e) {
            log.error("发送kafka失败，", e);
            return new Response(ErrorCode.EXCEPTION, "发送kafka失败");
        }
    }

    // 每秒发送 10000 条
    @PostMapping(value = "/send2", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response send2(@RequestBody MessageEntity messageEntity) {
        try {
            String message = JSON.toJSONString(messageEntity);
            log.info("kafka的消息={}", message);
            while (true) {
                long startTime = System.currentTimeMillis();
                int MAX = 10000;
                for (int i = 0; i < MAX; i++) {
                    simpleProducer.send(topic, "key_" + UUID.randomUUID().toString(), message);
                }
                long endTime = System.currentTimeMillis();
                double spendTime = (endTime - startTime) / 1000D;
                log.info("向kafka发送 {} 条数据，花费 {} 秒", MAX, spendTime);
                Thread.sleep(1000);
            }
//            log.info("发送kafka成功");
//            return new Response(ErrorCode.SUCCESS, "发送kafka成功");
        } catch (Exception e) {
            log.error("发送kafka失败，", e);
            return new Response(ErrorCode.EXCEPTION, "发送kafka失败");
        }
    }

}
