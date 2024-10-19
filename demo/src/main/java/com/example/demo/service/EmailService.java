package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // 인증 코드 생성 메서드
    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);  // 6자리 코드 생성
        return String.valueOf(code);
    }

    // 인증 코드를 이메일로 전송하는 메서드
    public void sendVerificationCode(String toEmail) {
        String verificationCode = generateVerificationCode();  // 코드 생성

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to UO TimeTable!! This is your Verification Code");
        message.setText("Your verification code is: " + verificationCode + " Go Ducks!");
        message.setFrom("leojaymin74@gmail.com");

        mailSender.send(message);
    }
}
