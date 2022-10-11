package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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

				break;
			case 3: // 자료 수정

				break;
			case 4: // 전체 자료 출력

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

		
		scan.nextLine(); //버퍼 비우기 - 기존에 쳤던 엔터가 남아있는거 없애기 
		
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		
		
		//jdbc 코딩 시작
		try {
			//1. connection 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
			
			//2. sql쿼리 가져오기
			String sql = "insert into mymember "
						+ " (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR, REG_DT)" 
					    + " values(?, ?, ?, ?,  sysdate)"; //값이 변경되어야 되는건 전부 ?로 
			
			//3. prepareStatement객체 만들기 
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId); //1번째 ?에는 memId들어감
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			
			//4. 쿼리 날리기
			//execute"Query" = > select일때 
			//execute"Update" => insert 등 그외 일때 
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) { //insert 됐을 경우
				System.out.println(memId + " 회원정보 추가 성공 ");
			}else { //insert 안됐을 경우
				System.out.println(memId + "회원정보 추가 실패");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			//5. 자원반납  close
			if(rs != null) try{ rs.close(); } catch(SQLException ex) {} //rs가 null이 아니면 close 시켜주기 
			if(stmt != null) try{ stmt.close(); } catch(SQLException ex) {}
			if(pstmt != null) try{ pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try{ conn.close(); } catch(SQLException ex) {} //conn도  null이 아니면 close 시켜주기
			
		}


		
	}

	private boolean checkMember(String memId) {
		
		return false;
	}

	public static void main(String[] args) {
		T01MemberInfoTest memObj = new T01MemberInfoTest();
		memObj.start();
	}

}
