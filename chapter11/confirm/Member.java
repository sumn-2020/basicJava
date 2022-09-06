package chapter11.confirm;

public class Member {

	private String id;

	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s : %s", id, name);//toString 정의 하지 않으면 그냥 주소값이 출력됨 
	}

}
