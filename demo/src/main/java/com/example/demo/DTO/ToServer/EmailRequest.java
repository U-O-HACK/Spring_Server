package com.example.demo.DTO.ToServer;

public class EmailRequest {
    private String userEmail;

    public EmailRequest() {
    }
    public EmailRequest(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
