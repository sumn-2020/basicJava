package kr.or.ddit.Board.dao;

import java.util.List;

import kr.or.ddit.Board.vo.BoardVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행 후 결과를 작성하여 서비스에 전달하는 DAO Interface
 */
public interface IBoardDao {


	/**
	 * BoardVO에 담겨진 데이터를 DB에 insert하는 메서드 
	 * @param bv DB에 insert할 데이터가 저장된 BoardVo객체
	 * @return DB작업이 성공하면 1이상의 값이 반환됨
	 */
	public int insertBoard(BoardVO bv);
	
	
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내기 위한 메서드
	 * @param boardNum 확인대상 글번호
	 * @return 해당 글번호 있으면 true, 없으면 false
	 */
	public boolean checkBoard(String boardNum);

	
	/**
	 * 하나의 BoardVO객체를 이용하여 DB정보를 update하는 메서드
	 * @param bv update할 회원정보가 들어있는 BoardVO객체
	 * @return 작업성공 : 1, 작업실패: 0
	 */
	public int updateBoard(BoardVO bv);
	
	
	/**
	 * 글번호를 매개변수로 받아서 해당 글을 삭제하는 메서드
	 * @param boardNum 삭제할 글번호
	 * @return 작업성공: 1, 작업실패 : 0
	 */
	public int deleteBoard(int boardNum);
	
	
	/**
	 * DB 테이블에 존재하는 전체 글을 조회하기 위한 메서드 (전체보기)
	 * @return 글 정보를 담고있는 List타입의 객체
	 */
	public List<BoardVO> selectAllBoard();
	
	
	/**
	 * 검색 메서드 
	 * @param bv
	 * @return
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
	
	
	
	
	
	
	
	
	
	
	
	
	

}
