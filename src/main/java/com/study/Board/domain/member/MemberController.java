package com.study.Board.domain.member;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

    // ログインページ
    @GetMapping("/login.do")
    public String openLogin() {
        return "member/login";
    }
    
    // 会員登録ページ
    @GetMapping("/signup")
    public String openMemberSignup() {
        return "/member/signup";
    }
    
    // マイページ
    @GetMapping("/member/mypage")
    public String openMemberMypage() {
        return "/member/mypage";
    }
    
    // 会員情報修正ページ
    @GetMapping("/member/modify")
    public String openMemberModify(HttpServletRequest request, Model model) {
    	// セッション情報からユーザー情報を取得し、次の処理を準備する
        
        // セッションからログイン時に保存したloginMemberオブジェクトを取得
        HttpSession session = request.getSession();
        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

        // 未ログイン状態の場合、ログインページへリダイレクト
        if (loginMember == null) {
            return "redirect:/login.do";
        }
        
        System.out.println("loginMember" + loginMember);

        // 画面で使用できるようにモデルに格納
        model.addAttribute("member", loginMember);

        return "member/modify";
    }
    
    // 会員削除ページ
    @GetMapping("/member/delete")
    public String deleteMember(HttpServletRequest request, Model model) {
    	// セッション情報からユーザー情報を取得し、次の処理を準備する
    	
        // セッションからログイン時に保存したloginMemberオブジェクトを取得
        HttpSession session = request.getSession();
        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

        // 未ログイン状態の場合、ログインページへリダイレクト
        if (loginMember == null) {
            return "redirect:/login.do";
        }
        
        System.out.println("loginMember" + loginMember);

        // 画面で使用できるようにモデルに格納
        model.addAttribute("member", loginMember);
        
        return "member/delete";
    }
    
    // ID重複チェック (Ajax)
    @GetMapping("/member/check-id")
    @ResponseBody
    public boolean checkDupId(@RequestParam("loginId") String loginId) {
        
        if(memberService.countMemberByLoginId(loginId) == 1) {
            return true;    // 重複あり
        } else {
            return false;   // 重複なし
        }
    }
    
    // ログイン実行
    @PostMapping("/login")
    public String login(HttpServletRequest request) {

        // 会員情報の照会
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        
        MemberResponse member = memberService.login(loginId, password);
        
        System.out.println("Login Member : " + member);

        // セッションに会員情報を保存 ＆ セッション有効期限の設定
        if (member != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", member);
            session.setMaxInactiveInterval(60 * 30);
        } else {
            System.out.println("ユーザーログインエラー");
            return "redirect:/login.do";
        }
        
        return "redirect:/board/list.do";
    }

    // ログアウト
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();    // セッション破棄
        return "redirect:/login.do";
    }
    
    // 会員登録実行
    @PostMapping("/signup")
    public String saveMember(@ModelAttribute MemberRequest params) {
        System.out.println(params);
        memberService.saveMember(params);
        
        return "redirect:/login.do";
    }
    
    // 会員情報修正実行
    @PostMapping("/member/modify")
    public String doMemberModify(@ModelAttribute MemberResponse params) {
        
        String password = params.getPassword();
        // ID特定のため、loginIdから会員情報を再取得
        params = memberService.findMemberByLoginId(params.getLoginId());
        
        MemberRequest reqParams = new MemberRequest();
        reqParams.setId(params.getId());
        reqParams.setPassword(password);
        memberService.updateMember(reqParams);
        return "member/mypage";
    }
    
    // 会員削除(退会)実行
    @PostMapping("/member/delete")
    public String doMemberDelete(@ModelAttribute MemberResponse params) {
        
        // IDで会員を特定し、削除処理を実行
        memberService.deleteMemberById(params.getId());
        
        return "index";
    }
}