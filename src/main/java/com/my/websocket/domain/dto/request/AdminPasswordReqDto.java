package com.my.websocket.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminPasswordReqDto {

    // 관리자 비밀번호
    private String password;
}
