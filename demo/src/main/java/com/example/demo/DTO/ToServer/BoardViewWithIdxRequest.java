package com.example.demo.DTO.ToServer;

public class BoardViewWithIdxRequest {
    private String jwt;
    private int boardIdx;

    public BoardViewWithIdxRequest(String jwt, int boardIdx) {
        this.jwt = jwt;
        this.boardIdx = boardIdx;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(int boardIdx) {
        this.boardIdx = boardIdx;
    }
}
