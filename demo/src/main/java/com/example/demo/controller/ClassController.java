package com.example.demo.controller;

import com.example.demo.models.Schedule;
import com.example.demo.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "ClassController", description = "APIs related to Schedules")
public class ClassController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/api/schedules")
    @Operation(summary = "Get All Schedules", description = "Fetches all available schedules from the database.")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();  // 서비스에서 모든 Schedule 정보를 가져와 반환
    }
}
