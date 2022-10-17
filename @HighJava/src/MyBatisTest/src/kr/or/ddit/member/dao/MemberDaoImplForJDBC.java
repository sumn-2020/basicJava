package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDaoImplForJDBC implements IMemberDao {
	
	//싱글톤으로 만들기
	private static IMemberDao memDao;
	private MemberDaoImplForJDBC() {
	}
	public static IMemberDao getIntance() {
		if(memDao == null) { //아직 객체를 한번도 만든적 없다면
			memDao = new MemberDaoImplForJDBC(); //한번은 객체를 만들어야됨
		}
		//한번이라도 객체를 만든적 있다면
		return memDao;
	}
	
	
	
	
	
	

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;

		try {

			// 1. connection 만들기
			conn = JDBCUtil3.getConnection();

			// 2. sql쿼리 가져오기
			String sql = "insert into mymember " + " (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR, REG_DT)"
					+ " values(?, ?, ?, ?,  sysdate)";

			// 3. prepareStatement객체 만들기
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			// 4. 쿼리 날리기
			cnt = pstmt.executeUpdate();

			// DAO가 아니라 View가 해주는 역할이기 때문에 삭제!
			/*
			 * if (cnt > 0) { System.out.println(memId + " 회원정보 추가 성공 "); } else {
			 * System.out.println(memId + "회원정보 추가 실패"); }
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 5. 자원반납 close
			JDBCUtil3.close(conn, stmt, pstmt, rs);

		}

		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {

		boolean exist = false;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "select count(*) as cnt " + " from mymember " + " where mem_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			int cnt = 0;

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				exist = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return exist;
	}

	@Override
	public int updateMember(MemberVO mv) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "update mymember " + " set MEM_NAME = ?, " + " MEM_TEL = ?, " + " MEM_ADDR = ? "
					+ " where MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());

			cnt = pstmt.executeUpdate();

			// DAO가 아니라 View가 해주는 역할이기 때문에 삭제!
			/*
			 * if (cnt > 0) { System.out.println(memId + " 회원정보 수정 성공."); } else {
			 * System.out.println(memId + " 회원정보 수정 실패!!!"); }
			 */

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "delete from mymember where mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();
//			if (cnt > 0) {
//				System.out.println(memId + " 회원정보 삭제 성공 ");
//			} else {
//				System.out.println(memId + "회원정보 삭제 실패");
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {

		List<MemberVO> memList = new ArrayList<MemberVO>();

		try {

			conn = JDBCUtil3.getConnection();

			String sql = "select * from mymember";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MemberVO mv = new MemberVO();
				mv.setMemId(rs.getString("mem_id"));
				mv.setMemName(rs.getString("mem_name"));
				mv.setMemTel(rs.getString("mem_tel"));
				mv.setMemAddr(rs.getString("mem_addr"));

				memList.add(mv);

				// 뷰가 하는 작업이므로 DAO에서는 삭제
				// System.out.println(memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);
			}

			// 뷰가 하는 작업이므로 DAO에서는 삭제
			// System.out.println("-----------------------");
			// System.out.println("출력작업 끝");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {

		List<MemberVO> memList = new ArrayList<MemberVO>(); 

		try {

			conn = JDBCUtil3.getConnection();

			
			//다이나믹하게 동적으로 조회조건 만들기 (모든 경우의 수 생각해서 쿼리 짜기) 
			//id로만 검색했을 경우, 이름으로만 검색했을 경우, 아이디와 이름으로만 검색했을 경우, 주소로만 검색했을 경우 ....
			String sql = "select * from mymember where 1=1";

			if (mv.getMemId() != null && !mv.getMemId().equals("")) {//id값이 null이 아니고, 빈문자열이 아닐경우 
				 sql += " and mem_id = ? ";
			}
			
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				 sql += " and mem_name = ? ";
			}
			
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				 sql += " and mem_tel = ? ";
			}
			
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				 sql += " and mem_addr like '%' || ? || '%' ";
			}

			pstmt = conn.prepareStatement(sql);
			
			
			
			int index = 1;
			if (mv.getMemId() != null && !mv.getMemId().equals("")) {//id값이 null이 아니고, 빈문자열이 아닐경우 
				pstmt.setString(index++, mv.getMemId());//index++ 디비 누적
			}
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				pstmt.setString(index++, mv.getMemName());
			}
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				pstmt.setString(index++, mv.getMemTel());
			}
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				pstmt.setString(index++, mv.getMemAddr());
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO mv2 = new MemberVO();
				mv2.setMemId(rs.getString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));
				memList.add(mv2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return memList;
	}

}
