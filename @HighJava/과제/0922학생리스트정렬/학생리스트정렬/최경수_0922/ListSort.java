package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		

		list.add(new Student("201406197", "최경수", 100, 100, 100));
		list.add(new Student("202006173", "비욘세", 99, 73, 95));
		list.add(new Student("201706155", "장사라", 48, 100, 84));
		list.add(new Student("202206166", "라우브", 100, 68, 77));
		list.add(new Student("199906188", "브루노", 87, 69, 100));


		// 순위 구하기
		int[] totalList = new int[list.size()]; // 점수를 담을 배열 만들기
		int[] rank = new int[list.size()]; // 초기 순위값 배열 만들기

		for (int i = 0; i < list.size(); i++) {
			totalList[i] = list.get(i).getTotal();
		}
		// totalList = { 300, 267, 256, 245, 232 }

		for (int i = 0; i < totalList.length; i++) {
			rank[i] = 1; // for 돌 때마다 1등으로 초기화
			for (int j = 0; j < totalList.length; j++) {
				if (totalList[i] < totalList[j]) {
					rank[i] = rank[i] + 1;
					list.get(i).setRank(rank[i]);
				}
			}
		}
		System.out.println();
		
		// 정렬 전
		System.out.println("===== 정렬 전 =====");
		for (Student student : list)
			System.out.println(student);

		// 학번의 오름차순으로 정렬
		System.out.println("===== 학번순 =====");
		Collections.sort(list);

		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();

		// 총점의 내림차순으로 정렬
		System.out.println("===== 총점순 =====");
		Collections.sort(list, new Desc());
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();

//		for (int i = 0; i < rank.length - 2; i++) {
//			for (int j = i + 1; j < rank.length - 1; j++) {
//				if (totalList[i] < totalList[j]) { //i번째보다 j번째가 값이 작다면 rank에 1을 더해서 순위를 매김 
//					rank[i] += 1;
//				} else if (totalList[i] > totalList[j]) {
//					rank[i] += 0;
//				} else {
//					rank[i] = rank[j];
//				}
//			}
//		}

	}
}

/*
 * Student의 총점의 내림차순으로 정렬하는 외부정렬자 클래스
 */
//class Desc implements Comparator<Student> {
//
//	@Override
//	public int compare(Student student1, Student student2) {
//		if (student1.getTotal() > student2.getTotal()) {
//			return -1;
//		} else if (student1.getTotal() == student2.getTotal()) {
//			return 0;
//		} else {
//			return 1;
//		}
//	}
//
//}

class Desc implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getTotal() > student2.getTotal()) {
			return -1;
		} else if (student1.getTotal() == student2.getTotal() && (student1.getId().compareTo(student2.getId())) != 0) {
			return 0;
		} else {
			return 1;
		}
	}

}

