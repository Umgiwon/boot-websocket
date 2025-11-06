package com.my.websocket.api.controller;


import com.my.websocket.api.domain.SitecubeReqDto;
import com.my.websocket.api.service.GrcService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grc")
public class GrcController {

    private final GrcService grcService;

    // TODO Sitecube 데이터 받아서 처리하는 api
    @PostMapping("/tag")
    public ResponseEntity<Boolean> receiveTag(@Valid @RequestBody SitecubeReqDto sitecubeReqDto) {
        return ResponseEntity.ok(grcService.taggingPublish(sitecubeReqDto));
    }

}
