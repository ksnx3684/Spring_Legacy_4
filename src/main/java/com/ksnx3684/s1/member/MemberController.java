package com.ksnx3684.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	// join 페이지 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
		
	}
	// 회원가입 기능
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception {
		int result = memberService.join(memberDTO);
		return "redirect:../";
	}
	
	// login 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(value="remember", defaultValue = "", required = false)String rememberId) throws Exception {
		// model.addAttribute("remember", rememberId); // 아이디 기억 기능
		
	}
	//login 기능
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, MemberDTO memberDTO, String remember, Model model, HttpServletResponse response) throws Exception {
		
		if(remember != null && remember.equals("1")) {
			// 쿠키 생성
			Cookie cookie = new Cookie("remember", memberDTO.getId());
//			cookie.setPath("/");
			cookie.setMaxAge(-1);
			// 응답
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberDTO = memberService.login(memberDTO);
		
		String path = "redirect:./login";
		
		if(memberDTO != null) { // sql상에서 id와 pw가 맞으면 id, name값을 반환하고 틀리면 null값을 반환한다
			session.setAttribute("member", memberDTO);
			path = "redirect:../";
		}
		
		return path;
		
	}
	
	// logout 기능
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	// mypage 이동
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(HttpSession session, Model model) throws Exception { // session에 담긴 id값을 불러와서
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member"); // MemberDTO로 형변환하여 담는다
		memberDTO = memberService.mypage(memberDTO);
		
		model.addAttribute("dto", memberDTO);
	}
	
}
