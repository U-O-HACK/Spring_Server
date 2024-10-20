package com.example.demo.DTO.ToServer;

public class BoardViewWithCategoryRequest {
    private String jwt;
    private int boardCategory;  // 게시판 카테고리

    public BoardViewWithCategoryRequest(String jwt, int boardCategory) {
        this.jwt = jwt;
        this.boardCategory = boardCategory;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(int boardCategory) {
        this.boardCategory = boardCategory;
    }
}
