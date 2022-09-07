package chapter13;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("신용균", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);

		Integer hongValue = map.get("홍길동"); // 검색할 객체
		System.out.println(hongValue);
		System.out.println(map.size()); // 총 entry갯수: 3 (중복안됨)

		System.out.println();

		// 모든 요소를 출력
		// 방법 1. entry를 이용
		// 방법 1-1 iterator 이용
		Iterator<Entry<String, Integer>> entryIterator = map.entrySet().iterator(); // entry 집합에 있는 iterator를 가져온다.
		while (entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next(); // entry안에는 key와 value값을 가진 entry가 들어가있고
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		// 방법 1-2 foreach문 이용
		System.out.println();
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		// 방법 2. key를 이용
		System.out.println();
		// 방법 2-1 iterator 이용
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + ":" + map.get(key));
		}

		// 방법 2-2 foreach문 이용
		System.out.println();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key + ":" + map.get(key));
		}

		// 방법 3. Value를 이용 - 리스트가 collection 역할 함
		// value는 iterator가 없음 , foreach문으로만 쓸수 있음
		System.out.println();
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}

		// 반복문 1. for i문
		for (int i = 0; i < args.length; i++) {

		}

		// 반복문 2. for each문
		for (Integer integer : values) {

		}

		// 반복문 3. foreach 함수 사용
		System.out.println();
//		values.forEach(new Consumer<Integer>() { // 1) new Consumer : ct+ 엔터 -> ct + 1
//			@Override
//			public void accept(Integer t) {
//				System.out.println(t);
//			}
//		});
		
		values.forEach(t -> System.out.println(t));

	}
}
