package com.study.Board.domain.member;

import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ToString
public class MemberResponse {

    private Long id;                        // 会員番号(PK)
    private String loginId;                 // ログインID
    private String password;                // パスワード
    private String name;                    // 名前
    private char gender;                    // 性別
    private LocalDate birthday;             // 生年月日
    private Boolean deleteYn;               // 削除フラグ
    private LocalDateTime createdDate;      // 作成日時
    private LocalDateTime modifiedDate;     // 最終更新日時

    // パスワード情報の初期化
    public void clearPassword() {
        this.password = "";
    }
}