package kr.or.ddit.Board.service;

import java.util.List;

import kr.or.ddit.Board.dao.BoardDaoImpl;
import kr.or.ddit.Board.dao.IBoardDao;
import kr.or.ddit.Board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	//데이터베이스 관련된 작업은 Dao에게 위임
	//나머지 비즈니스 로직은 service본인이 함 
	private IBoardDao boardDao;
	private static IBoardService boardService;
	public BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	
	@Override
	public int registBoard(BoardVO bv) {
		//야! Dao야! insert좀 해줘
		int cnt = boardDao.insertBoard(bv);
		return cnt;
	}

	@Override
	public boolean checkBoard(String boardNum) {
		boolean exist = boardDao.checkBoard(boardNum);
		return exist;
	}


	@Override
	public int modifyBoard(BoardVO bv) {
		int cnt = boardDao.updateBoard(bv);
		return cnt;
	}


	@Override
	public int removeBoard(String boardNum) {
		int cnt = boardDao.deleteBoard(boardNum);
		return cnt;
	}


	@Override
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> boardList = boardDao.selectAllBoard();
		return boardList;
	}


	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		List<BoardVO> searchList = boardDao.searchBoard(bv);
		return searchList;
		
	}
	
	
	
	
	

}
