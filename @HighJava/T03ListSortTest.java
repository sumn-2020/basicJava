package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03ListSortTest {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬 전: " + list);

		/*
		 * 정렬은 Collections.sort()메서드를 이용하여 정렬한다. 정렬은 기본적으로 '오름차순 정렬'을 수행한다. 
		 * 정렬방식을 변경하려면정렬방식으로 결정하는 객체를 만들어서 Collections.sort()메서드의 인수값으로 넘겨주면 된다.
		 * 
		 */
		Collections.sort(list); // 오름차순으로 정렬하기
		System.out.println("정렬 후: " + list);

	}
}
