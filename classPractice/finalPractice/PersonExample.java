package finalPractice;

public class PersonExample {
	public static void main(String[] args) {
		Person person = new Person("12345-789", "홍길동");
		
		
		//person.nation = "미국"; //nation은 final로 지정해줬기 때문에 korea에서 값이 변하지 않는다. 
		System.out.println(person.nation);
		person.name = "김길자"; //name은 final이 붙어 있지 않으므로 언제든 값을 초기화 시켜서 변경시킬 수 있다. 
		System.out.println(person.name);
	}
}
