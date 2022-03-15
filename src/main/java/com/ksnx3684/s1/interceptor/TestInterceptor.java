package com.ksnx3684.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Dispatcher Servlet에서 Controller로 진입 전 실행");
		// return이 true면 Controller로 계속 진행
		// return이 false면 Controller로 진행하지 않음
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Controller에서 Dispatcher Servlet으로 가기 전 실행");
		// TODO Auto-generated method stub
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("View(jsp)를 렌더링 후(HTML로 변환 후) 실행");
		// TODO Auto-generated method stub
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("비동기 방식으로 요청 시 postHandle과 aftercompletion을 수행하지 않고 이 메서드를 수행");
		// TODO Auto-generated method stub
	}
}
