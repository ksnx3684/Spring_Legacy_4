package com.ksnx3684.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ksnx3684.s1.MyJunitTest;
import com.ksnx3684.s1.util.Pager;

public class BankbookDAOTest extends MyJunitTest {

	@Autowired
	private BankbookDAO bankbookDAO;
		
	@Test
	public void check() {
		assertNotNull(bankbookDAO);
	}
	
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BankbookDTO> ar = bankbookDAO.list(pager);
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(9).getBookNumber());
		assertNotEquals(9, ar.size());
	}

//	@Test
//	public void addTest() throws Exception {
//		for(int i = 0; i < 200; i++) {
//			BankbookDTO bankbookDTO = new BankbookDTO();
//			bankbookDTO.setBookName("bookName" + i);
//			bankbookDTO.setBookContents("Contents"+ i);
//			
//			double rate = Math.random(); // 0.0 ~ 1.0 미만 0.12345678
//			rate = rate*1000; // 123.45678
//			int r = (int)rate; // 123
//			rate = r/100.0; //1.23
//			
//			bankbookDTO.setBookRate(rate); // 총 3자리, 소숫점 2자리
//			bankbookDTO.setBookSale(1);
//			int result = bankbookDAO.add(bankbookDTO);
//			
//			if(i%10 == 0)
//				Thread.sleep(1000);
//		}
//		System.out.println("Insert Finish");
////		assertEquals(1, result);
//	}
//	
////	@Test
//	public void detailTest() throws Exception {
//		BankbookDTO bankbookDTO = new BankbookDTO();
//		bankbookDTO.setBookNumber(1L);
//		bankbookDTO = bankbookDAO.detail(bankbookDTO);
//		
//		assertNotNull(bankbookDTO);
//	}
//	
////	@Test
//	public void deleteTest() throws Exception {
//		BankbookDTO bankbookDTO = new BankbookDTO();
//		bankbookDTO.setBookNumber(2L);
//		int result = bankbookDAO.delete(bankbookDTO);
//		
//		assertEquals(1, result);
//	}
}
