package com.my.websocket.service;

import com.my.websocket.global.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminAuthService {

    private final AppConfig appConfig;

    /**
     * 설정된 비밀번호와 일치하는지 검증
     * @param inputPassword 입력된 비밀번호
     * @return 일치여부
     */
    public boolean validatePassword(String inputPassword) {
        return appConfig.getAdminPassword().equals(inputPassword);
    }
}
