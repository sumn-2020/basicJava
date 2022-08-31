package exercise20220831.exercise3;

public class Book {
	private int number; // 관리번호
	private String title; // 책의제목
	private String autor;// 책의저자
	private static int countOfBooks; // 만들어진 book 객체 개수, 선언과 동시에 0으로 초기화

	
	public Book(String title, String autor) {
		// 주어진 인자로 해당 필드를 초기화해주고, 관리번호(number)필드는
		// 현재 countOfBooks 값으로 한 뒤 countOfBooks를 1만큼 증가시킨다
		this.title = title;
		this.autor = autor;
		number = countOfBooks++;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return autor;
	}

	public void setAuthor(String autor) {
		this.autor = autor;
	}

	public int getLateFee(int lateDays) {
		// 연체료를 계산하는 추상메소드
		return lateDays;

	}

	public boolean equals(Object objects) {//Object objects = new Novel("칼의 노래", "김훈");
		// 제목과 저자가 같으면 true 반환
		if(this.title.equals(((Book)objects).title) && this.autor.equals(((Book)objects).autor)) {
			return true;
		}
		return false;
		
		//this.title (책 속의 title)
		//object[1] (1번째에 들어있는 책 그 자체)
		//Object를 book으로 만들려면 Book으로 강제캐스팅 시켜서 책한권으로 바꾼후 그 책 속의 title을 빼내와야됨 
	}

	public int hashCode() {
		return 0;
	}

	public String toString() {
		// 책의 제목과 저자를 문자열로 반환
		return String.format("관리번호: %d번, 제목 %s, 작가: %s(일주일 연체료: %,d원)", (number + 1), title, autor, getLateFee(number) * 7);

	}

}
