package com.example.demo.DTO.ToClient;

public class LoginResponse {
    private String status;
    private String jwt;

    public LoginResponse(String status, String jwt) {
        this.status = status;
        this.jwt = jwt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
