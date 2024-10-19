package com.example.demo.DTO.ToServer;

public class SignUpRequest {
    private String userEmail;
    private String userPassword;
    private String userMajor;
    private String userGrade;
    private String userGraduateYear;
    private String userNickname;

    public SignUpRequest(String userEmail, String userPassword, String userMajor, String userGrade, String userGraduateYear, String userNickname) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userMajor = userMajor;
        this.userGrade = userGrade;
        this.userGraduateYear = userGraduateYear;
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserGraduateYear() {
        return userGraduateYear;
    }

    public void setUserGraduateYear(String userGraduateYear) {
        this.userGraduateYear = userGraduateYear;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
