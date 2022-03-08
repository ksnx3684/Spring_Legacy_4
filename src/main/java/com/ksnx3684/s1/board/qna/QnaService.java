package com.ksnx3684.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksnx3684.s1.board.BoardDTO;
import com.ksnx3684.s1.board.BoardService;
import com.ksnx3684.s1.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(qnaDAO.total(pager));
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return qnaDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);
	}
	
	// 부모 인터페이스에 없기 때문에 직접 만들어야함
	public int reply(QnaDTO qnaDTO) throws Exception {
		// 1. 부모의 정보를 조회(ref, step, depth)
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		
		// 2. 답글의 ref는 부모의 ref값
		qnaDTO.setRef(parent.getRef());
		
		// 3. 답글의 step은 부모의 step + 1
		qnaDTO.setStep(parent.getStep() + 1);
		
		// 4. 답글의 depth는 부모의 depth + 1
		qnaDTO.setDepth(parent.getDepth() + 1);
		
		// 5. step update
		int result = qnaDAO.stepUpdate(parent);
		
		// 6. 답글 insert
		result = qnaDAO.reply(qnaDTO);
		
		return result;
	}

}