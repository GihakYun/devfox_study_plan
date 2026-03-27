package com.study.Board.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.study.Board.domain.member.MemberResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// セッションから会員情報を取得
        HttpSession session = request.getSession();
        MemberResponse member = (MemberResponse) session.getAttribute("loginMember");

        // 会員情報の確認
        if (member == null || member.getDeleteYn() == true) {
            response.sendRedirect("/login.do");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
