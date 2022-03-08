package com.ksnx3684.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksnx3684.s1.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {

	@Autowired
	private BankbookService bankbookService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		// ModelAndView
		// 1. 매개변수 선언
		// 2. 또는 메서드내에서 객체 생성
		List<BankbookDTO> ar = bankbookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("bankbook/list");
		return mv;	
	}
	
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BankbookDTO bankbookDTO, Model model) throws Exception {
		bankbookDTO = bankbookService.detail(bankbookDTO);
		
		// 조회가 성공하면 출력
		// 조회가 실패하면 alert로 '없는 번호 입니다' 출력 후 다시 list 이동
		// common.result.jsp 활용
		String view = "common/result";
		
		if(bankbookDTO != null) {
			view = "bankbook/detail";
			model.addAttribute("dto", bankbookDTO);
		} else {
			model.addAttribute("message", "없는 번호입니다");
			model.addAttribute("path", "./list");
		}
		
		return view;
		
	}
	
	// add form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		
	}
	
	// DB에 add
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankbookDTO bankbookDTO) throws Exception {
		int result = bankbookService.add(bankbookDTO);
		return "redirect:./list";
	}
	
	// DB에서 delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankbookDTO bankbookDTO, Model model) throws Exception {
		int result = bankbookService.delete(bankbookDTO);
		
		String view = "common/result";
		
		if(result != 0) {
			model.addAttribute("message", "삭제되었습니다");
			model.addAttribute("path", "./list");
		} else {
			model.addAttribute("message", "삭제에 실패했습니다");
			model.addAttribute("path", "./list");
		}
		
		return view;
	}
	
	// update
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankbookDTO bankbookDTO, Model model) throws Exception {
		bankbookDTO = bankbookService.detail(bankbookDTO);
		model.addAttribute("dto", bankbookDTO);
	}
	
	// update 수정작업
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankbookDTO bankbookDTO) throws Exception {
		int result = bankbookService.update(bankbookDTO);
		return "redirect:./list";
	}
}
