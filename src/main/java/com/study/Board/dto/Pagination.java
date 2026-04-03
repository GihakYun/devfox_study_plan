package com.study.Board.dto;

import lombok.Getter;

@Getter
public class Pagination {

    private int totalRecordCount;     // 全体データ数
    private int totalPageCount;       // 全体ページ数
    private int startPage;            // 最初のページ番号
    private int endPage;              // 最後のページ番号
    private int limitStart;           // LIMIT 開始位置
    private boolean existPrevPage;    // 前のページが存在するかどうか
    private boolean existNextPage;    // 次のページが存在するかどうか

    public Pagination(int totalRecordCount, SearchDto params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(params);
        }
    }

    private void calculation(SearchDto params) {

        // 全体ページ数の計算
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) + 1;

        // 現在のページ番号が全体ページ数より大きい場合、現在のページ番号に全体ページ数を設定
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // 最初のページ番号の計算
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // 最後のページ番号の計算
        endPage = startPage + params.getPageSize() - 1;

        // 最後のページ番号が全体ページ数より大きい場合、最後のページに全体ページ数を設定
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT 開始位置の計算
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        // 前のページが存在するかどうかの確認
        existPrevPage = startPage != 1;

        // 次のページが存在するかどうかの確認
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }

}