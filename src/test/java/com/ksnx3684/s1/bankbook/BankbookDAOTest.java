package com.ksnx3684.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ksnx3684.s1.MyJunitTest;

public class BankbookDAOTest extends MyJunitTest {

	@Autowired
	private BankbookDAO bankbookDAO;
		
//	@Test
	public void check() {
		assertNotNull(bankbookDAO);
	}
	
//	@Test
	public void listTest() throws Exception {
		List<BankbookDTO> ar = bankbookDAO.list();
		
		assertNotEquals(0, ar.size());
	}

	@Test
	public void addTest() throws Exception {
		for(int i = 0; i < 10; i++) {
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookName("bookName" + i);
			bankbookDTO.setBookContents("Contents"+ i);
			bankbookDTO.setBookRate(3.12+i);
			bankbookDTO.setBookSale(1);
			int result = bankbookDAO.add(bankbookDTO);
		}
		System.out.println("Insert Finish");
//		assertEquals(1, result);
	}
	
//	@Test
	public void detailTest() throws Exception {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(1L);
		bankbookDTO = bankbookDAO.detail(bankbookDTO);
		
		assertNotNull(bankbookDTO);
	}
	
//	@Test
	public void deleteTest() throws Exception {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(2L);
		int result = bankbookDAO.delete(bankbookDTO);
		
		assertEquals(1, result);
	}
}
