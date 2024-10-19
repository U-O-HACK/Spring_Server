package com.example.demo.service;

import com.example.demo.DTO.ToClient.LoginResponse;
import com.example.demo.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(String userEmail, String userPassword) {
        Optional<User> adminOptional = userRepository.findByUserEmail(userEmail);

        // Optional에서 User를 안전하게 가져오기
        if (adminOptional.isPresent()) {
            User user= adminOptional.get();
            if (user.getUserPassword().equals(userPassword)) {
                String token = JwtUtil.generateToken(userEmail);
                return new LoginResponse("200", token);
            } else {
                return new LoginResponse("1301", null); // 비밀번호가 일치하지 않음
            }
        } else {
            return new LoginResponse("1301", null); // 사용자가 존재하지 않음
        }
    }
}
