package com.my.websocket.service;

import com.my.websocket.domain.dto.DoorEventDto;
import com.my.websocket.global.component.TagEventComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagEventService {

    private final TagEventComponent tagEventPublisher;

    /**
     * 사이트 큐브 데이터 받아서 처리 후 화면에 전달
     */
    public void taggingPublish(DoorEventDto doorEventDto) {

        // TODO Sitecube 데이터 받아서 처리
        try {
            DoorEventDto dto = DoorEventDto.builder()
                    .deviceId(doorEventDto.getDeviceId())
                    .build();

            tagEventPublisher.publish(dto);
        } catch (Exception e) {
            log.error("taggingPublish error : {}", e.getMessage());
        }
    }
}
