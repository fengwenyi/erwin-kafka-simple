package com.fengwenyi.erwin_kafka_simple.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author Erwin Feng
 * @since 2019-06-28 19:58
 */
@Slf4j
public class ProducerCallback implements ListenableFutureCallback<SendResult<String, String>> {

    private final long startTime;
    private final String key;
    private final String message;

    public ProducerCallback(long startTime, String key, String message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    @Override
    public void onFailure(Throwable ex) {
        log.error("kafka send error, ", ex);
    }

    @Override
    public void onSuccess(SendResult<String, String> result) {
        if (result == null) {
            return;
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime < 60000)
            return;
        RecordMetadata metadata = result.getRecordMetadata();
        if (metadata != null) {
            StringBuilder record = new StringBuilder();
            record.append("message(")
            .append("key = ").append(key).append(",")
            .append("sent to partition(").append(metadata.partition()).append(")")
            .append("with offset(").append(metadata.offset()).append(")")
            .append("in ").append(elapsedTime).append(" ms")
                    ;
            log.info(record.toString());
        }
    }
}
