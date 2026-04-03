package com.study.Board.domain.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.Board.dto.SearchDto;

@Mapper
public interface BoardMapper {
    
    // 掲示物の保存
    void save(BoardRequest params);

    // 掲示物の詳細情報照会
    BoardResponse findById(Long id);
    
    // 掲示物の修正
    void update(BoardRequest params);

    // 掲示物の削除
    void deleteById(Long id);

    // 掲示物リストの照会
    List<BoardResponse> findAll(SearchDto params);

    // 掲示物数のカウント
    int count(SearchDto params);

}