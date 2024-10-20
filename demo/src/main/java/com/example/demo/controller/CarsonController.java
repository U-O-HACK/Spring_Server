package com.example.demo.controller;

import com.example.demo.models.Carson;
import com.example.demo.service.CarsonDiningScraperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "CarsonController", description = "APIs for Carson Dining Menu")
public class CarsonController {

    @Autowired
    private CarsonDiningScraperService carsonDiningScraperService;

    @PostMapping("/api/carson/view")
    @Operation(summary = "Get today's Carson menu", description = "오늘의 카슨 메뉴(파라미터 없음)")
    public List<Carson> getTodayCarsonMenu() {
        return carsonDiningScraperService.getTodayCarsonMenu();
    }
}
