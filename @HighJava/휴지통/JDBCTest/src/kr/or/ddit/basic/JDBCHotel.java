package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCHotelUtil;

/*
//호텔 회원 관리 테이블 
create table hotel(
	    room_id varchar2(8) not null, -- 룸 ID
	    mem_name varchar2(100) not null, -- 회원이름
	    CONSTRAINT HOTEL_PK PRIMARY KEY (room_id) 
);

*/

public class JDBCHotel {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("메뉴선택 =>");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do { // 조건식이 true일 경우 계속 반복 false면 do while문 빠져나가기
			displayMenu(); // 메뉴출력
			choice = scan.nextInt(); // 메뉴번호 입력
			switch (choice) {
			case 1: // 1번 입력시 체크인
				insertMember();
				break;
			case 2: // 2번 입력시 체크아웃
				deleteMember();
				break;
			case 3: // 3번 입력시 객실상태
				selectAllRoom();
				break;
			case 4: // 4번 입력시 업무종료
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못입력했습니다. 다시입력하세요");
			}
		} while (choice != 4); // 4번이 아니면 계속 반복하고 4번이다? do while문 빠져나가기
	}

	/**
	 * 전체 객실상태 출력하기 위한 메서드
	 */
	private void selectAllRoom() {

		System.out.println();
		System.out.println("-----------------------");
		System.out.println("방번호\t이름");
		System.out.println("-----------------------");

		try {

			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
			conn = JDBCHotelUtil.getConnection();
			
			String sql = "select * from hotel";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 하나씩 꺼내서
				String roomId = rs.getString("room_id");
				String memName = rs.getString("mem_name");

				System.out.println(roomId + "\t" + memName);
			}
			// ResultSet(java.sql.ResultSet)은 executeQuery(String sql)을 통해 쿼리 실행하면
			// ResultSet타입으로 반환을 해주어 결과값을 저장할 수 있다.
			// next() 메소드를 통해, 선택되는 행을 바꿀 수 있다.
			// get타입() 메소드를 통해 데이터를 불러올 수 있다.
			
			System.out.println("-------------------------");
			System.out.println("출력작업 끝");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCHotelUtil.close(conn, stmt, pstmt, rs);
		}

	}

	/**
	 * 체크아웃 > 손님정보를 삭제하기 위한 메서드
	 */
	private void deleteMember() {

		System.out.println();
		System.err.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 => ");
		String roomId = scan.next();

		try {

			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
			conn = JDBCHotelUtil.getConnection();
			
			String sql = "delete from hotel where room_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomId);// 1번째 ?에는 roomId 넣기

			int cnt = pstmt.executeUpdate(); // executeUpdate() : 데이터베이스에서 데이터를 추가(Insert), 삭제(Delete), 수정(Update)하는 SQL
												// 문을 실행
			if (cnt > 0) {
				System.out.println(roomId + "방이 체크아웃되었습니다.");
			} else {
				System.out.println(roomId + "방 체크아웃이 실패되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCHotelUtil.close(conn, stmt, pstmt, rs);
		}

	}

	/**
	 * 체크인 > 손님정보 추가하는 메서드
	 */
	private void insertMember() {

		boolean exist = false; // 방 비어있음이 default

		String roomId = "";

		// 1. 방번호 입력
		do {

			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.println("방번호 입력");
			roomId = scan.next(); // 방번호 입력

			exist = checkRoom(roomId); // 방이 비어있는지 차있는지 확인해보기

			if (exist) { // exist 가 true일 경우(방이 존재할 경우, 방이 차있을 경우)
				System.out.println();
				System.out.println(roomId + "방에는 이미 사람이 있습니다.");
				System.out.println("다시 입력해주세요");
			}

		} while (exist);

		// 2. 이름입력
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 => ");
		String memName = scan.next();

		// jdbc 코딩 시작
		try {

			//Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1) Connection 만들기
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
			conn = JDBCHotelUtil.getConnection();
			
			
			// 2) sql 쿼리 만들기
			String sql = "insert into hotel(room_id, mem_name) " + " values(?, ?)";

			// 3) prepareStatement 객체 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomId); // 1번째 ?에는 roomId 넣기
			pstmt.setString(2, memName); // 2번째 ?에는 memName넣기

			// 4) 쿼리 날리기
			// executeUpdate() : 데이터베이스에서 데이터를 추가(Insert), 삭제(Delete), 수정(Update)하는 SQL 문을
			// 실행
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) { // cnt 내용물이 있을 경우 (insert 됐을 경우)
				System.out.println("체크인 되었습니다.");
			} else {
				System.out.println("체크인실패되었습니다. 다시 확인해주세요");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 JDBCHotelUtil.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * roomID를 이용하여 룸이 비어있는지 체크하기 위한 메서드
	 * 
	 * @param roomId 체크할 방번호
	 * @return 존재하면 true, 존재하지 않으면 false
	 */
	private boolean checkRoom(String roomId) {

		boolean exist = false;

		try {

			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
			conn = JDBCHotelUtil.getConnection();
			
			String sql = "select count(*) as cnt" + " from hotel " + " where room_id =? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomId);// 1번째 ?에는 roomId 넣기
			rs = pstmt.executeQuery(); // executeUpdate() : 데이터베이스에서 데이터를 추가(Insert), 삭제(Delete), 수정(Update)하는 SQL 문을
										// 실행

			int cnt = 0;
			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			// ResultSet(java.sql.ResultSet)은 executeQuery(String sql)을 통해 쿼리 실행하면
			// ResultSet타입으로 반환을 해주어 결과값을 저장할 수 있다.
			// next() 메소드를 통해, 선택되는 행을 바꿀 수 있다.
			// get타입() 메소드를 통해 데이터를 불러올 수 있다.

			if (cnt > 0) { // cnt에 내용물이 존재할 경우
				exist = true;
			}

		} catch (Exception e) {
			JDBCHotelUtil.close(conn, stmt, pstmt, rs);
		}

		return exist;
	}

	public static void main(String[] args) {
		JDBCHotel memObj = new JDBCHotel();
		memObj.start();
	}

}
