package chapter11;

import java.util.Objects;

//VO(Value Object): 데이터를 저장하는 객체
//DTO(Data Transfer Object) : 데이터를 전달하는 객체
//Bean = >자바 커피 원두(bean) => 데이터를 저장하는 객체를 표현
//Item, Model 등과 같은 접미사를 붙이기도 함 
//Lombok: 필드에 접근하기 위해 많은 메소드를 써야 하는 불편함을 없애기 위한 것 
//Kotlin언어: jetBrain (intellij를 만든 회사)
public class Member1 {

	private String name;
	private int id;

	// contstructor : 값을 초기화 하기 위함
	public Member1(String name, int id) {
		this.name = name;
		this.id = id;
	}

	// private필드에 접근하기 위함
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//hashCode ,equals 
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Member1)) {
			return false;
		}
		Member1 other = (Member1) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	
	//toString
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
		return "Member [name=" + name + ", id=" + id + "]";
		
	}

}
