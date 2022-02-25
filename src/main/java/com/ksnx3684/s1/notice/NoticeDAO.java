package com.ksnx3684.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksnx3684.s1.util.Pager;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ksnx3684.s1.notice.NoticeDAO.";
	
	public List<NoticeDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail", noticeDTO);
	}
	
	public Long total() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"total");
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", noticeDTO);
	}
}
