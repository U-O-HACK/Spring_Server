package com.example.demo.service;

import com.example.demo.models.Schedule;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // 모든 Schedule 데이터를 가져오는 메서드
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
}
