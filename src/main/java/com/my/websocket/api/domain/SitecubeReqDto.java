package com.my.websocket.api.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class SitecubeReqDto {

    // 이벤트 시간
    private LocalDateTime eventTime;

    // 출입 코드(1: 인증성공, -1: 실패)
    private int accessCode;

    // 실패 사유
    private int accessError;

    // 인증 타입
    private int accessType;

    // 주장치 ID
    private String deviceId;

    // 주장치 이름
    private String deviceName;

    // 인식기 ID
    private String consoleId;


}
