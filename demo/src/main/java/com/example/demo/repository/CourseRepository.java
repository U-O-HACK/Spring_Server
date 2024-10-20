package com.example.demo.repository;

import com.example.demo.models.Course;  // Course 엔티티를 import
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {
    // 사용자의 이메일로 수업을 조회하는 메서드
    List<Course> findByUserEmail(String userEmail);

    // 이메일과 CRN으로 수업을 조회하는 메서드 (복합 키 기반)
    Optional<Course> findByUserEmailAndClassCrn(String userEmail, String classCrn);
}
