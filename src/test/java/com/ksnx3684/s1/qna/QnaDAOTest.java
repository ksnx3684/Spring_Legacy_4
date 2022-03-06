package com.ksnx3684.s1.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ksnx3684.s1.MyJunitTest;
import com.ksnx3684.s1.util.Pager;

public class QnaDAOTest extends MyJunitTest{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void check() {
		assertNotNull(qnaDAO);
	}
	
	@Test
	public void listTest(Pager pager) throws Exception {
		List<QnaDTO> list = qnaDAO.list(pager);
		
		assertNotEquals(0, list.size());
	}
	
	@Test
	public void detailTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(1L);
		qnaDTO = qnaDAO.detail(qnaDTO);
		
		assertNotNull(qnaDTO);
	}
	
	@Test
	public void addTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(3L);
		qnaDTO.setTitle("t1");
		qnaDTO.setContents("c1");
		qnaDTO.setWriter("w1");
		qnaDTO.setRegDate(null);
		qnaDTO.setHit(0);
		qnaDTO.setRef(0);
		qnaDTO.setStep(0);
		qnaDTO.setDepth(0);
		int result = qnaDAO.add(qnaDTO);
		
		assertEquals(1, result);
	}
		
	@Test
	public void deleteTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(3L);
		int result = qnaDAO.delete(qnaDTO);
		
		assertEquals(1, result);
	}
}
