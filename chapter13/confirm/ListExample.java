package chapter13.confirm;

import java.util.List;

public class ListExample {
	public static void main(String[] args) {

		BoardDao dao = new BoardDao();

		List<Board> list = dao.getBoardList(); //getBoardList메소드에서 목록 정보를 들고와서 Board타입으로 list에 담아서 
		for (Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}

	}
}
