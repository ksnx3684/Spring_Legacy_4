package com.ksnx3684.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ksnx3684.s1.member.MemberDTO;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		boolean check = true;
		
		if(memberDTO == null) {
			check = false;
			// 1. forward 형식 - servlet 문법사용
//			request.setAttribute("message", "로그인이 필요합니다");
//			request.setAttribute("path", "../member/login");
//			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
//			view.forward(request, response);
			
			// 2. redirect 방식
			response.sendRedirect("../member/login");
			
		}
		
		return check;
	}
}
