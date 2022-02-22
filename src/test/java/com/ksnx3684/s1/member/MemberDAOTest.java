package com.ksnx3684.s1.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ksnx3684.s1.MyJunitTest;

public class MemberDAOTest extends MyJunitTest{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void check() {
		assertNotNull(memberDAO);
	}

////	@Test
//	public void joinTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("id3");
//		memberDTO.setPw("pw3");
//		memberDTO.setName("name3");
//		memberDTO.setPhone("010-2222-2222");
//		memberDTO.setEmail("email2@naver.com");
//		int result = memberDAO.join(memberDTO);
//		
//		assertEquals(1, result);
//	}
//	
////	@Test
//	public void loginTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("id3");
//		memberDTO.setPw("pw4");
//		
//		memberDTO = memberDAO.login(memberDTO);
//		
//		assertNotNull(memberDTO);
//	}
	
	@Test
	public void mypage() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id3");
		memberDTO = memberDAO.mypage(memberDTO);
		
		assertNotNull(memberDTO);
	}
}
