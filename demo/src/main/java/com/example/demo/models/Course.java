package com.example.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "class")
@IdClass(Course.CourseId.class)  // 복합 키 설정
public class Course {

    @Id
    @Column(name = "class_crn", nullable = false)  // class_crn을 복합 키의 일부로 사용
    private String classCrn;

    @Id
    @Column(name = "class_user_email", length = 128, nullable = false)  // user_email을 복합 키의 일부로 사용
    private String userEmail;

    @Column(name = "class_day", length = 50)
    private String classDay;

    @Column(name = "class_start")
    private Time classStart;

    @Column(name = "class_end")
    private Time classEnd;

    @Column(name = "class_name", length = 128)
    private String className;

    @Column(name = "class_location", length = 128)
    private String classLocation;

    @Column(name = "class_memo", length = 512)
    private String classMemo;

    @Column(name = "class_user_major", length = 128)  // 사용자 전공 추가
    private String classUserMajor;

    @Column(name = "class_major", length = 128)  // 수업 전공 추가
    private String classMajor;

    // 복합 키 클래스
    public static class CourseId implements Serializable {
        private String classCrn;
        private String userEmail;

        // 기본 생성자
        public CourseId() {}

        // 생성자
        public CourseId(String classCrn, String userEmail) {
            this.classCrn = classCrn;
            this.userEmail = userEmail;
        }
    }

    // Getters and Setters

    public String getClassCrn() {
        return classCrn;
    }

    public void setClassCrn(String classCrn) {
        this.classCrn = classCrn;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getClassDay() {
        return classDay;
    }

    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    public Time getClassStart() {
        return classStart;
    }

    public void setClassStart(Time classStart) {
        this.classStart = classStart;
    }

    public Time getClassEnd() {
        return classEnd;
    }

    public void setClassEnd(Time classEnd) {
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

    public String getClassMemo() {
        return classMemo;
    }

    public void setClassMemo(String classMemo) {
        this.classMemo = classMemo;
    }

    public String getClassUserMajor() {
        return classUserMajor;
    }

    public void setClassUserMajor(String classUserMajor) {
        this.classUserMajor = classUserMajor;
    }

    public String getClassMajor() {
        return classMajor;
    }

    public void setClassMajor(String classMajor) {
        this.classMajor = classMajor;
    }
}
