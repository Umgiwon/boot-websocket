package com.my.websocket.controller.api;

import com.my.websocket.domain.dto.request.AdminPasswordReqDto;
import com.my.websocket.service.AdminAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 내부에서 호출하는 비밀번호 검증용 API
 */
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminApiController {

    private final AdminAuthService adminAuthService;

    /**
     * 비밀번호 검증 Endpoint
     *
     * @param reqDto 비밀번호를 담은 dto
     * @return 검증 결과
     */
    @PostMapping("/verify-password")
    public ResponseEntity<?> verifyPassword(@RequestBody AdminPasswordReqDto reqDto) {

        // 비밀번호 검증
        return adminAuthService.validatePassword(reqDto.getPassword())
                ? ResponseEntity.ok().build()
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
