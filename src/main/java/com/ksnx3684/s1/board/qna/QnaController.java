package com.ksnx3684.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ksnx3684.s1.board.BoardDTO;
import com.ksnx3684.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = qnaService.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	// total
	@RequestMapping(value = "total", method = RequestMethod.GET)
	public void total() throws Exception {
		
	}
	
	// add
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/add";
	}
	
	// add 추가
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO, MultipartFile[] files) throws Exception {
		int result = qnaService.add(qnaDTO, files);
		return "redirect:./list";
	}
	
	// delete 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
	
	// update 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	// update 수정작업
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	}
	
	// reply 이동
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("dto", qnaDTO); // 부모 글 번호
		return "board/reply";
	}
	
	// reply 작업
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.reply(qnaDTO);
		return "redirect:./list";
	}
	
	// 파일 다운로드 기능
	@RequestMapping(value = "photoDown", method = RequestMethod.GET)
	public ModelAndView fileDown(QnaFileDTO qnaFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fileDown"); // @component로 annotation한 fileDown 클래스를 실행
		
		qnaFileDTO = qnaService.detailFile(qnaFileDTO);
		
		mv.addObject("file", qnaFileDTO);
		
		return mv;
	}
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(QnaFileDTO qnaFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.fileDelete(qnaFileDTO);
		
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
}
