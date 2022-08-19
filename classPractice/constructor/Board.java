package classPractice.constructor;

public class Board {
	
	String title;
	String content;
	String writer;
	String date;
	int hitcount;
	
	
	//매개변수가 하나용 생성자 
	Board(String title) {
		this(title, null, null, null, 0); 
		//받아오는 값(title)이외에는 전부 default값으로 넣어준다(String의 기본값 null, int의 기본값 0)
		//제일하단에 있는 매개변수를 최대로 가지고 있는 생성자로 값을 보내줌 
	}
	
	//매개변수가 두개용 생성자
	Board(String title, String content) {
		this(title, content, null, null, 0); 
	}
	
	//매개변수가 세개용 생성자
	Board(String title, String content, String writer){
		this(title, content, writer, null ,0);
	}
	
	//매개변수가 네개용 생성자
	Board(String title, String content, String writer, String date) {
		this(title, content, writer, date, 0);
	}
	
	//매개변수가 최대로 나온 생성자 (다른 생성자들의 값을 받아서 최종적으로 수행)
	Board(String title, String content, String writer, String date, int hitcount) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = hitcount;
	}
	
	
	
	
	
	
	
	
}
