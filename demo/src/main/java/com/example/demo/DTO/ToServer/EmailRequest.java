package com.example.demo.DTO.ToServer;

public class EmailRequest {
    private String userEmail;
    private String verifyNumber;

    public EmailRequest(String userEmail, String verifyNumber) {
        this.userEmail = userEmail;
        this.verifyNumber = verifyNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getVerifyNumber() {
        return verifyNumber;
    }

    public void setVerifyNumber(String verifyNumber) {
        this.verifyNumber = verifyNumber;
    }
}
