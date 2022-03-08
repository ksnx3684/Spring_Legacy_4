package com.ksnx3684.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksnx3684.s1.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// list
	public List<QnaDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		
		Long totalcount = qnaDAO.total(pager);
		pager.makeNum(totalcount);
		List<QnaDTO> list = qnaDAO.list(pager);
		return list;
	}
	
	// add
	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}
	
	// detail
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.detail(qnaDTO);
	}
	
	// update
	public int update(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.update(qnaDTO);
	}
	
	// delete
	public int delete(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.delete(qnaDTO);
	}

}
