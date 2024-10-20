package com.example.demo.repository;

import com.example.demo.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    // courseMajor로 Schedule 데이터를 조회하는 메서드
    List<Schedule> findByCourseMajor(String courseMajor);
}
