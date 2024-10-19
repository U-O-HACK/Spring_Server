package com.example.demo.controller;

import com.example.demo.DTO.ToClient.LoginResponse;
import com.example.demo.DTO.ToClient.StatusResponse;
import com.example.demo.DTO.ToServer.EmailRequest;
import com.example.demo.DTO.ToServer.LoginRequest;
import com.example.demo.DTO.ToServer.SignUpRequest;
import com.example.demo.service.EmailService;
import com.example.demo.service.LoginService;
import com.example.demo.service.SignUpService;
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

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/api/login")
    @Operation(summary = "Login", description = "로그인(user_email, user_pw)")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request.getUserEmail(), request.getUserPassword());
    }

    @PostMapping("/api/email-code-send")
    @Operation(summary = "Send Email Verification", description = "이메일 인증 코드 전송 (userEmail)")
    public StatusResponse sendVerificationEmail(@RequestBody EmailRequest emailRequest) {
        return emailService.sendVerificationCode(emailRequest.getUserEmail());
    }

    @PostMapping("/api/email-code-verify")
    @Operation(summary = "Verify Email Code", description = "이메일 인증 코드 확인(userEmail, verifyNumber)")
    public StatusResponse verifyEmailCode(@RequestBody EmailRequest emailRequest) {
        return emailService.verifyCode(emailRequest.getUserEmail(), emailRequest.getVerifyNumber());
    }

    @PostMapping("/api/signup")
    @Operation(summary = "Sign Up", description = "회원가입(userEmail, userPassword, userMajor, userGrade, userGraduateYear, userNickname)")
    public StatusResponse signup(@RequestBody SignUpRequest signUpRequest) {
        return signUpService.signUp(signUpRequest);
    }
}
