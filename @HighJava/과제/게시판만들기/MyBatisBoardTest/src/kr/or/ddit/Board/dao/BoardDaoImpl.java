package kr.or.ddit.Board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.Board.com.dao.MyBatisDao;
import kr.or.ddit.Board.vo.BoardVO;
import kr.or.ddit.util.JDBCUtil;

public class BoardDaoImpl extends MyBatisDao implements IBoardDao {

	private static IBoardDao boardDao;

	private BoardDaoImpl() {
	}

	public static IBoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		return insert("board.insertBoard", bv); // 실행할 쿼리 : board.xml파일 속에서 inserMember 아이디를 찾아서 그거 실행
	}

	@Override
	public boolean checkBoard(String boardNum) {

		boolean isExist = false;

		int cnt = (int) selectOne("board.checkBoard", boardNum);
		if (cnt > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return update("board.updateBoard", bv);
	}

	@Override
	public int deleteBoard(String boardNum) {
		return delete("board.deleteBoard", boardNum);
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		return selectList("board.selectAllBoard", null);
	}


	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		return selectList("board.searchBoard", bv);
	}


}
