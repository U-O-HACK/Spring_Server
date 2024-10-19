package com.example.demo.controller;

import com.example.demo.DTO.ToClient.LoginResponse;
import com.example.demo.DTO.ToClient.StatusResponse;
import com.example.demo.DTO.ToServer.EmailRequest;
import com.example.demo.DTO.ToServer.LoginRequest;


import com.example.demo.service.EmailService;
import com.example.demo.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Login Controller")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/api/login")
    @Operation(summary = "로그인", description = "user_email, user_pw")
    public LoginResponse login(@RequestBody LoginRequest request) {
        // 로그인 처리
        LoginResponse response = loginService.login(request.getUserEmail(), request.getUserPassword());

        // 이메일 인증 코드 전송
        emailService.sendVerificationCode(request.getUserEmail());

        return response;
    }

    @PostMapping("/api/send-email-verification")
    @Operation(summary = "Send Email Verification", description = "Sends a verification code to the provided email")
    public StatusResponse sendVerificationEmail(@RequestBody EmailRequest emailRequest) {
        try {
            // 이메일 인증 코드 전송
            emailService.sendVerificationCode(emailRequest.getUserEmail());
            // 성공 시 200 반환
            return new StatusResponse("200");
        } catch (Exception e) {
            // 실패 시 1001 반환
            return new StatusResponse("1001");
        }
    }
    /*@PostMapping("/api/signup")
    @Operation(summary = "회원가입", description = "추후 구현 예정")
    public StatusResponse signup() {
        // 구현 예정
        return new StatusResponse("Signup feature is not implemented yet");
    }*/
}
