package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil;

/*
위의 테이블을 작성하고 게시판을 관리하는
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


public class BoardJDBC {

	public static void main(String[] args) {

		new BoardJDBC().start();

	}
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in); 
	Map<String, BoardInfo> map =new HashMap<String, BoardInfo>();


	/**
	 * 메뉴를 출력하는 메서드
	 * @return 
	 */
	public void displayMenu(){


		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.전체 목록 출력 2.새글작성 3.수정 4.삭제 5.검색");
		System.out.println("*******************************************");
		System.out.println("메뉴선택 =>");

	}

	/**
	 * 프로그램 시작 메서드
	 */	
	public void start() {
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
			case 1 :  // 전체 목록 출력
				selectBoard();
				break;
			case 2 :  // 새 글 작성
				insertBoard();
				break;
			case 3 :  // 수정 
				updateBoard();
				break;
			case 4 :  // 삭제
				deleteBoard();
				break;
			case 5:  //검색
				searchBoard();
				break;
			case 6 :
				System.out.println("종료합니다");
				break;
			default :
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			}
		}while(choice!=6);
	}

	/**
	 * 검색하기 위한 메서드
	 */

	private void searchBoard() {


		System.out.println();
		System.out.println("게시물을 검색할 번호를 입력하세요.");
		System.out.println("번호 >> "); 
		String boardNo = scan.next();

		try {

			conn = JDBCUtil.getConnection();

			String sql = "select * from jdbc_board where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {

				boardNo = rs.getString("board_no");
				String boardTitle = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				String boardDate = rs.getString("board_date");
				String boardContent = rs.getString("board_content");


				System.out.println(boardNo+ "의 게시물 정보");
				
				  System.out.println("번    호 : " + rs.getString("board_no"));
				  System.out.println("제    목 : " +  rs.getString("board_title"));
				 System.out.println("작 성 자 : " +  rs.getString("board_writer"));
				  System.out.println("날    짜 : " +  rs.getString("board_date"));
				  System.out.println("내    용: " +  rs.getString("board_content"));
				 
			}
			System.out.println("---------------------------------------");
			System.out.println("출력 작업 끝.");

		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}




	/**
	 * 삭제 하기 위한 메서드
	 */
	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시물 번호를 입력하세요.");
		System.out.print("게시물 번호 >> ");

		String boardNo = scan.next();

		try {
			conn = JDBCUtil.getConnection();

			String sql = "delete from jdbc_board where board_no  = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);

			int cnt = pstmt.executeUpdate();

			if(cnt > 0) {
				System.out.println(boardNo + " 삭제 성공");
			} else {
				System.out.println(boardNo + " 삭제 실패!!!");
				System.out.println("다시 입력하세요.");
			}

		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	/**
	 * 새 글 작성하기 위한 메서드
	 */
	private void insertBoard() {

		String boardNo = "";
		String boardTitle ="";
		String boardWriter ="";
		String boardDate ="";
		String boardContent ="";

		System.out.println();
		System.out.println("새 글을 작성 하시겠습니까?");

		scan.nextLine();

		System.out.println("제목 : ");
		boardTitle = scan.nextLine();

		System.out.println("작성자 : ");
		boardWriter = scan.nextLine();

		System.out.println("내용 : ");
		boardContent = scan.nextLine();

		try {

			conn = JDBCUtil.getConnection();

			String sql = 
					" INSERT INTO jdbc_board (" + 
							"    board_no," + 
							"    board_title," + 
							"    board_writer," + 
							"    board_date," + 
							"    board_content" + 
							") VALUES (" + 
							"    board_seq.NEXTVAL,?,?,SYSDATE,?)"; 


			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardWriter);
			pstmt.setString(3, boardContent);


			int cnt = pstmt.executeUpdate();

			if(cnt > 0) {
				System.out.println(boardNo + " 작성 성공");
			} else {
				System.out.println(boardNo + " 작성 실패");
			}

		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 수정 하기 위한 메서드
	 */
	private void updateBoard() {
		boolean exist = false; // 사용자가 존재하지 않아야 새로 insert하니까 

		String boardNo = "";

		do {
			System.out.println();
			System.out.println("수정할 게시판 번호를 입력하세요.");
			System.out.print("게시판 번호 >> ");

			boardNo = scan.next();

			exist = checkNo(boardNo); // 회원이 존재하는지 확인

			if(!exist) {
				System.out.println(boardNo +"번의 게시물이 존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}

		} while(!exist);

		System.out.print("제목 >> ");
		String boardTitle = scan.next();

		System.out.print("작성자 >> ");
		String boardWriter= scan.next();

		scan.nextLine(); // 버퍼 비우기

		System.out.print("내용 >> ");
		String boardContent= scan.nextLine();

		try {

			conn = JDBCUtil.getConnection();

			String sql = " UPDATE JDBC_BOARD " + 
					"   SET board_title = ?," + 
					"   board_writer = ?," + 
					"   board_content =?" + 
					" WHERE board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardWriter);
			pstmt.setString(3, boardContent);
			pstmt.setString(4, boardNo);

			int cnt =  pstmt.executeUpdate();

			if(cnt > 0) {
				System.out.println(boardNo + "번 수정 성공");
			} else {
				System.out.println(boardNo + "번 수정 실패!!!");
			}


		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	/**
	 * 게시물이 존재하는지 체크하기 위한 메서드
	 * @param boardNo 체크할 게시물 번호
	 * @return 존재하면 true, 존재하지 않으면 false
	 */

	private boolean checkNo(String boardNo) {

		boolean exist = false;

		try {
			conn = JDBCUtil.getConnection();

			String sql = "select count(*) as cnt " 
					+ " from jdbc_board " 
					+ " where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);

			rs = pstmt.executeQuery();

			int cnt = 0;

			//집계함수(count)니까 1번밖에 안 돎.
			while(rs.next()) {
				cnt = rs.getInt("cnt"); 
			}

			if(cnt > 0) {
				exist = true;
			}


		}catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return exist;
	}


	/**
	 * 전체 목록 출력 하기 위한 메서드
	 */
	private void selectBoard() {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("번호 \t제목");
		System.out.println("---------------------------------------");

		try {

			conn = JDBCUtil.getConnection();

			String sql = "select * from jdbc_board";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				String boardNo = rs.getString("board_no");
				String boardTitle  = rs.getString("board_title");


				System.out.println(boardNo + "\t"
						+ boardTitle);
			}
			System.out.println("---------------------------------------");
			System.out.println("출력 작업 끝.");

		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}





}


class BoardInfo{
	//field
	private String boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardDate;
	private String boardContent;

	public BoardInfo(String boardNo, String boardTitle, String boardWriter, String boardDate, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
	}


	public BoardInfo(String boardTitle2) {
		// TODO Auto-generated constructor stub
	}


	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "BoardInfo [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardDate=" + boardDate + ", boardContent=" + boardContent + "]";
	}


}
