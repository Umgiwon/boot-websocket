package com.my.websocket.controller.api;

import com.my.websocket.domain.dto.DoorEventDto;
import com.my.websocket.service.TagEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 외부에서 호출하는 출입 이벤트 수신 API
 */
@RestController
@RequestMapping("/miro-api")
@RequiredArgsConstructor
public class EventApiController {

    private final TagEventService tagEventService;

    /**
     * 출입 이벤트 수신 Endpoint
     *
     * @param dto 장비에서 전달한 출입 이벤트 데이터
     * @return 200 OK
     */
    @PostMapping("/door-event")
    public ResponseEntity<?> receiveEvent(@RequestBody DoorEventDto dto) {

        tagEventService.taggingPublish(dto);
        return ResponseEntity.status(HttpStatus.OK).body("{\"success\":true}");
    }
}
