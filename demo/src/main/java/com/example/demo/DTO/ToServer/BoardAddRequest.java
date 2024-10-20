package com.example.demo.DTO.ToServer;

public class BoardAddRequest {
    private String jwt;
    private int boardCategory;  // 게시판 카테고리
    private String boardTitle;  // 게시글 제목
    private String boardContent;  // 게시글 내용
    private String boardEmail;  // 게시글 작성 유저

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    // Getters and Setters
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

    public String getBoardEmail() {
        return boardEmail;
    }

    public void setBoardEmail(String boardEmail) {
        this.boardEmail = boardEmail;
    }
}
