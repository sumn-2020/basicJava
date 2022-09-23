package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class SetMethodExample {
	public static void main(String[] args) {
		Set set1 = new HashSet<String>();
		
		set1.add("AAA");
		set1.add("BBB");
		set1.add("CCC");
		set1.add("DDD");
		set1.add("EEE");
		
		System.out.println(set1);
		System.out.println("set1의 사이즈 : " + set1.size());
		
		System.out.println("set1에 BBB가 있다? : " + set1.contains("BBB"));
		System.out.println("set1에 ZZZ가 있다? : " + set1.contains("ZZZ"));
		
		System.out.println(set1.hashCode());
		
		System.out.println("set1이 비어 있다? " + set1.isEmpty());
		
		set1.remove("DDD");
		System.out.println("set1에서 DDD 삭제 후 : " + set1);
		
		set1.clear();
		System.out.println("set1의 모든 항목 제거 후 : " + set1);
		
		System.out.println("set1이 비어 있다? " + set1.isEmpty());
		
	}
}
