package com.study.Board.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    
    
    // 会員情報の保存 (会員登録)
    @Transactional
    public Long saveMember(MemberRequest params) {
        params.encodingPassword(passwordEncoder);	// 登録の時パスワードEncoding
        memberMapper.save(params);
        return params.getId();
    }

    
    // 会員詳細情報の照会
    public MemberResponse findMemberByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    
    // 会員情報の修正
    @Transactional
    public void updateMember(MemberRequest params) {
        params.encodingPassword(passwordEncoder);	// 修正の時パスワードEncoding
        memberMapper.update(params);
    }

    
    // 会員情報の削除 (退会処理)
    @Transactional
    public Long deleteMemberById(Long id) {
        memberMapper.deleteById(id);
        return id;
    }

 
    // 会員数のカウント (ID重複チェック用)
    public int countMemberByLoginId(String loginId) {
        return memberMapper.countByLoginId(loginId);
    }
    
    
    
    // ログイン処理
    public MemberResponse login(String loginId, String password) {
        
        // 会員情報およびパスワードの照会
        MemberResponse member = findMemberByLoginId(loginId);
        String encodedPassword = (member == null) ? "" : member.getPassword();
        
        System.out.println(member);

        // 会員情報の存在確認およびパスワードの照合
        if (member == null || passwordEncoder.matches(password, encodedPassword) == false) {
            return null;
        }

        // レスポンスオブジェクトからパスワードを除去した後、会員情報を返却
        member.clearPassword();
        
        System.out.println("MemberService member : " + member);
        
        return member;
    }
    
    
    public MemberResponse getMemberById(Long id) {
    	
    	return memberMapper.findById(id);
    }
}