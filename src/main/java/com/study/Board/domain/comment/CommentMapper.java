package com.study.Board.domain.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    // コメントの保存
    void save(CommentRequest params);

    // コメントの詳細情報照会
    CommentResponse findById(Long id);

    // コメントの修正
    void update(CommentRequest params);

    // コメントの削除
    void deleteById(Long id);

    // コメントリストの照会
    List<CommentResponse> findAll(Long postId);

    // コメント数のカウント
    int count(Long postId);

}