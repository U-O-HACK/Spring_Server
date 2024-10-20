package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "carson")
public class Carson {

    @Id
    @Column(name = "carson_day", nullable = false)
    private String carsonDay;

    @Column(name = "carson_date", nullable = false)
    private LocalDate carsonDate;

    @Column(name = "carson_breakfast", length = 512)
    private String carsonBreakfast;

    @Column(name = "carson_breakfast_gpt", length = 1024)
    private String carsonBreakfastGpt;

    @Column(name = "carson_lunch", length = 512)
    private String carsonLunch;

    @Column(name = "carson_lunch_gpt", length = 1024)
    private String carsonLunchGpt;

    @Column(name = "carson_dinner", length = 512)
    private String carsonDinner;

    @Column(name = "carson_dinner_gpt", length = 1024)
    private String carsonDinnerGpt;

    // Getters and setters 생략
    public Carson() {
    }
    public Carson(String carsonDay, LocalDate carsonDate, String carsonBreakfast, String carsonBreakfastGpt, String carsonLunch, String carsonLunchGpt, String carsonDinner, String carsonDinnerGpt) {
        this.carsonDay = carsonDay;
        this.carsonDate = carsonDate;
        this.carsonBreakfast = carsonBreakfast;
        this.carsonBreakfastGpt = carsonBreakfastGpt;
        this.carsonLunch = carsonLunch;
        this.carsonLunchGpt = carsonLunchGpt;
        this.carsonDinner = carsonDinner;
        this.carsonDinnerGpt = carsonDinnerGpt;
    }

    public String getCarsonDay() {
        return carsonDay;
    }

    public void setCarsonDay(String carsonDay) {
        this.carsonDay = carsonDay;
    }

    public LocalDate getCarsonDate() {
        return carsonDate;
    }

    public void setCarsonDate(LocalDate carsonDate) {
        this.carsonDate = carsonDate;
    }

    public String getCarsonBreakfast() {
        return carsonBreakfast;
    }

    public void setCarsonBreakfast(String carsonBreakfast) {
        this.carsonBreakfast = carsonBreakfast;
    }

    public String getCarsonBreakfastGpt() {
        return carsonBreakfastGpt;
    }

    public void setCarsonBreakfastGpt(String carsonBreakfastGpt) {
        this.carsonBreakfastGpt = carsonBreakfastGpt;
    }

    public String getCarsonLunch() {
        return carsonLunch;
    }

    public void setCarsonLunch(String carsonLunch) {
        this.carsonLunch = carsonLunch;
    }

    public String getCarsonLunchGpt() {
        return carsonLunchGpt;
    }

    public void setCarsonLunchGpt(String carsonLunchGpt) {
        this.carsonLunchGpt = carsonLunchGpt;
    }

    public String getCarsonDinner() {
        return carsonDinner;
    }

    public void setCarsonDinner(String carsonDinner) {
        this.carsonDinner = carsonDinner;
    }

    public String getCarsonDinnerGpt() {
        return carsonDinnerGpt;
    }

    public void setCarsonDinnerGpt(String carsonDinnerGpt) {
        this.carsonDinnerGpt = carsonDinnerGpt;
    }
}

