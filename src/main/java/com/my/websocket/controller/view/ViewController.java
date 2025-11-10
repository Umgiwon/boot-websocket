package com.my.websocket.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    /**
     * 관리자 비밀번호 입력 화면으로 리다이렉트
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/setup/admin-password";
    }

//    @GetMapping("/")
//    public String root() {
//        return "redirect:/main";
//    }


    /**
     * 관리자 비밀번호 입력 화면
     */
    @GetMapping("/setup/admin-password")
    public String adminPasswordPage() {
        return "setup/admin-password";
    }

    /**
     * 장비 ID 입력 화면
     */
    @GetMapping("/setup/device-id")
    public String deviceIdPage() {
        return "setup/device-id";
    }

    /**
     * 메인 화면
     */
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}
