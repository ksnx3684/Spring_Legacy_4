package com.ksnx3684.s1.board;

import java.util.List;

import com.ksnx3684.s1.util.Pager;

public interface BoardDAO {

	// list
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	// detail
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	// total
	public Long total(Pager pager) throws Exception;
	
	// add
	public int add(BoardDTO boardDTO) throws Exception;
	
	// addFile
	public int addFile(BoardFileDTO boardFileDTO) throws Exception;
	
	// update
	public int update(BoardDTO boardDTO) throws Exception;
	
	// delete
	public int delete(BoardDTO boardDTO) throws Exception;
}
