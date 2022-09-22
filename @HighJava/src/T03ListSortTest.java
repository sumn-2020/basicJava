package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

		
		Collections.shuffle(list); //데이터를 섞어준다.
		System.out.println("섞은 후: " + list);
		//정렬방식을 결정하는 객체를 이용하여 정렬하기 
		Collections.sort(list, new Desc()); // 첫번째 매개변수: 내가 정렬하고 싶은 리스트, 두번째 매개변수 : 어떤식으로 정렬할지 방식을 결정하는 객체
		System.out.println("외부 정렬자로 정렬 후: " + list);
		
		
	}
}




/*
 * 정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야 한다.
 * 이 Comparator 인터페이스의 compare()라는 메서드를 재정의하여 구현하면된다.
 * 
 */
class Desc implements Comparator<String> {
	
	/*
	 * compare() 메서드의 반환 값을 결정하는 방법
	 * 
	 * - 오름차순 정렬일 경우..
	 * => 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환
	 * 
	 */
	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2) * -1; //String객체는 이미 comparable(오름차순)을 가지고 태어나기 때문에 이런방식으로 바로 써먹을수 있음
	}
		
}






