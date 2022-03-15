package com.ksnx3684.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ksnx3684.s1.board.BoardDTO;
import com.ksnx3684.s1.board.qna.QnaDAO;
import com.ksnx3684.s1.board.qna.QnaDTO;
import com.ksnx3684.s1.member.MemberDTO;

@Component
public class WriterInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = true;
		
		Long num = Long.parseLong(request.getParameter("num"));
		
		BoardDTO boardDTO = new QnaDTO();
		boardDTO.setNum(num);
		boardDTO = qnaDAO.detail(boardDTO); // boardDTO에 qnaDAO에 있는 값 대입
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			check = false;
			// 1. forward
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("path", "./list");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			// 2. redirect
		}
		
		
		return check;
	}
}
