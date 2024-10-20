package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    // 이메일로 사용자를 찾는 메서드
    Optional<User> findByUserEmail(String userEmail);
    List<String> findByUserMajor(String userMajor);

}

