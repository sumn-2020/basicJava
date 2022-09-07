package chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {

		Set<String> set = new HashSet<>();

		
		//Java 두번 중복:  Set컬렉션에서는 중복 안되므로 Java는 한번만 저장됨 
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");

		int size = set.size(); //저장된 객체 수 얻기
		System.out.println("총객체수:" + size);

		Iterator<String> iterator = set.iterator(); //반복자 얻기 
		while (iterator.hasNext()) { //객체 수만큼 루핑
			String element = iterator.next(); // 1개의 객체를 가져옴 
			System.out.println("\t" + element);
		}

		set.remove("JDBC"); //1개 객체 삭제
		set.remove("iBATIS");

		System.out.println("총 객체수: " + set.size()); //저장된 객체수 얻기

		iterator = set.iterator(); //반복자 얻기 
		for (String element : set) { //객체 수만큼 루핑
			System.out.println("\t" + element);
		}

		set.clear(); //모든객체를 제거하고 비움
		if (set.isEmpty()) {
			System.out.println("비어있음");
		}

	}
}
