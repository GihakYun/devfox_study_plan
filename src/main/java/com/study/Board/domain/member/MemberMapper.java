package com.study.Board.domain.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	// 会員情報の保存 (会員登録)
    void save(MemberRequest params);

    // 会員詳細情報の照会
    MemberResponse findByLoginId(String loginId);

    // 会員情報の修正
    void update(MemberRequest params);

    // 会員情報の削除 
    void deleteById(Long id);

    // 会員数のカウント (ID重複チェック用)
    int countByLoginId(String loginId);

}