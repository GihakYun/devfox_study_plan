package com.study.Board.domain.comment;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.Board.domain.member.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;
    private final MemberService memberService;

    // 新規コメント作成
    @PostMapping("/board/{boardId}/comments")
    public CommentResponse saveComment(@PathVariable("boardId") Long boardId, @RequestBody CommentRequest params) {
        Long id = commentService.saveComment(params);
        return commentService.findCommentById(id);
    }

    // コメントリストの照会
    @GetMapping("/board/{boardId}/comments")
    public List<CommentResponse> findAllComment(@PathVariable("boardId") Long boardId) {
        return commentService.findAllComment(boardId);
    }

    // コメントの詳細情報照会
    @GetMapping("/board/{boardId}/comments/{id}")
    public CommentResponse findCommentById(@PathVariable("boardId") Long boardId, @PathVariable("id") Long id) {
        return commentService.findCommentById(id);
    }

    // 既存コメントの修正
    @PatchMapping("/board/{boardId}/comments/{id}")
    public CommentResponse updateComment(
            @PathVariable("boardId") Long boardId, @PathVariable("id") Long id, @RequestBody CommentRequest params) {
        
        commentService.updateComment(params);
        return commentService.findCommentById(id);
    }
    
    // コメントの削除
    @DeleteMapping("/board/{boardId}/comments/{id}")
    public Long deleteComment(@PathVariable("boardId") Long boardId, @PathVariable("id") Long id) {
        return commentService.deleteComment(id);
    }
}