package com.example.demo.service;

import com.example.demo.DTO.ToClient.CourseViewResponse;
import com.example.demo.DTO.ToServer.CourseViewWithMajorRequest;
import com.example.demo.config.JwtUtil;
import com.example.demo.models.Schedule;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // major를 기준으로 Schedule 데이터를 가져오는 메서드
    public List<Schedule> getSchedulesByMajor(CourseViewWithMajorRequest request) {
        return scheduleRepository.findByCourseMajor(request.getUserMajor());
    }
}
