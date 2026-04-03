package com.study.Board.domain.board;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class BoardResponse {

    private Long id;                        // PK
    private String title;                   // タイトル
    private String content;                 // 内容
    private String writer;                  // 作成者
    private int viewCnt;                    // 閲覧数
    private LocalDateTime createdDate;      // 作成日時
    private LocalDateTime modifiedDate;     // 最終修正日時
}