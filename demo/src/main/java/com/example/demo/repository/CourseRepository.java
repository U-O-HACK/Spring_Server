package com.example.demo.repository;

import com.example.demo.models.Course;  // Course 엔티티를 import
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // 사용자의 이메일로 수업을 조회하는 메서드
    List<Course> findByUserEmail(String userEmail);

    // 추가적인 사용자 정의 쿼리 메서드를 여기에 정의할 수 있습니다
}
