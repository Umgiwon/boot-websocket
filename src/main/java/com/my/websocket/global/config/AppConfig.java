package com.my.websocket.global.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Application 설정 관련
 */
@Configuration
@ConfigurationProperties(prefix = "device")
@Getter
@Setter
public class AppConfig {
    private String adminPassword;
}
