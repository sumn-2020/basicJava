package chapter13.confirm;

import java.util.ArrayList;
import java.util.List;

//Data Access Object
public class BoardDao {

	public List<Board> getBoardList() {
		//리턴할 데이터 값들 만들어주기
		List<Board> list = new ArrayList<>();
		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));
		return list;
	}

}
