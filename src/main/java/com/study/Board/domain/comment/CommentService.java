package com.study.Board.domain.comment;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    // コメントの保存
    @Transactional
    public Long saveComment(CommentRequest params) {
        commentMapper.save(params);
        return params.getId();
    }

    // コメントの詳細情報照会
    public CommentResponse findCommentById(Long id) {
        return commentMapper.findById(id);
    }

    // コメントの修正
    @Transactional
    public Long updateComment(CommentRequest params) {
        commentMapper.update(params);
        return params.getId();
    }

    // コメントの削除
    @Transactional
    public Long deleteComment(Long id) {
        commentMapper.deleteById(id);
        return id;
    }

    // コメントリストの照会
    public List<CommentResponse> findAllComment(Long postId) {
        return commentMapper.findAll(postId);
    }

}