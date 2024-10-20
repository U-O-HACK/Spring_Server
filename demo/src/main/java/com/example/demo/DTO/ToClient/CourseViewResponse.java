package com.example.demo.DTO.ToClient;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.sql.Time;

public class CourseViewResponse {
    private String status;
    private String classCrn;
    private String classDay;
    private Time classStart;
    private Time classEnd;
    private String className;
    private String classLocation;

    private String classMemo;

    public CourseViewResponse(String status, String classCrn, String classDay, Time classStart, Time classEnd, String className, String classLocation, String classMemo) {
        this.status = status;
        this.classCrn = classCrn;
        this.classDay = classDay;
        this.classStart = classStart;
        this.classEnd = classEnd;
        this.className = className;
        this.classLocation = classLocation;
        this.classMemo = classMemo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getClassMemo() {
        return classMemo;
    }

    public void setClassMemo(String classMemo) {
        this.classMemo = classMemo;
    }
}
