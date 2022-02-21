package com.ksnx3684.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {

	@Autowired
	private BankbookService bankbookService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		// ModelAndView
		// 1. 매개변수 선언
		// 2. 또는 메서드내에서 객체 생성
		List<BankbookDTO> ar = bankbookService.list();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/list");
		return mv;	
	}
	
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(BankbookDTO bankbookDTO, Model model) throws Exception {
		bankbookDTO = bankbookService.detail(bankbookDTO);
		model.addAttribute("dto", bankbookDTO);
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
	public String delete(BankbookDTO bankbookDTO) throws Exception {
		int result = bankbookService.delete(bankbookDTO);
		return "redirect:./list";
	}
}
