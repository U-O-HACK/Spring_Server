package com.example.demo.repository;

import com.example.demo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // 특정 게시글의 댓글을 조회하는 메서드
    List<Comment> findByCommentBoardIdx(int commentBoardIdx);
}
