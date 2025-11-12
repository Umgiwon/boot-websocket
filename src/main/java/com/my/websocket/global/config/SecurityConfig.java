package com.my.websocket.global.config;

import com.my.websocket.global.filter.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Security 대체용 간단한 필터
 */
@Configuration
public class SecurityConfig {

    @Value("${app.api-key}")
    private String apiKey;

    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {
        FilterRegistrationBean<ApiKeyFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new ApiKeyFilter(apiKey));
        reg.addUrlPatterns("/miro-api/door-event");
        reg.setOrder(1);
        return reg;
    }
}
