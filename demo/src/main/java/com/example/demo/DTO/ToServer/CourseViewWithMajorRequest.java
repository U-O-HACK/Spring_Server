package com.example.demo.DTO.ToServer;

public class CourseViewWithMajorRequest {
    private String userMajor;
    private String jwt;

    public CourseViewWithMajorRequest(String userMajor, String jwt) {
        this.userMajor = userMajor;
        this.jwt = jwt;
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
