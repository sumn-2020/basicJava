package kr.or.ddit.basic;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil;

/*
 * 위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
------------------------------------------------------------

게시판 테이블 구조 및 시퀀스

create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no)
);
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값
		
----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  시퀀스이름.nextVal
 */

public class BoardTest {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새글작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작 메서드
	 */
	public void start() {

		int choice; // 메뉴 출력

		do {
			displayMenu(); // 메뉴 쫘르륵 출력
			choice = scan.nextInt(); // 메뉴번호 입력

			switch (choice) {
			case 1: // 전체 목록 출력
				selectAllBoard();
				break;
			case 2: // 새글작성
				insertBoard();
				break;
			case 3: // 수정
				updateBoard();
				break;
			case 4: // 삭제
				deleteBoard();
				break;
			case 5: // 검색
				searchBoard();
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요");
			}

		} while (choice != 6); // 6이 아니면 do while문 빠져나가고 기면 계속 반복
	}

	/**
	 * 게시글을 추가하는 메서드 :새글작성
	 */
	private void insertBoard() {

		boolean exist = false;

		System.out.println("제목 >> ");
		String boardTit = scan.next();

		System.out.println("작성자 >> ");
		String boardWriter = scan.next();

		scan.nextLine(); // 버퍼지우기
		System.out.println("내용  >> ");
		String boardContent = scan.nextLine();

		// JDBC코딩시작
		try {

			// 반복되는 건 JDBCUtil에가다가 모아놓고 갖다써
			// 1) 드라이버 로딩하기 : Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2) connection만들기 : conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			// "practice", "java");

			// 1. connection 만든거 들고오기
			conn = JDBCUtil.getConnection();

			// 2. sql쿼리 가져오기
			/*
			 * insert into jdbc_board (board_no, board_title, board_writer, board_date,
			 * board_content) values(board_seq.nextval, '제목', '작성자', sysdate, '내용')
			 */
			String sql = " insert into jdbc_board "
					+ " (board_no, board_title, board_writer, board_date, board_content) "
					+ " values(board_seq.nextval, ? , ?, sysdate, ?) ";

			// 3. prepareStatement 객체 만들기
			//prepareStatement(인자값) = connection 객체가 제공하는 메소드
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTit); // 첫번째 물음표에 제목들어감
			pstmt.setString(2, boardWriter); // 작성자
			pstmt.setString(3, boardContent); // 내용

			// 4. 쿼리 날리기
			// executeUpdate() : 메소드가 반환하는 숫자값은 sql(update,delete,insert) 실행 후 영향을 받은 레코드의 개수
			// execute"Query" = > select일때
			// execute"Update" => insert 등 그외 일때
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) { // insert 됐을 경우
				System.out.println("게시글 등록 성공");
			} else {
				System.out.println("게시글 등록 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 자원반납
			JDBCUtil.close(conn, stmt, pstmt, rs);
			// 반복되는 건 JDBCUtil에가다가 모아놓고 갖다써
//			if(rs != null) try{ rs.close(); } catch(SQLException ex) {} //rs가 null이 아니면 close 시켜주기 
//			if(stmt != null) try{ stmt.close(); } catch(SQLException ex) {}
//			if(pstmt != null) try{ pstmt.close(); } catch(SQLException ex) {}
//			if(conn != null) try{ conn.close(); } catch(SQLException ex) {} //conn도  null이 아니면 close 시켜주기
		}
	}

	/**
	 * 전체 게시글을 출력하기 위한 메서드
	 */
	private void selectAllBoard() {

		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성일\t\t내용");
		System.out.println("--------------------------------------------------------------");

		// jdbc코딩
		try {
			conn = JDBCUtil.getConnection();

			String sql = "select * from jdbc_board";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 하나씩 꺼내서
				int boardNum = rs.getInt("board_no");
				Date boardDate = rs.getDate("board_date");

				String boardTit = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				String boardContent = rs.getString("board_content");

				System.out.println(
						boardNum + "\t" + boardTit + "\t" + boardWriter + "\t" + boardDate + "\t" + boardContent);
			}
			System.out.println("--------------------------------------------------------------");
			;
			System.out.println("출력작업 끝");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateBoard() {

		boolean exist = false;

		int boardNum = 0;

		do {

			System.out.println();
			System.out.println("수정할 게시글 번호를 입력하세요.");
			System.out.println("게시글 번호 >> ");

			boardNum = scan.nextInt();

			exist = checkBoard(boardNum);

			if (!exist) {
				System.out.println("게시글 번호" + boardNum + "번은 존재하지 않습니다.");
				System.out.println("다시 입력해주세요");
			}

		} while (!exist);

		System.out.print("제목 >> ");
		String boardTit = scan.next();

		System.out.print("작성자 >> ");
		String boardWriter = scan.next();

		scan.nextLine(); // 버퍼지우기
		System.out.print("내용  >> ");
		String boardContent = scan.nextLine();

		// jdbc코딩시작
		try {

			conn = JDBCUtil.getConnection();

			String sql = " update jdbc_board " + " set board_title = ?, " + "     board_writer = ?, "
					+ "     board_content = ? " + " where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTit); // 첫번째 물음표에 제목들어감
			pstmt.setString(2, boardWriter); // 작성자
			pstmt.setString(3, boardContent); // 내용
			pstmt.setInt(4, boardNum); // 넘버

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("게시글 수정 성공");
			} else {
				System.out.println("게시글 수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 게시글 번호를 이용하여 게시글이 존재하는지 체크하기 위한 메서드
	 * 
	 * @param boardNum 체크할 게시글 번호
	 * @return 존재하면 true, 존재하지 않으면 false
	 */
	private boolean checkBoard(int boardNum) {

		boolean exist = false;

		try {
			conn = JDBCUtil.getConnection();

			/*
			 * select count(*) as cnt from jdbc_board where board_no = 1
			 */
			String sql = "select count(*) as cnt " + " from jdbc_board " + " where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);

			rs = pstmt.executeQuery();

			int cnt = 0;

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) { // 존재한다면
				exist = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		return exist;
	}

	/**
	 * 게시글을 삭제하기 위한 메서드
	 */
	private void deleteBoard() {

		System.out.println();
		System.out.println("삭제할 게시글을 입력하세요");
		System.out.println("게시글 ID >> ");

		int boardNum = scan.nextInt();

		try {

			conn = JDBCUtil.getConnection();

			String sql = "delete from jdbc_board where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("게시글 삭제 성공 ");
			} else {
				System.out.println("게시글 삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 게시글 검색
	 * 
	 */
	private void searchBoard() {

		scan.nextLine(); // 버퍼비우기
		System.out.println();
		System.out.println("검색할 번호를 입력하세요");
		System.out.println("번호 >> ");

		int boardNum = scan.nextInt();

		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성일\t\t내용");
		System.out.println("--------------------------------------------------------------");

		// jdbc 코딩시작
		try {

			conn = JDBCUtil.getConnection();
			String sql = "select * from jdbc_board where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				boardNum = rs.getInt("board_no");
				String boardTit = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				Date boardDate = rs.getDate("board_date");
				String boardContent = rs.getString("board_content");

				System.out.println(boardNum + "\t" + boardTit + "\t" + boardWriter + "\t" + boardDate + "\t" + boardContent);
			}
			
			System.out.println("--------------------------------------------------------------");
			System.out.println("출력작업 끝");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	// 실제 출력!!!!!
	public static void main(String[] args) {
		BoardTest boardObj = new BoardTest();
		boardObj.start();
	}

}
