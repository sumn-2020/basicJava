package kr.or.ddit.Board;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.Board.service.BoardServiceImpl;
import kr.or.ddit.Board.service.IBoardService;
import kr.or.ddit.Board.vo.BoardVO;

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

public class BoardMain {


	
	private IBoardService boardService;

	private Scanner scan = new Scanner(System.in);

	public BoardMain() {
		boardService = BoardServiceImpl.getInstance();
	}

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
			case 6: // 종료
				System.out.println("종료되었습니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요");
			}

		} while (choice != 6); // 6이 아니면 do while문 빠져나가고 기면 계속 반복
	}
	


	private void searchBoard() {

		
		scan.nextLine(); // 퍼버 비우기
		System.out.println();
		System.out.println("검색할 게시글 정보를 입력하세요");
		
		System.out.println("게시글 번호 >> ");
		String boardNum = scan.nextLine().trim(); // 좌우 공백지우기 trim

		System.out.println("제목 >> ");
		String boardTit = scan.nextLine().trim();

		System.out.println("작성자 >> ");
		String boardWriter = scan.nextLine().trim();

		//scan.nextLine(); // 버퍼지우기
		System.out.println("내용  >> ");
		String boardCont = scan.nextLine().trim();
		
		BoardVO bv = new BoardVO();
		bv.setBoardNum(boardNum);
		bv.setBoardTit(boardTit);
		bv.setBoardWriter(boardWriter);
		bv.setBoardCont(boardCont);
		
		
		System.out.println();
		System.out.println("-------------------");
		System.out.println("글번호\t글제목\t작성자\t글내용\t작성일");
		System.out.println("-------------------");
		
		List<BoardVO> searchList = boardService.searchBoard(bv);
		
		if(searchList.size() == 0) {
			System.out.println("게시글이 존재하지 않습니다.");
		}else {
			for (BoardVO bv2 : searchList) {
				System.out.println(bv2.getBoardNum() + "\t" +  bv2.getBoardTit() + "\t" + bv2.getBoardWriter() + "\t" + 
						bv2.getBoardCont() + "\t" + bv2.getBoardDate());
			}
		}
		System.out.println("-----------------------");
		System.out.println("검색작업 끝");

		
		
	}

	private void selectAllBoard() {

		System.out.println();
		System.out.println("-------------------");
		System.out.println("글번호\t글제목\t작성자\t글내용\t작성일");
		System.out.println("-------------------");

		List<BoardVO> boardList = boardService.selectAllBoard();

		if (boardList.size() == 0) {
			System.out.println("회원정보가 존재하지 않습니다.");
		} else {
			for (BoardVO bv : boardList) {
				System.out.println(bv.getBoardNum() + "\t" +  bv.getBoardTit() + "\t" + bv.getBoardWriter() + "\t" + 
			bv.getBoardCont() + "\t" + bv.getBoardDate());
			}
		}
		System.out.println("-----------------------------");
		System.out.println("출력작업 끝");

	}

	private void deleteBoard() {

		System.out.println();
		System.out.println("삭제할 게시글번호를 입력하세요");
		System.out.println("글 번호 >> ");

		String boardNum = scan.next();

		int cnt = boardService.removeBoard(boardNum);
		if (cnt > 0) {
			System.out.println("게시글 삭제 성공");
		} else {
			System.out.println("게시글 삭제 실패");
		}

	}

	private void updateBoard() {
		boolean exist = false;

		String boardNum = "";
		//String boardCont = "";

		do {

			System.out.println();
			System.out.println("수정할 게시글 번호를 입력하세요.");
			System.out.println("게시글 번호 >> ");

			boardNum = scan.next();

			exist = boardService.checkBoard(boardNum);

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
		String boardCont = scan.nextLine();

		BoardVO bv = new BoardVO();
		bv.setBoardNum(boardNum);
		bv.setBoardTit(boardTit);
		bv.setBoardWriter(boardWriter);
		bv.setBoardCont(boardCont);

		int cnt = boardService.modifyBoard(bv);
		if (cnt > 0) {
			System.out.println("게시글 수정 성공");
		} else {
			System.out.println("게시글 수정 실패");
		}

	}

	/**
	 * 게시글을 추가하는 메서드 :새글작성
	 */
	private void insertBoard() {

		boolean exist = false;

		String boardNum = "";
		
		System.out.println("제목 >> ");
		String boardTit = scan.next();

		System.out.println("작성자 >> ");
		String boardWriter = scan.next();

		//scan.nextLine(); // 버퍼지우기
		System.out.println("내용  >> ");
		String boardCont = scan.next();

		BoardVO bv = new BoardVO();
		bv.setBoardNum(boardNum);
		bv.setBoardTit(boardTit);
		bv.setBoardWriter(boardWriter);
		bv.setBoardCont(boardCont);
		System.out.println("bv : " + bv.toString());
		int cnt = boardService.registBoard(bv);
		if (cnt > 0) { // insert 됐을 경우
			System.out.println("게시글 등록 성공");
		} else {
			System.out.println("게시글 등록 실패");
		}

	}

	// 실제 출력!!!!!
	public static void main(String[] args) {
		BoardMain boardObj = new BoardMain();
		boardObj.start();
	}

}
