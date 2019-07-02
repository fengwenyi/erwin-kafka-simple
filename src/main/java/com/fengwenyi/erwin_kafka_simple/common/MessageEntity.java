package com.fengwenyi.erwin_kafka_simple.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Erwin Feng
 * @since 2019-06-28 19:45
 */
@Getter
@Setter
@EqualsAndHashCode
public class MessageEntity {

    private String title;
    private String body;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
