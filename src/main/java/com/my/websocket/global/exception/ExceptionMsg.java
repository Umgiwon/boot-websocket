package com.my.websocket.global.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ExceptionMsg {

    private Boolean success;
    private String path;
    private LocalDateTime timestamp;
    private int errorCode;
    private String errorMessage;
}
