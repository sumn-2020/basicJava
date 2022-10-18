package kr.or.ddit.Board.vo;

import java.util.Date;

public class BoardVO {

	private String boardNum;
	private String boardTit;
	private String boardWriter;
	private Date boardDate;
	private String boardCont;
	
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTit() {
		return boardTit;
	}
	public void setBoardTit(String boardTit) {
		this.boardTit = boardTit;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardCont() {
		return boardCont;
	}
	public void setBoardCont(String boardCont) {
		this.boardCont = boardCont;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardTit=" + boardTit + ", boardWriter=" + boardWriter
				+ ", boardDate=" + boardDate + ", boardCont=" + boardCont + "]";
	}


	
}
