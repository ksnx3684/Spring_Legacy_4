package com.ksnx3684.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksnx3684.s1.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, Pager pager) throws Exception {
		List<NoticeDTO> ar = noticeService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "notice/list";
	}
	
	// detail
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	// add 이동
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() throws Exception {
		
	}
	
	// add 추가
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
	
	// delete 이동
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public void delete() throws Exception {
		
	}
	
	// delete 삭제
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public void delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
	}
	

}
