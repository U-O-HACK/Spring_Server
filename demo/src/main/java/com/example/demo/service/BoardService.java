package com.example.demo.service;

import com.example.demo.DTO.ToClient.BoardViewResponse;
import com.example.demo.DTO.ToClient.CommentViewResponse;
import com.example.demo.DTO.ToClient.StatusResponse;
import com.example.demo.DTO.ToServer.BoardAddRequest;
import com.example.demo.DTO.ToServer.CommentAddRequest;
import com.example.demo.DTO.ToServer.BoardViewWithCategoryRequest;
import com.example.demo.DTO.ToServer.BoardViewWithIdxRequest;
import com.example.demo.models.Board;
import com.example.demo.models.Comment;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    // 1. 게시글 작성
    public StatusResponse createPost(BoardAddRequest boardRequest) {
        try {
            if (JwtUtil.validateToken(boardRequest.getJwt())) { // JWT 검증
                Board board = new Board();
                board.setBoardCategory(boardRequest.getBoardCategory());
                board.setBoardTitle(boardRequest.getBoardTitle());
                board.setBoardContent(boardRequest.getBoardContent());
                board.setBoardEmail(boardRequest.getBoardEmail());
                board.setBoardWriteTime(LocalDateTime.now()); // 현재 시간 설정

                boardRepository.save(board);
                return new StatusResponse("200"); // 성공
            }
            return new StatusResponse("-999"); // JWT가 유효하지 않음
        } catch (Exception e) {
            return new StatusResponse("1601"); // 게시글 작성 중 오류 발생
        }
    }

    // 2. 전체 게시글 불러오기 (카테고리 필터링)
    public List<BoardViewResponse> getAllPosts(BoardViewWithCategoryRequest request) {
        try {
            if (!JwtUtil.validateToken(request.getJwt())) {
                return List.of(new BoardViewResponse(
                        "-999", // JWT 유효하지 않음
                        0,
                        0,
                        null,
                        null,
                        null,
                        List.of()
                ));
            }

            // 카테고리에 따라 게시글 필터링
            List<Board> boards = boardRepository.findByBoardCategory(request.getBoardCategory());

            // BoardViewResponse로 변환
            return boards.stream().map(board -> new BoardViewResponse(
                    "200",  // 성공 상태
                    board.getBoardIdx(),
                    board.getBoardCategory(),
                    board.getBoardTitle(),
                    board.getBoardContent(),
                    board.getBoardWriteTime(),
                    List.of() // 댓글은 비어있는 리스트로 초기화
            )).collect(Collectors.toList());
        } catch (Exception e) {
            return List.of(new BoardViewResponse(
                    "1701", // 게시글 조회 중 오류 발생
                    0,
                    0,
                    null,
                    null,
                    null,
                    List.of()
            ));
        }
    }

    // 3. 특정 게시글 불러오기 (게시글 정보, 댓글 포함)
    public BoardViewResponse getPostWithComments(BoardViewWithIdxRequest request) {
        try {
            Optional<Board> boardOptional = boardRepository.findById(request.getBoardIdx());
            if (boardOptional.isPresent()) {
                Board board = boardOptional.get();

                // 댓글 조회
                List<Comment> comments = commentRepository.findByCommentBoardIdx(request.getBoardIdx());

                // 댓글 정보를 CommentViewResponse로 변환
                List<CommentViewResponse> commentResponses = comments.stream()
                        .map(comment -> new CommentViewResponse(
                                comment.getCommentIdx(),
                                comment.getCommentBoardIdx(),
                                comment.getCommentWriteTime(),
                                comment.getCommentContent()
                        ))
                        .collect(Collectors.toList());

                // BoardViewResponse 생성하여 반환
                return new BoardViewResponse(
                        "200", // 성공 상태
                        board.getBoardIdx(),
                        board.getBoardCategory(),
                        board.getBoardTitle(),
                        board.getBoardContent(),
                        board.getBoardWriteTime(),
                        commentResponses
                );
            }
            return new BoardViewResponse(
                    "1801", // 게시글을 찾을 수 없음
                    0,
                    0,
                    null,
                    null,
                    null,
                    List.of()
            );
        } catch (Exception e) {
            return new BoardViewResponse(
                    "1901", // 게시글 조회 중 오류 발생
                    0,
                    0,
                    null,
                    null,
                    null,
                    List.of()
            );
        }
    }

    // 4. 댓글 작성
    public StatusResponse addComment(CommentAddRequest request) {
        try {
            Comment comment = new Comment();
            comment.setCommentBoardIdx(request.getCommentBoardIdx());
            comment.setCommentContent(request.getCommentContent());
            comment.setCommentEmail(request.getCommentEmail());
            comment.setCommentWriteTime(LocalDateTime.now()); // 현재 시간 설정

            commentRepository.save(comment);
            return new StatusResponse("200"); // 성공
        } catch (Exception e) {
            return new StatusResponse("2001"); // 댓글 작성 중 오류 발생
        }
    }
}
