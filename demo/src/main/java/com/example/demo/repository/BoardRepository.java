package com.example.demo.repository;

import com.example.demo.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 카테고리에 따라 게시글을 조회하는 메서드
    List<Board> findByBoardCategory(int boardCategory);
}
