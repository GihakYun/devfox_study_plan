package com.study.Board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SearchDto {

    private int page;                 // 現在のページ番号
    private int recordSize;           // 1ページあたりのデータ数
    private int pageSize;             // 画面下部に表示するページサイズ
    private String keyword;           // 検索キーワード
    private String searchType;        // 検索タイプ
    private Pagination pagination;    // ページネーション情報

    public SearchDto() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

}