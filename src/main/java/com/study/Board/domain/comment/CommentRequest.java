package com.study.Board.domain.comment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequest {

    private Long id;           // コメント番号 (PK)
    private Long boardId;      // 掲示物番号 (FK)
    private Long memberId;     // メンバー番号 (FK)
    private String content;    // 内容
    private String writer;     // 作成者

}