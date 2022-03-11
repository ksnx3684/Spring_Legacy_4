package com.ksnx3684.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ksnx3684.s1.board.BoardDTO;
import com.ksnx3684.s1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, Pager pager) throws Exception {
		List<BoardDTO> list = noticeService.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	// total
	@RequestMapping(value = "total", method = RequestMethod.GET)
	public void total() throws Exception {
		
	}
	
	// add 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/add";
	}
	
	// add 추가
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, MultipartFile[] files) throws Exception {
		int result = noticeService.add(noticeDTO, files);
		return "redirect:./list";
	}
	
	// delete 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
		return "redirect:./list";
	}
	
	// update 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	// update 수정작업
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:./list";
	}

}
