package com.study.Board.domain.member;

import java.time.LocalDate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequest {

    private Long id;                // 会員番号(PK)
    private String loginId;         // ログインID
    private String password;        // パスワード
    private String name;            // 名前
    private char gender;            // 性別
    private LocalDate birthday;     // 生年月日

    /**
     * パスワードの暗号化
     * @param passwordEncoder
     */
    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(password)) {
            return;
        }
        // パスワードを暗호化して再設定
        password = passwordEncoder.encode(password);
    }
}