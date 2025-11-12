package com.my.websocket.global.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 외부에서 호출하는 api 보호용 검증 필터
 * endpoint : /miro-api/door-event 에 대해서만 검사
 * Header X-API-KEY 값은 application.yml의 app.api-key 값
 */
@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String apiKey;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return !"/miro-api/door-event".equals(path); // 외부에서 호출하는 endpoint만 필터링
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 받아온 api key
        String key = request.getHeader("X-API-KEY");

        // api key 검증
        if (!StringUtils.hasText(key) || !apiKey.equals(key)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
