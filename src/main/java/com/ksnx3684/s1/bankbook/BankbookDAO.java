package com.ksnx3684.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankbookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ksnx3684.s1.bankbook.BankbookDAO.";
	
	// list
	public List<BankbookDTO> list() throws Exception {
		return sqlSession.selectList(NAMESPACE+"list");
	}
	
	// add
	public int add(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", bankbookDTO);
	}
	
	// detail
	public BankbookDTO detail(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail", bankbookDTO);
	}
	
	// delete
	public int delete(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", bankbookDTO);
	}
	
}
