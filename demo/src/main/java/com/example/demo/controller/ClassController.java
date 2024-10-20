package com.example.demo.controller;

import com.example.demo.DTO.ToClient.CourseViewResponse;
import com.example.demo.DTO.ToClient.StatusResponse;
import com.example.demo.DTO.ToServer.CourseAddRequest;
import com.example.demo.DTO.ToServer.CourseDeleteRequest;
import com.example.demo.DTO.ToServer.CourseViewRequest;
import com.example.demo.models.Schedule;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "ClassController", description = "APIs related to Schedules and Courses")
public class ClassController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    // 기존 일정(Schedule) 가져오기
    @PostMapping("/api/schedules/all")
    @Operation(summary = "Get All Schedules", description = "모든 수업 스케줄을 가져옴(파라미터 없음)")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();  // 서비스에서 모든 Schedule 정보를 가져와 반환
    }

    // 새 수업(Course) 추가하기
    @PostMapping("/api/course/add")
    @Operation(summary = "Add a new Course", description = "수업을 추가 (userEmail, jwt, courseCrn)")
    public StatusResponse addCourse(@RequestBody CourseAddRequest request) {
        // 서비스에서 요청을 처리하고 상태 반환
        return courseService.addCourse(request);
    }

    // 수업 삭제하기
    @PostMapping("/api/course/delete")
    @Operation(summary = "Delete a Course", description = "수업을 삭제(userEmail, jwt, courseCrn)")
    public StatusResponse deleteCourse(@RequestBody CourseDeleteRequest request ) {
        // 서비스에서 요청을 처리하고 상태 반환
        return courseService.deleteCourse(request);
    }
    // 이메일로 사용자의 모든 수업을 가져오기
    @PostMapping("/api/course/by-email")
    @Operation(summary = "Get all courses by email", description = "사용자의 이메일로 모든 수업을 가져옴(jwt, email)")
    public List<CourseViewResponse> getCoursesByEmail(@RequestBody CourseViewRequest request) {
        return courseService.getCoursesByEmail(request.getUserEmail(), request.getJwt());
    }
}
