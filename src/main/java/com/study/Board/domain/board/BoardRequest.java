package com.study.Board.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {

    private Long id;             // PK
    private Long memberId;       // メンバーID
    private String title;        // タイトル
    private String content;      // 内容
    private String writer;       // 作成者
    
}
