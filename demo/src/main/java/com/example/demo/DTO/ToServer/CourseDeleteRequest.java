package com.example.demo.DTO.ToServer;

public class CourseDeleteRequest {
    private String userEmail;
    private String jwt;
    private String classCrn;

    public CourseDeleteRequest(String userEmail, String jwt, String classCrn) {
        this.userEmail = userEmail;
        this.jwt = jwt;
        this.classCrn = classCrn;
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
}
