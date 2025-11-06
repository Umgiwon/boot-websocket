package com.my.websocket.api.service;

import com.my.websocket.api.domain.GrcResDto;
import com.my.websocket.api.domain.SitecubeReqDto;
import com.my.websocket.global.component.TagEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GrcService {

    private final TagEventPublisher tagEventPublisher;

    /**
     * 사이트 큐브 데이터 받아서 처리 후 화면에 전달
     */
    public boolean taggingPublish(SitecubeReqDto sitecubeReqDto) {

        // TODO Sitecube 데이터 받아서 처리

        boolean isSuccess = true;
        try {
            GrcResDto dto = GrcResDto.builder()
                    .deviceId(sitecubeReqDto.getDeviceId())
                    .build();

            tagEventPublisher.publish(dto);
        } catch (Exception e) {
            log.error("taggingPublish error : {}", e.getMessage());
            isSuccess = false;
        }

        return isSuccess;
    }
}
