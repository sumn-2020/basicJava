package kr.or.ddit.Board.service;

import java.util.List;

import kr.or.ddit.Board.vo.BoardVO;

/**
 * 컨트롤러의 요청을 받아 처리하는 서비스의 Interface
 */

public interface IBoardService {



	/**
	 * 글 등록하기 위한 메서드
	 * @param bv 등록할 데이터가 저장된 BoardVO객체
	 * @return 글등록이 성공하면 1 이상의 값이 반환됨
	 */
	public int registBoard(BoardVO bv);
	
	
	/**
	 * 주어진 글번호가 존재하는지 여부를 알아내기 위한 메서드
	 * @param boardNum 확인대상 글번호
	 * @return 해당 글이 있으면 true, 없으면 false
	 */
	public boolean checkBoard(String boardNum);
	
	
	/**
	 * 글을 수정하기 위한 메서드
	 * @param bv update할 글정보가 들어있는 BoardVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int modifyBoard(BoardVO bv);
	
	
	
	/**
	 * 글번호를 매개변수로 받아서 해당 글을 삭제하는 메서드
	 * @param boardNum 삭제할 글번호
	 * @return 작업성공 :1 , 작업실패: 0
	 */
	public int removeBoard(int boardNum);
	
	
	
	/**
	 * 전체 게시글을 조회하기 위한 메서드
	 * @return 글정보를 담고있는 LIst타입의 객체
	 */
	public List<BoardVO> selectAllBoard();
	
	
	
	/**
	 * 검색
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
	
	
}
