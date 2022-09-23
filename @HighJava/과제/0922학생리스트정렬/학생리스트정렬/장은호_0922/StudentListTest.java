package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentListTest {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("1번", "이순신", 100, 90, 90));
		studentList.add(new Student("6번", "홍길동", 90, 100, 90));
		studentList.add(new Student("3번", "성춘향", 80, 70, 80));
		studentList.add(new Student("5번", "강감찬", 90, 75, 85));
		studentList.add(new Student("2번", "일지매", 85, 100, 60));
		studentList.add(new Student("4번", "변학도", 75, 70, 40));
		
		for (int i=0; i<studentList.size(); i++) {
			int grade = 1;
			for (int j=0; j<studentList.size(); j++) {
				if (studentList.get(i).getTotalScore() < studentList.get(j).getTotalScore()) {
					grade++; 
				}
			}
			studentList.get(i).setGrade(grade);
		}
		
		System.out.println("정렬 전 : ");
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("---------------------------");
		
		Collections.sort(studentList);
		
		System.out.println("학번 오름차순 정렬 후 : ");
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("---------------------------");
		
		Collections.sort(studentList, new SortTotalDesc());
		System.out.println("총점 내림차순 정렬 후 : ");
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("---------------------------");
	}
}


// 총점 내림차순
class SortTotalDesc implements Comparator<Student> {
	
	@Override
	public int compare(Student student1, Student student2) {
			
			if(student1.getTotalScore() > student2.getTotalScore()) {
				return -1;
			} else if (student1.getTotalScore() < student2.getTotalScore()) {
				return 1;
			} else {  
				return student1.compareTo(student2)*-1;
			}
	}
}


class Student implements Comparable<Student>{
	private String number;
	private String name;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	private int totalScore;
	private int grade;
	
	public Student(String number, String name, int koreanScore, int englishScore, int mathScore) {
		super();
		this.number = number;
		this.name = name;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		this.totalScore = koreanScore + englishScore + mathScore;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return String.format(
				"[학번=%s, 이름=%s, 국어점수=%s, 영어점수=%s, 수학점수=%s, 총점=%s, 등수=%s]",
				number, name, koreanScore, englishScore, mathScore, totalScore, grade);
	}

	// 학번 오름차순 
	@Override
	public int compareTo(Student student) {
		
		return getNumber().compareTo(student.getNumber());
	}
}
