package kr.or.ddit.Board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.Board.vo.BoardVO;
import kr.or.ddit.util.JDBCUtil;

public class BoardDaoImplJDBC implements IBoardDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertBoard(BoardVO bv) {

		int cnt = 0;

		try {

			// 1. connection 만들기
			conn = JDBCUtil.getConnection();

			// 2. sql쿼리 가져오기
			String sql = " insert into jdbc_board "
					+ " (board_no, board_title, board_writer, board_date, board_content) "
					+ " values(board_seq.nextval, ? , ?, sysdate, ?) ";

			// 3. prepareStatement 객체 만들기
			// prepareStatement(인자값) = connection 객체가 제공하는 메소드
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTit()); // 첫번째 물음표에 제목들어감
			pstmt.setString(2, bv.getBoardWriter()); // 작성자
			pstmt.setString(3, bv.getBoardCont()); // 내용

			// 4. 쿼리 날리기
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 5. 자원반납
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;

	}

	@Override
	public boolean checkBoard(String boardNum) {

		boolean exist = false;

		try {

			conn = JDBCUtil.getConnection();

			String sql = "select count(*) as cnt " + " from jdbc_board " + " where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);

			rs = pstmt.executeQuery();

			int cnt = 0;

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				exist = true;
			}

		} catch (Exception e) {
		}

		return exist;
	}

	@Override
	public int updateBoard(BoardVO bv) {

		int cnt = 0;

		try {

			conn = JDBCUtil.getConnection();

			String sql = " update jdbc_board " + " set board_title = ?, " + "     board_writer = ?, "
					+ "     board_content = ? " + " where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTit()); // 첫번째 물음표에 제목들어감
			pstmt.setString(2, bv.getBoardWriter()); // 작성자
			pstmt.setString(3, bv.getBoardCont()); // 내용
			pstmt.setString(4, bv.getBoardNum()); // 넘버

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public int deleteBoard(String boardNum) {

		int cnt = 0;

		try {
			conn = JDBCUtil.getConnection();

			String sql = "delete from jdbc_board where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public List<BoardVO> selectAllBoard() {

		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			conn = JDBCUtil.getConnection();

			String sql = "select * from jdbc_board";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setBoardNum(rs.getString("board_no"));
				bv.setBoardTit(rs.getString("board_title"));
				bv.setBoardWriter(rs.getString("board_writer"));
				bv.setBoardCont(rs.getString("board_content"));
				bv.setBoardDate(rs.getDate("board_date"));

				boardList.add(bv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return boardList;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {

		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {

			conn = JDBCUtil.getConnection();

			String sql = "SELECT * FROM JDBC_BOARD WHERE 1=1";

			if (bv.getBoardNum() != null && !bv.getBoardNum().equals("")) {
				sql += " and board_no = ? ";
			}

			if (bv.getBoardTit() != null && !bv.getBoardTit().equals("")) {
				sql += " and board_title like '%' || ? || '%' ";
			}

			if (bv.getBoardWriter() != null && !bv.getBoardWriter().equals("")) {
				sql += " and board_writer like '%' || ? || '%' ";
			}

			if (bv.getBoardCont() != null && !bv.getBoardCont().equals("")) {
				sql += " and board_content like '%' || ? || '%' ";
			}

			pstmt = conn.prepareStatement(sql);

			int index = 1;

			if (bv.getBoardNum() != null && !bv.getBoardNum().equals("")) {
				pstmt.setString(index++, bv.getBoardNum());
			}

			if (bv.getBoardTit() != null && !bv.getBoardTit().equals("")) {
				pstmt.setString(index++, bv.getBoardTit());
			}

			if (bv.getBoardWriter() != null && !bv.getBoardWriter().equals("")) {
				pstmt.setString(index++, bv.getBoardWriter());
			}

			if (bv.getBoardCont() != null && !bv.getBoardCont().equals("")) {
				pstmt.setString(index++, bv.getBoardCont());
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {

				BoardVO bv2 = new BoardVO();
				bv2.setBoardNum(rs.getString("board_no"));
				bv2.setBoardTit(rs.getString("board_title"));
				bv2.setBoardWriter(rs.getString("board_writer"));
				bv2.setBoardCont(rs.getString("board_content"));
				bv2.setBoardDate(rs.getDate("board_date"));

				boardList.add(bv2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return boardList;
	}

}
