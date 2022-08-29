package Exercise20220826.Exercise1;

public class Student extends Human {
	
	//필드
	private String major; //전공
	
	//생성자
	public Student(String name, int age, String major) {
		super(name, age); //부모의 필드를 가져올땐 super!!!!! 
		//this.name = name;
		//this.age = age;
		this.major = major;
	}
	
	//메소드
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String toString() {
		return super.toString() + ",전공: " + major;
	}

}
