package com.example.demo.repository;

import com.example.demo.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    // 기본 CRUD 및 findAll 메서드가 자동으로 제공됩니다.
}
