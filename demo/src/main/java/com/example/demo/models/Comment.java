package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_idx", nullable = false)
    private int commentIdx;  // 게시판 댓글 idx

    @Column(name = "comment_board_idx", length = 50, nullable = false)
    private String commentBoardIdx;  // 게시글 고유 idx

    @Column(name = "comment_write_time", nullable = false)
    private LocalDateTime commentWriteTime;  // 댓글 작성 시간

    @Column(name = "comment_content", length = 512, nullable = false)
    private String commentContent;  // 댓글 내용

    @Column(name = "comment_email", length = 128, nullable = false)
    private String commentEmail;  // 댓글 작성 유저

    // Getters and Setters
    public int getCommentIdx() {
        return commentIdx;
    }

    public void setCommentIdx(int commentIdx) {
        this.commentIdx = commentIdx;
    }

    public String getCommentBoardIdx() {
        return commentBoardIdx;
    }

    public void setCommentBoardIdx(String commentBoardIdx) {
        this.commentBoardIdx = commentBoardIdx;
    }

    public LocalDateTime getCommentWriteTime() {
        return commentWriteTime;
    }

    public void setCommentWriteTime(LocalDateTime commentWriteTime) {
        this.commentWriteTime = commentWriteTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }
}
