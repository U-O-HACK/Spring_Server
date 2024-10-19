package com.example.demo.service;

import com.example.demo.DTO.ToClient.StatusResponse;
import com.example.demo.DTO.ToServer.SignUpRequest;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class SignUpService {

    @Autowired
    private UserRepository userRepository;

    // BCryptPasswordEncoder 인스턴스를 직접 사용
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public StatusResponse signUp(SignUpRequest signUpRequest) {
        try {
            // 이메일 중복 체크
            if (userRepository.findByUserEmail(signUpRequest.getUserEmail()).isPresent()) {
                return new StatusResponse("1201"); // 이미 존재하는 이메일
            }

            // 비밀번호 암호화
            String encodedPassword = passwordEncoder.encode(signUpRequest.getUserPassword());

            // 새로운 유저 생성
            User newUser = new User();
            newUser.setUserEmail(signUpRequest.getUserEmail());
            newUser.setUserPw(encodedPassword);  // 암호화된 비밀번호 저장
            newUser.setUserMajor(signUpRequest.getUserMajor());
            newUser.setUserGrade(signUpRequest.getUserGrade());
            newUser.setUserGraduateYear(signUpRequest.getUserGraduateYear());
            newUser.setUserNickname(signUpRequest.getUserNickname());

            // 데이터베이스에 저장
            userRepository.save(newUser);

            return new StatusResponse("200"); // 회원가입 성공
        } catch (Exception e) {
            return new StatusResponse("1202"); // 회원가입 중 오류 발생
        }
    }
}
