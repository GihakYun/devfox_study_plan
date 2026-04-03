package com.study.Board.domain.comment;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentResponse {

    private Long id;                        // コメント番号 (PK)
    private Long boardId;                   // 掲示物番号 (FK)
    private Long memberId;                  // メンバー番号 (FK)
    private String content;                 // 内容
    private String writer;                  // 作成者
    private Boolean deleteYn;               // 削除済みフラグ (Y/N)
    private LocalDateTime createdDate;      // 作成日時
    private LocalDateTime modifiedDate;     // 最終修正日時

}