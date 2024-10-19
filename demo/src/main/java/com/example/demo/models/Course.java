package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "class")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_idx")
    private Long classIdx;

    @Column(name = "user_email", length = 128, nullable = false)  // 이메일 필드 추가
    private String userEmail;

    @Column(name = "class_day", length = 50)
    private String classDay;

    @Column(name = "class_start")
    private LocalDateTime classStart;

    @Column(name = "class_end")
    private LocalDateTime classEnd;

    @Column(name = "class_name", length = 128)
    private String className;

    @Column(name = "class_location", length = 128)
    private String classLocation;

    @Column(name = "class_location_classroom", length = 128)
    private String classLocationClassroom;

    @Column(name = "class_memo", length = 512)
    private String classMemo;

    // Getters and Setters

    public Long getClassIdx() {
        return classIdx;
    }

    public void setClassIdx(Long classIdx) {
        this.classIdx = classIdx;
    }

    public String getUserEmail() {  // userEmail 필드의 Getter
        return userEmail;
    }

    public void setUserEmail(String userEmail) {  // userEmail 필드의 Setter
        this.userEmail = userEmail;
    }

    public String getClassDay() {
        return classDay;
    }

    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    public LocalDateTime getClassStart() {
        return classStart;
    }

    public void setClassStart(LocalDateTime classStart) {
        this.classStart = classStart;
    }

    public LocalDateTime getClassEnd() {
        return classEnd;
    }

    public void setClassEnd(LocalDateTime classEnd) {
        this.classEnd = classEnd;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public String getClassLocationClassroom() {
        return classLocationClassroom;
    }

    public void setClassLocationClassroom(String classLocationClassroom) {
        this.classLocationClassroom = classLocationClassroom;
    }

    public String getClassMemo() {
        return classMemo;
    }

    public void setClassMemo(String classMemo) {
        this.classMemo = classMemo;
    }
}
