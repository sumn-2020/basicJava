package finalPractice;

public class Person {
	final String nation = "korea"; //final에 담겼기 때문에 nation에는 korea만 담겨있고 값이 변하지 않는다. 
	final String ssn;
	String name; // final이 붙어 있지 않기때문에 언제든 값을 초기화 시킬 수 있다. 
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name; 
	}
}
