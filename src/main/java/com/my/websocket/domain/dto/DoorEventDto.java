package com.my.websocket.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 출입 이벤트 dto
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoorEventDto {

    // 장비 ID
    private String deviceId;

    // 주장치 이름
    private String deviceName;

    // 이벤트 시간
    private LocalDateTime eventTime;

    // 출입 코드(1: 인증성공, -1: 실패)
    private int accessCode;

    // 실패 사유
    private int accessError;

    // 인증 타입
    private int accessType;

    // 인식기 ID
    private String consoleId;

    // 사용자 이름
    private String userName;
}
