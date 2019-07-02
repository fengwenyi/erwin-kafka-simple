package com.fengwenyi.erwin_kafka_simple.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Erwin Feng
 * @since 2019-06-28 19:47
 */
@Getter
@Setter
public class Response {

    private int code;
    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
