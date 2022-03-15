package com.ksnx3684.s1.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksnx3684.s1.board.BoardDAO;
import com.ksnx3684.s1.board.BoardDTO;
import com.ksnx3684.s1.board.BoardFileDTO;
import com.ksnx3684.s1.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ksnx3684.s1.board.notice.NoticeDAO.";
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail", boardDTO);
	}
	
	@Override
	public Long total(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"total", pager);
	}
	
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", boardDTO);
	}
	
	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"addFile", boardFileDTO);
	}
	
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}
	
	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", boardDTO);
	}
	
	public NoticeFileDTO detailFile(NoticeFileDTO noticeFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detailFile", noticeFileDTO);
	}
	
	public List<NoticeFileDTO> listFile(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"listFile", boardDTO);
	}
	
}
