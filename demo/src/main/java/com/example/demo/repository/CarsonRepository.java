package com.example.demo.repository;

import com.example.demo.models.Carson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarsonRepository extends JpaRepository<Carson, LocalDate> {
    boolean existsByCarsonDate(LocalDate carsonDate);
    List<Carson> findByCarsonDate(LocalDate carsonDate);

}
