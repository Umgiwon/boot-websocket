package com.my.websocket.global.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 런타임 Exception 핸들링
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(HttpServletRequest request, RuntimeException e) {
        log.error(e.getMessage(), e);

        ExceptionMsg exceptionMsg = ExceptionMsg.builder()
                .success(false)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorMessage(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionMsg);
    }
}
