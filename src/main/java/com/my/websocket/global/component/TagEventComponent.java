package com.my.websocket.global.component;

import com.my.websocket.domain.dto.DoorEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * 태그 이벤트 발생 시 장비별 토픽에 이벤트를 보내는 서비스
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TagEventComponent {

    private final SimpMessagingTemplate messagingTemplate;

    /**
     * 각 장비에 데이터 전송
     */
    public void publish(DoorEventDto dto) {
        String destination = "/sub/device/" + dto.getDeviceId();
        messagingTemplate.convertAndSend(destination, dto);
    }
}
