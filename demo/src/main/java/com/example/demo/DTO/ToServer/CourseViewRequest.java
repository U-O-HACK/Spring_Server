package com.example.demo.DTO.ToServer;

public class CourseViewRequest {
    private String userEmail;
    private String jwt;

    public CourseViewRequest(String userEmail, String jwt) {
        this.userEmail = userEmail;
        this.jwt = jwt;
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
}
