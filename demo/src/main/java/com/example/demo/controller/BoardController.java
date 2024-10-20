package com.example.demo.controller;

import com.example.demo.DTO.ToClient.BoardViewResponse;
import com.example.demo.DTO.ToClient.StatusResponse;
import com.example.demo.DTO.ToServer.BoardAddRequest;
import com.example.demo.DTO.ToServer.BoardViewWithCategoryRequest;
import com.example.demo.DTO.ToServer.BoardViewWithIdxRequest;
import com.example.demo.DTO.ToServer.CommentAddRequest;  // 댓글 추가 DTO
import com.example.demo.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "BoardController", description = "APIs related to Boards and Comments")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 1. 게시글 작성
    @PostMapping("/api/board/add")
    @Operation(summary = "Add a new Board", description = "게시글 추가(jwt, boardCategory, boardTitle, boardContent, boardEmail).")
    public StatusResponse createPost(@RequestBody BoardAddRequest boardRequest) {
        return boardService.createPost(boardRequest);  // 서비스에서 요청을 처리하고 상태 반환
    }

    // 2. 전체 게시글 불러오기
    @PostMapping("/api/board/view-all")
    @Operation(summary = "Get all Boards", description = "모든 게시글 불러오기(jwt, boardCategory) 댓글 목록은 고유 idx 사용할 때만, 여기서는 빈 배열 전송.")
    public List<BoardViewResponse> getAllPosts(@RequestBody BoardViewWithCategoryRequest request) {
        return boardService.getAllPosts(request);  // 서비스에서 요청을 처리하고 게시글 목록 반환
    }

    // 3. 특정 게시글 불러오기
    @PostMapping("/api/board/view-specific")
    @Operation(summary = "Get a specific Board", description = "게시글의 고유 idx 사용해서 특정 게시물 불러오기(jwt, boardIdx).")
    public BoardViewResponse getPostWithComments(@RequestBody BoardViewWithIdxRequest request) {
        return boardService.getPostWithComments(request);  // 서비스에서 요청을 처리하고 게시글 및 댓글 정보 반환
    }

    // 4. 댓글 작성
    @PostMapping("/api/comment/add")
    @Operation(summary = "Add a Comment", description = "게시글에 댓글 추가(jwt, commentBoardIdx, commentContent, commentEmail)")
    public StatusResponse addComment(@RequestBody CommentAddRequest commentRequest) {
        return boardService.addComment(commentRequest);  // 서비스에서 요청을 처리하고 상태 반환
    }
}
