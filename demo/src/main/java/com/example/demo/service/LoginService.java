package com.example.demo.service;

import com.example.demo.DTO.ToClient.LoginResponse;
import com.example.demo.config.JwtUtil;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    // BCryptPasswordEncoder 인스턴스를 직접 사용
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginResponse login(String userEmail, String userPassword) {
        Optional<User> userOptional = userRepository.findByUserEmail(userEmail);

        // Optional에서 User를 안전하게 가져오기
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // 암호화된 비밀번호 비교
            if (passwordEncoder.matches(userPassword, user.getUserPw())) {  // 입력된 비밀번호를 암호화된 비밀번호와 비교
                String token = JwtUtil.generateToken(userEmail);
                return new LoginResponse("200", token);  // 로그인 성공
            } else {
                return new LoginResponse("1101", null); // 비밀번호가 일치하지 않음
            }
        } else {
            return new LoginResponse("1102", null); // 사용자가 존재하지 않음
        }
    }
}
