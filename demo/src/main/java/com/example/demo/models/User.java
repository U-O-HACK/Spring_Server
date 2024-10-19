package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_email", nullable = false, length = 128)
    private String userEmail;

    @Column(name = "user_pw", nullable = false, length = 128)
    private String userPw;

    @Column(name = "user_img", length = 2048)
    private String userImg;

    @Column(name = "user_major", length = 128)
    private String userMajor;

    @Column(name = "user_grade", length = 128)
    private String userGrade;  // 새로 추가된 필드

    @Column(name = "user_graduate_year", length = 128)
    private String userGraduateYear;  // 새로 추가된 필드
    @Column(name = "user_nickname", length = 128)
    private String userNickname;

    // Getters and Setters

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
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
