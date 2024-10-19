package com.example.demo.controller;
import com.example.demo.DTO.ToClient.LoginResponse;
import com.example.demo.DTO.ToServer.LoginRequest;
import com.example.demo.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "ClassController")
public class ClassController {
    @Autowired
    private LoginService loginService;


    @PostMapping("/api/login2")
    @Operation(summary = "로그인", description = "adminId, adminPassword")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request.getUserEmail(),request.getUserPassword());
    }

}
