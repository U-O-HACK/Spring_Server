package com.example.demo.DTO.ToClient;

import java.time.LocalDateTime;

public class CommentViewResponse {
    private int commentIdx;  // 댓글 고유 idx
    private int commentBoardIdx;  // 게시글 고유 idx
    private LocalDateTime commentWriteTime;  // 댓글 작성 시간
    private String commentContent;  // 댓글 내용

    public CommentViewResponse(int commentIdx, int commentBoardIdx, LocalDateTime commentWriteTime, String commentContent) {
        this.commentIdx = commentIdx;
        this.commentBoardIdx = commentBoardIdx;
        this.commentWriteTime = commentWriteTime;
        this.commentContent = commentContent;
    }

    // Getters and Setters
    public int getCommentIdx() {
        return commentIdx;
    }

    public void setCommentIdx(int commentIdx) {
        this.commentIdx = commentIdx;
    }

    public int getCommentBoardIdx() {
        return commentBoardIdx;
    }

    public void setCommentBoardIdx(int commentBoardIdx) {
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

}
