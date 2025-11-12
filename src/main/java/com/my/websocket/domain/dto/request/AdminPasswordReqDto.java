package com.my.websocket.domain.dto.request;

import lombok.*;

/**
 * 비밀번호 검증용 dto
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminPasswordReqDto {

    // 관리자 비밀번호
    private String password;
}
