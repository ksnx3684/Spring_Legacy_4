package com.ksnx3684.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankbookService {
	// Controller -> Service -> DAO
	// DAO로 데이터를 보내기 전에 전처리 작업
	// DAO에서 리턴받은 데이터를 Controller로 보내기 전처리 작업
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	// 메서드는 DAO의 메서드와 거의 동일
	
	// list
	public List<BankbookDTO> list() throws Exception {
		// DAO에서 호출 전 전처리 작업
		// 호출 후 후처리 작업
		List<BankbookDTO> ar = bankbookDAO.list();
		
		return ar;
	}
	
	// detail
	public BankbookDTO detail(BankbookDTO bankbookDTO) throws Exception {
		
		return bankbookDAO.detail(bankbookDTO);
	}
	
	// add
	public int add(BankbookDTO bankbookDTO) throws Exception {
		
		return bankbookDAO.add(bankbookDTO);
	}

}
