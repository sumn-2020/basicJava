package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {

		// Default_Capacity = 10
		List list1 = new ArrayList();

		// add()메서드를 이용하여 데이터 추가
		list1.add("aaa");
		list1.add("bbb");
		list1.add('k');
		list1.add(111); // list1.add(new Integer(111)); 이거와 같은거임
		list1.add(true);
		list1.add(12.34);

		// size() => 데이터 개수
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);

		// get()으로 데이터 꺼내오기
		System.out.println("1번째 자료: " + list1.get(0));

		// 데이터 끼워 넣기도 같다
		list1.add(0, "zzz");
		System.out.println("list1 => " + list1);

		// 데이터 변경하기(set메서드)
		String temp = (String) list1.set(0, "YYY");
		System.out.println("temp=> " + temp);
		System.out.println("lsit1 => " + list1);

		// 삭제하기(remove메서드)
		list1.remove(0);
		System.out.println("삭제 후: " + list1);

		list1.remove("bbb");
		//list1.remove(5); //list1.remove(new Integer("111"));
		System.out.println("bbb 삭제 후: " + list1);
		System.out.println("111 삭제 후: " + list1);
		System.out.println("=========================================");

		// 제너릭을 지정하여 선언 할 수 있다.
		List<String> list2 = new ArrayList<String>(); //타입을 미리 지정해 줄 수 있음 List<String> => list안에 String만 들어갈 수 있음
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE"); //list2.add(111111) List<String>안에 String타입밖에 못들어가는데 1111쓰면 int타입이기 때문에 오류

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + ":" + list2.get(i));
		}
		System.out.println("-------------------------------------------");

		// contain(비교객체); => 리트스에 '비교객체'가 있으면 true, 없으면 false 리턴
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));

		// indexOf(비교객체); => 리스트에서 '비교객체'를 찾아 '비교객체'가 있는 index값 반환한다. 없으면 -1 반환
		System.out.println("DDD의 index값: " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값: " + list2.indexOf("ZZZ"));
		System.out.println("-------------------------------------------");

		
		// 리스트 삭제
		for (int i = 0; i < list2.size(); i++) {
			list2.remove(list2.get(i));
		}
		
		//iterator을 이용한 값 삭제
		Iterator<String> iter = list2.iterator();
		while(iter.hasNext()) {
			iter.next(); //하나씩 꺼내올 수 있음 
			iter.remove();//꺼내지면 삭제
		}
		
		System.out.println("리스트 삭제후 : " + list2);
		// 지울 때 한칸씩 앞으로 오기 때문에 값이 남음
		//전부 삭제하고 싶으면 거꾸로 삭제하면 안밀리고 삭제 할 수 있음 
		
		
		

	}
}
