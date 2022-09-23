package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T07EqualsHashcodeTest {

	/*
	 * 해시함수(hash function)는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑해주는 함수이다. 해시 함수에 의해 없어지는 값은
	 * 해시값, 해시코드, 해시 체크썸 또는 간단하게 해시라고 한다.
	 * 
	 * HashSet, HashMap, Hashable과 같은 객체들을 사용할 경우 객체가 서로 같은지 를 비교하기위해 equals()와
	 * hashCode()를 호출한다. 그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의해야 한다. Hashset,HashMap,
	 * Hashtable에서 객체가 같은지 여부는 데이터를 추가할 때 검사한다.
	 * 
	 * - equals() => 두 객체의 내용(값)이 같은지 비교하는 메서드 - hashCode() => 객체에 대한 해시코드값을 반환하는
	 * 메서드
	 * 
	 * -equals()와 hashCode()에 관한 규칙 1. 두 객체가 같으면 반드시 같은 hashcode를 가져야 한다. 2. 두 객체가
	 * 같으면 equals()메서드를 호출했을 때 true값은 반환해야 한다. 즉, 객체 a,b가 같다면 a.equals(b)와
	 * b.equals(a) 둘 다 true이여야 한다. 3. 두 객체의 hashcode가 같다고해서 두 객체가 반드시 같은 객체는 아니다.
	 * 하지만 두 객체가 같으면 반드시 hashcode가 같아야 한다. 4. equals()를 override하면 반드시 hashCode()도
	 * override 해야 한다. 5. hashCode()는 기본적으로 Heap 메모리에 있는 각 객체에 대한 메모리 주소 매핑 정보를 기반으로
	 * 한 정수값을 반환한다. 그러므로 클래스에서 hashCode()메서드를 override하지 않으면 절대로 두 객체가 같은 해시값을 반환하지
	 * 않는다.
	 * 
	 * - hashCode()에서 사용하는 '해싱알고리즘'에서 서로 다른 객체에 대하여 같은 hashCode값을 만들어 낼 수 있다. 그래서
	 * 객체가 같지 않더라도 hashcode값이 같을 수 있다.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");
		System.out.println("p1.equlas(p2) : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1 == p2));

		System.out.println("------------------------------");
		System.out.println();

		// set => 중복 불가 but hashset은 hashcode를 이용할 수 있음
		// hashCode가 p1과 p2가 서로 다른 객체라고 판단했기 때문에 equls를 하지 않으면 출력 결과는
		// 1:홍길동 , 1:홍길동 이렇게 나옴
		Set<Person> pSet = new HashSet<Person>();
		pSet.add(p1);
		pSet.add(p2);
		
		System.out.println("pSet.add(p1) 성공여부 : " + pSet.add(p1));
		System.out.println("pSet.add(p2) 성공여부 : " + pSet.add(p2));
		
		System.out.println();
		
		
		System.out.println("p1, p2 등록 후 데이터: ");
		Iterator<Person> it = pSet.iterator();
		while (it.hasNext()) {
			Person p = it.next();
			System.out.println(p.getId() + ":" + p.getName());
		}
 
		
		System.out.println("------------------------------");
		System.out.println();
		
		// 두개 값이 다른데 같은 값 출력됨.. 그래서 equals로 반드시 비교해주어야 한다.
		System.out.println("Aa".hashCode());
		System.out.println("BB".hashCode());
		System.out.println();

		System.out.println("add(p3) 성공여부: " + pSet.add(p3)); //p3 : 이순신
		System.out.println("add(p3) 후 데이터: ");
		for (Person p : pSet) {
			System.out.println(p.getId() + ": " + p.getName());
		}

		System.out.println();
		System.out.println("remove(p2) 성공여부: " + pSet.remove(p2));
		System.out.println("remove(p2) 후 데이터: ");
		for (Person p : pSet) {
			System.out.println(p.getId() + ": " + p.getName());
		}

	}
}

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
//
//	@Override
//	public boolean equals(Object obj) {
//		// Person p1 = new Person(1, "홍길동");
//		// Person p2 = new Person(1, "홍길동");
//		// equals를 안쓰면 두개의 객체가 다르다고 인식하는데, equals를 사용해서 같으면 같다고 출력시킬 수 있음
//
//		Person p = (Person) obj;
//		return (this.getId() == p.getId()) && this.getName().equals(p.getName());
//
//	}
//
//	@Override
//	public int hashCode() {
//		return (name + id).hashCode();
//		// p1과 p2의 hashCode출력 : 같은 해시코드를 사용하기 때문에 같은 놈이라고 판단함 => 그래서 출력 결과는
//		// 1:홍길동 으로 출력됨
//		// equals와 hashcode는 쌍으로 사용된다고 생각하면됨
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
