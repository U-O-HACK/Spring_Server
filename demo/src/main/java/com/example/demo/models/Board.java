package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
public class Board {

    @Id
    @Column(name = "board_idx", length = 50)
    private String boardIdx;  // 고유 idx (Primary Key)

    @Column(name = "board_category", nullable = false)
    private int boardCategory;  // 게시판 카테고리

    @Column(name = "board_title", length = 128, nullable = false)
    private String boardTitle;  // 게시글 제목

    @Column(name = "board_content", length = 1024, nullable = false)
    private String boardContent;  // 게시글 내용

    @Column(name = "board_write_time", nullable = false)
    private LocalDateTime boardWriteTime;  // 게시글 작성 시간

    @Column(name = "board_email", length = 128, nullable = false)
    private String boardEmail;  // 게시글 작성 유저

    // Getters and Setters
    public String getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(String boardIdx) {
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

    public String getBoardEmail() {
        return boardEmail;
    }

    public void setBoardEmail(String boardEmail) {
        this.boardEmail = boardEmail;
    }
}
