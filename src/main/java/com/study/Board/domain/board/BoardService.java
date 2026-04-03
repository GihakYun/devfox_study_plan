package com.study.Board.domain.board;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.Board.dto.Pagination;
import com.study.Board.dto.PagingResponse;
import com.study.Board.dto.SearchDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
    

    private final BoardMapper boardMapper;

    // 掲示物の保存
    public Long saveBoard(BoardRequest params) {
        boardMapper.save(params);
        return params.getId();
    }

    // 掲示物の詳細情報照会
    public BoardResponse findBoardById(Long id) {
        return boardMapper.findById(id);
    }

    // 掲示物の修正
    @Transactional
    public Long updateBoard(BoardRequest params) {
        boardMapper.update(params);
        return params.getId();
    }

    // 掲示物の削除
    public Long deleteBoard(Long id) {
        boardMapper.deleteById(id);
        return id;
    }

    // 掲示物リストの照회
    public PagingResponse<BoardResponse> findAllBoard(SearchDto params) {

        // 条件に該当するデータがない場合、空のリストとnullを返却
        int count = boardMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Paginationオブジェクトを生成してページ情報を計算後、SearchDtoオブジェクトに計算されたページ情報を設定
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 計算されたページ情報(limitStart, recordSize)を基準にリストデータを照会し、レスポンスデータを返却
        List<BoardResponse> list = boardMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }
}