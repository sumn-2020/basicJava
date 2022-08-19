package classPractice.constructor;

public class BoardExample {
	public static void main(String[] args) {
		
		Board board1 = new Board("제목");
		System.out.println(board1.title);
		
		System.out.println();
		
		Board board2 = new Board("제목", "컨텐츠");
		System.out.println(board2.title);
		System.out.println(board2.content);
		
		System.out.println();
		
		Board board3 = new Board("제목", "컨텐츠", "작가");
		System.out.println(board3.title);
		System.out.println(board3.content);
		System.out.println(board3.writer);
		
		System.out.println();
		
		Board board4 = new Board("제목", "컨텐츠", "작가", "날짜");
		System.out.println(board4.title);
		System.out.println(board4.content);
		System.out.println(board4.writer);
		System.out.println(board4.date);
		
		System.out.println();

		Board board5 = new Board("제목", "컨텐츠", "작가", "날짜", 5);
		System.out.println(board5.title);
		System.out.println(board5.content);
		System.out.println(board5.writer);
		System.out.println(board5.date);
		System.out.println(board5.hitcount);
		
		
		
		
	}
}
