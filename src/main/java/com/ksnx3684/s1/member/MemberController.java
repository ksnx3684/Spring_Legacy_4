package com.ksnx3684.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@ModelAttribute("board")
	public String board() {
		return "member";
	}

	// join 페이지 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
		
	}
	// 회원가입 기능
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, MultipartFile photo) throws Exception {
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getSize());
		int result = memberService.join(memberDTO, photo);
		return "redirect:../";
	}
	// join check
	@RequestMapping(value = "joinCheck", method = RequestMethod.GET)
	public void joinCheck() throws Exception {
		
	}
	
	// login 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(value="remember", defaultValue = "", required = false) String rememberId) throws Exception {
		// model.addAttribute("remember", rememberId); // model을 이용하여 아이디 기억 기능을 구현할 수도 있다. 단, 매개변수로 Model model을 선언할 것.
		
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
		
//		String path = "redirect:./login";
//		
//		if(memberDTO != null) { // sql상에서 id와 pw가 맞으면 id, name값을 반환하고 틀리면 null값을 반환한다
//			session.setAttribute("member", memberDTO);
//			path = "redirect:../";
//		}
		
		String message = "Login Fail";
		String p = "./login";
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			message = "Login Success";
			p="../";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		String path = "common/result";
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
	
	// 개인정보 변경 페이지
	@RequestMapping(value = "mychange", method = RequestMethod.GET)
	public void mychange(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.mypage(memberDTO);
		
		model.addAttribute("dto", memberDTO);
	}
	
	// 개인정보 변경 기능
	@RequestMapping(value = "mychange", method = RequestMethod.POST)
	public String mychange(MemberDTO memberDTO) throws Exception {
		int result = memberService.mychange(memberDTO);
	
		return "redirect:./mypage";
	}
	
	// 파일 다운로드 기능
	@RequestMapping(value = "photoDown", method = RequestMethod.GET)
	public ModelAndView fileDown(MemberFileDTO memberFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fileDown");
		
		memberFileDTO = memberService.detailFile(memberFileDTO);
		
		mv.addObject("file", memberFileDTO); // model에 "file" 이름으로 memberFileDTO 타입의 파일을 넣는다.
		
		return mv; // Filedown 클래스로 이동
		
		// model로 설정할 경우
		// 매개변수로 model을 추가로 불러오고 memberFileDTO에 대입하는 것은 동일하게 처리하고
		// return 타입을 String으로 설정후 return을 "fileDown"으로 준다
	}
}
