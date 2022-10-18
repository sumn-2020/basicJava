package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.or.ddit.util.JDBCUtil3;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128),    -- 주소
    reg_dt DATE DEFAULT sysdate, -- 등록일
    CONSTRAINT MYMEMBER_PK PRIMARY KEY (mem_id)
);

insert into mymember(MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR, REG_DT)
values('a001', '홍길동', '12111-111', '대전시',  sysdate);

*/
public class T01MemberInfoTest {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner scan = new Scanner(System.in);
	
	
	
	//log4j2 단독으로 직접 로그를 남기기 위한 로거 객체 생성하기
	private static final Logger SQL_LOGGER = LogManager.getLogger("log4jexam.sql.Query"); //getLogger("아무 이름이나 짓기")
	private static final Logger PARAM_LOGGER = LogManager.getLogger("log4jexam.sql.Parameter"); 
	private static final Logger RESULT_LOGGER = LogManager.getLogger(T01MemberInfoTest.class); 
	
	

	

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				selectAllMember();
				break;
			case 5: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 5);
	}

	/**
	 * 전체 회원정보를 출력하기 위한 메서드
	 */
	private void selectAllMember() {

		System.out.println();
		System.out.println("-----------------------");
		System.out.println("ID\t이름\t전화번호\t주소");
		System.out.println("-----------------------");

		// jdbc코딩
		try {

			conn = JDBCUtil3.getConnection();

			String sql = "select * from mymember";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 하나씩 꺼내서
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");

				System.out.println(memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);
			}
			System.out.println("-----------------------");
			System.out.println("출력작업 끝");
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

	}

	/**
	 * 회원정보를 삭제하기 위한 메서드
	 */
	private void deleteMember() {

		System.out.println();
		System.out.println("삭제할 회원ID를 입력하세요");
		System.out.println("회원  ID >> ");

		String memId = scan.next();

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "delete from mymember where mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(memId + " 회원정보 삭제 성공 ");
			} else {
				System.out.println(memId + "회원정보 삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

	}

	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateMember() {

		boolean exist = false;

		String memId = "";

		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");

			memId = scan.next();

			exist = checkMember(memId);

			if (!exist) {
				System.out.println("회원ID가 " + memId + "인 회원은 존재하지 않습니다.");
				System.out.println("다시 입력해주세요.");
			}

		} while (!exist);

		System.out.print("회원 이름 >> ");
		String memName = scan.next();

		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine(); // 버퍼지우기
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "update mymember " + " set MEM_NAME = ?, " + " MEM_TEL = ?, " + " MEM_ADDR = ? "
					+ " where MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + " 회원정보 수정 성공.");
			} else {
				System.out.println(memId + " 회원정보 수정 실패!!!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 회원정보 추가하는 메서드
	 */
	private void insertMember() {

		boolean exist = false;

		String memId = "";

		do {

			System.out.println();
			System.out.println("추가할 회원정보를 입력하세요");
			System.out.println("회원  ID >> ");

			memId = scan.next();

			exist = checkMember(memId);

			if (exist) {
				System.out.println("회원ID가 " + memId + "인 회원은 이미 존재합니다.");
				System.out.println("다시 입력해주세요");
			}

		} while (exist); // exist가 true(= 사용자가 존재하는 동안은)

		System.out.print("회원이름 >> ");
		String memName = scan.next();

		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine(); // 버퍼 비우기 - 기존에 쳤던 엔터가 남아있는거 없애기

		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();

		// jdbc 코딩 시작
		try {

			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1. connection 만들기
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			// "practice", "java");
			conn = JDBCUtil3.getConnection(); // JDBCUtil3클래스에서 getConnection메소드 들고오기

			// 2. sql쿼리 가져오기
			String sql = "insert into mymember " + " (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR, REG_DT)"
					+ " values(?, ?, ?, ?,  sysdate)"; // 값이 변경되어야 되는건 전부 ?로
			
			
			//log4j2를 이용하여 console.log
			SQL_LOGGER.debug("sql : " + sql);  //sql이 어떤 모양인지 찍어보기
			

			// 3. prepareStatement객체 만들기
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId); // 1번째 ?에는 memId들어감
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			
			
			//log4j2를 이용하여 console.log
			PARAM_LOGGER.debug("파라미터정보 = > memId : " + memId + ", memName : " + memName +  ", memTel : " + memTel + ", memAddr : " + memAddr);
			

			// 4. 쿼리 날리기
			// execute"Query" = > select일때
			// execute"Update" => insert 등 그외 일때
			int cnt = pstmt.executeUpdate();
			
			
			//log4j2를 이용하여 console.log
			RESULT_LOGGER.info("결과 값 : {}", cnt);
			

			if (cnt > 0) { // insert 됐을 경우
				System.out.println(memId + " 회원정보 추가 성공 ");
			} else { // insert 안됐을 경우
				System.out.println(memId + "회원정보 추가 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 5. 자원반납 close
			JDBCUtil3.close(conn, stmt, pstmt, rs);
//			if(rs != null) try{ rs.close(); } catch(SQLException ex) {} //rs가 null이 아니면 close 시켜주기 
//			if(stmt != null) try{ stmt.close(); } catch(SQLException ex) {}
//			if(pstmt != null) try{ pstmt.close(); } catch(SQLException ex) {}
//			if(conn != null) try{ conn.close(); } catch(SQLException ex) {} //conn도  null이 아니면 close 시켜주기

		}

	}

	/**
	 * 회원ID를 이용하여 회원이 존재하는지 체크하기 위한 메서드
	 * 
	 * @param memId 체크할 회원 ID
	 * @return 존재하면 true, 존재하지 않으면 false
	 */
	private boolean checkMember(String memId) {

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

			if (cnt > 0) { // 존재한다면
				exist = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return exist;
	}

	public static void main(String[] args) {
		T01MemberInfoTest memObj = new T01MemberInfoTest();
		memObj.start();
	}

}
