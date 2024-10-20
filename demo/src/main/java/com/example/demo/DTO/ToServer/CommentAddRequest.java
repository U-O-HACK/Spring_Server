package com.example.demo.DTO.ToServer;

public class CommentAddRequest {
    private String jwt;               // JWT 토큰
    private int commentBoardIdx;   // 게시글 고유 idx
    private String commentContent;     // 댓글 내용
    private String commentEmail;       // 댓글 작성 유저 이메일

    // Getters and Setters
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getCommentBoardIdx() {
        return commentBoardIdx;
    }

    public void setCommentBoardIdx(int commentBoardIdx) {
        this.commentBoardIdx = commentBoardIdx;
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
