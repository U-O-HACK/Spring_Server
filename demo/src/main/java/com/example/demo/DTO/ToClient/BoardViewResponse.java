package com.example.demo.DTO.ToClient;

import java.time.LocalDateTime;
import java.util.List;

public class BoardViewResponse {
    private String status;
    private int boardIdx;  // 게시글 고유 idx
    private int boardCategory;  // 게시판 카테고리
    private String boardTitle;  // 게시글 제목
    private String boardContent;  // 게시글 내용
    private LocalDateTime boardWriteTime;  // 게시글 작성 시간
    private List<CommentViewResponse> comments; // 댓글 목록

    public BoardViewResponse(String status, int boardIdx, int boardCategory, String boardTitle, String boardContent, LocalDateTime boardWriteTime, List<CommentViewResponse> comments) {
        this.status = status;
        this.boardIdx = boardIdx;
        this.boardCategory = boardCategory;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriteTime = boardWriteTime;
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters and Setters


    public int getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(int boardIdx) {
        this.boardIdx = boardIdx;
    }

    public int getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(int boardCategory) {
        this.boardCategory = boardCategory;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public LocalDateTime getBoardWriteTime() {
        return boardWriteTime;
    }

    public void setBoardWriteTime(LocalDateTime boardWriteTime) {
        this.boardWriteTime = boardWriteTime;
    }

    public List<CommentViewResponse> getComments() {
        return comments;
    }

    public void setComments(List<CommentViewResponse> comments) {
        this.comments = comments;
    }
}
