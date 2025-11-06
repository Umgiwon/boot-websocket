package com.my.websocket.api.controller;


import com.my.websocket.api.service.GrcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grc/")
public class GrcController {

    private final GrcService grcService;


    // TODO Sitecube 데이터 받아서 처리하는 api

}
