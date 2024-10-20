package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course")
public class Schedule {

    @Id
    @Column(name = "course_crn", nullable = false)
    private int courseCrn;  // 고유 CRN (Primary Key)

    @Column(name = "course_name", length = 128, nullable = false)
    private String courseName;  // 수업 이름

    @Column(name = "course_major", length = 128)
    private String courseMajor;  // 전공 (nullable)

    @Column(name = "course_code", length = 128)
    private String courseCode;  // 수업 코드 (nullable)

    @Column(name = "course_credit", length = 128)
    private String courseCredit;  // 크레딧 (nullable)

    @Column(name = "course_day", length = 128)
    private String courseDay;  // 요일 (nullable)

    @Column(name = "course_start_time")
    private LocalDateTime courseStartTime;  // 시작 시간 (nullable)

    @Column(name = "course_end_time")
    private LocalDateTime courseEndTime;  // 종료 시간 (nullable)

    @Column(name = "course_professor", length = 128)
    private String courseProfessor;  // 교수 (nullable)

    @Column(name = "course_location", length = 128)
    private String courseLocation;  // 수업 장소 (nullable)

    // Getters and Setters
    public int getCourseCrn() {
        return courseCrn;
    }

    public void setCourseCrn(int courseCrn) {
        this.courseCrn = courseCrn;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseMajor() {
        return courseMajor;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay = courseDay;
    }

    public LocalDateTime getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(LocalDateTime courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public LocalDateTime getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(LocalDateTime courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getCourseProfessor() {
        return courseProfessor;
    }

    public void setCourseProfessor(String courseProfessor) {
        this.courseProfessor = courseProfessor;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }
}
