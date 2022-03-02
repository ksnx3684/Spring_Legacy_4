package com.ksnx3684.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ksnx3684.s1.MyJunitTest;
import com.ksnx3684.s1.util.Pager;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void check() {
		assertNotNull(noticeDAO);
	}
	
//	@Test
	public void listTest(Pager pager) throws Exception {
		List<NoticeDTO> ar = noticeDAO.list(pager);
		
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		
		assertNotNull(noticeDTO);
	}
	
	@Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		noticeDTO.setTitle("t1");
		noticeDTO.setContents("C1");
		noticeDTO.setWriter("w1");
		noticeDTO.setRegDate(null);
		noticeDTO.setHit(1);
		int result = noticeDAO.add(noticeDTO);
		
		assertEquals(1, result);
	}

//	@Test
	public void deleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		int result = noticeDAO.delete(noticeDTO);
		
		assertEquals(1, result);
	}
	
}
