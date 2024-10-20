package com.example.demo.DTO.ToServer;

import java.sql.Time;

public class CourseAddRequest {
    private String userEmail;
    private String jwt;

    private String classCrn;

    private String classDay;

    private Time classStart;

    private Time classEnd;

    private String className;

    private String classLocation;

    private String classLocationClassroom;

    private String classMemo;

    public CourseAddRequest(String userEmail, String jwt, String classCrn, String classDay, Time classStart, Time classEnd, String className, String classLocation, String classLocationClassroom, String classMemo) {
        this.userEmail = userEmail;
        this.jwt = jwt;
        this.classCrn = classCrn;
        this.classDay = classDay;
        this.classStart = classStart;
        this.classEnd = classEnd;
        this.className = className;
        this.classLocation = classLocation;
        this.classLocationClassroom = classLocationClassroom;
        this.classMemo = classMemo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getClassCrn() {
        return classCrn;
    }

    public void setClassCrn(String classCrn) {
        this.classCrn = classCrn;
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
