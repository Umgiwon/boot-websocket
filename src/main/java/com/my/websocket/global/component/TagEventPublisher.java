package com.my.websocket.global.component;

import com.my.websocket.api.domain.GrcResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 태그 이벤트 발생 시 장비별 토픽에 이벤트를 퍼블리시 하는 컴포넌트
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TagEventPublisher {

    private final SimpMessagingTemplate messagingTemplate;

    /**
     * 각 장비에 데이터 전송
     */
    public void publish(GrcResDto grcResDto) {
        String destination = "/topic/grc/" + grcResDto.getDeviceId();
        log.info("publish grcResDto : {}", grcResDto);
        messagingTemplate.convertAndSend(destination, grcResDto);
    }
}
