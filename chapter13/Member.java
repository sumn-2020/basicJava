package chapter13;

import java.util.Objects;

public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	//hashCode()와 equals 메소드를 재정의 한 이유: 
	// 인스턴스(new 객체)가 달라도 이름과 나이가 동일하다면 동일한 객체로 간주하여 중복 저장되지 않도록 하기 위해서 
	@Override
	public boolean equals(Object obj) { // name과 age값이 같으면 true를 리턴
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age);
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() { // name과 age값이 같으면 동일한 hashCode를 리턴
		return name.hashCode() + age;
	}

}
