package com.example.demo.service;

import com.example.demo.DTO.ToClient.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Random;
import java.util.concurrent.*;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // 이메일과 인증번호를 저장하는 ConcurrentHashMap
    private ConcurrentHashMap<String, String> verificationCodes = new ConcurrentHashMap<>();

    // 스케줄러를 사용해 인증번호를 만료시키는 작업 설정
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // 인증 코드 생성 메서드
    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);  // 6자리 코드 생성
        return String.valueOf(code);
    }

    // 인증 코드를 이메일로 전송하는 메서드 (이미지 첨부 및 HTML 지원)
    public StatusResponse sendVerificationCode(String toEmail) {
        try {
            String verificationCode = generateVerificationCode();  // 코드 생성

            // 이메일과 인증번호 저장
            verificationCodes.put(toEmail, verificationCode);

            // 인증번호가 5분 후 자동으로 만료되도록 설정
            scheduler.schedule(() -> verificationCodes.remove(toEmail), 5, TimeUnit.MINUTES);

            // MIME 메시지를 생성하여 HTML과 이미지를 포함한 이메일 전송
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(toEmail);
            helper.setSubject("🔐 Your Ducktimes Verification Code");

            // 이메일 내용: 5분 뒤 만료 알림 및 이미지 포함, 가독성을 위한 HTML 포맷팅
            String emailContent = "<div style='text-align: center;'>"
                    + "<h1 style='font-size: 24px; color: #333;'>Welcome to UO TimeTable! 🦆</h1>"
                    + "<p style='font-size: 18px; color: #555;'>Your verification code is:</p>"
                    + "<h2 style='font-size: 40px; color: #2E86C1;'><strong>" + verificationCode + "</strong></h2>"
                    + "<p style='font-size: 16px; color: #555;'>Please use this code to complete your verification. 🔐</p>"
                    + "<p style='font-size: 14px; color: #888;'>This code will expire in <strong>5 minutes</strong>. ⏰</p>"
                    + "<img src='cid:logoImage' style='margin-top: 20px; width: 200px;'>"
                    + "<p style='font-size: 16px; color: #555;'>Go Ducks! 🦆</p>"
                    + "</div>";

            // HTML 콘텐츠 설정
            helper.setText(emailContent, true);

            // 이미지 첨부 (클래스패스 리소스 경로에서 이미지 파일 로드)
            helper.addInline("logoImage", new ClassPathResource("/static/hack_uo_img.png"));

            // 이메일 전송
            mailSender.send(mimeMessage);

            return new StatusResponse("200");  // 성공 시 200 반환
        } catch (MessagingException e) {
            return new StatusResponse("1001");  // 이메일 전송 실패 시 1001 반환
        } catch (Exception e) {
            return new StatusResponse("1001");  // 기타 예외 발생 시 1001 반환
        }
    }

    // 인증번호 확인 및 삭제 메서드
    public StatusResponse verifyCode(String email, String code) {
        try {
            // 이메일에 해당하는 인증번호 가져오기
            String storedCode = verificationCodes.get(email);

            // 인증번호가 맞으면 삭제하고 true 반환, 아니면 false 반환
            if (storedCode != null && storedCode.equals(code)) {
                verificationCodes.remove(email);  // 인증 성공 시 제거
                return new StatusResponse("200");  // 성공 시 200 반환
            } else {
                return new StatusResponse("1002");  // 인증 실패 시 1002 반환
            }
        } catch (Exception e) {
            return new StatusResponse("1002");  // 예외 발생 시 1002 반환
        }
    }
}
