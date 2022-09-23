package kr.or.ddit.basic;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise1 {
	public static void main(String[] args) {
		List<Student> memList = new ArrayList<Student>();
		
		memList.add(new Student("101", "홍길동", 90, 90, 90 ));
		memList.add(new Student("102", "강감찬", 90, 90, 90 ));
		memList.add(new Student("105", "이순신", 80, 80, 80 ));
		memList.add(new Student("103", "일지매", 70, 70, 70 ));
		memList.add(new Student("104", "성춘향", 60, 60, 60 ));
		memList.add(new Student("106", "김시민", 90, 80, 90 ));
		memList.add(new Student("109", "세종대왕", 90, 90, 60 ));
		memList.add(new Student("107", "영조", 80, 80, 80 ));
		memList.add(new Student("108", "정조", 70, 60, 70 ));
		memList.add(new Student("110", "이찬영", 60, 50, 60 ));
		
		for(int i = 0 ; i < memList.size(); i++ ) { // 등수 정렬
			for(int j = i+1; j < memList.size(); j++){
				if(memList.get(i).getSum() < memList.get(j).getSum()) {
					memList.get(i).setGrade(memList.get(i).getGrade()+1);
				}
				else if(memList.get(i).getSum() == memList.get(j).getSum()) {
					memList.get(i).setGrade(memList.get(i).getGrade());
				}
				else {
					memList.get(j).setGrade(memList.get(j).getGrade()+1);
				}
			}
		}
		
		System.out.println("정렬 전 : ");
		for(Student mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------------");
		
		Collections.sort(memList);
		
		System.out.println("학번의 오름차순으로 정렬 후 : ");
		for(Student mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------------");
		
		Collections.sort(memList,new SumDesc());
		
		System.out.println("총점의 내림차순으로 정렬 후 (총점이 같을시 학번 내림차순) : ");
		for(Student mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------------");
	}
}

class SumDesc implements Comparator<Student>{

	@Override
	public int compare(Student sum1, Student sum2) {
		// TODO Auto-generated method stub
		if(sum1.getSum() > sum2.getSum()) {
			return -1;
		}
		else if(sum1.getSum() == sum2.getSum()) {
			return -1;
		}
		else {
			return 1;
		}
		
	}
	
}


class Student implements Comparable<Student>{
	
	private String StudentNum;
	private String name;
	private int korean;
	private int math;
	private int english;
	private int sum;
	private int grade = 1;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String studentNum, String name, int korean, int math, int english) {
		StudentNum = studentNum;
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
		sum = korean+math+english;
		
	}


	public String getStudentNum() {
		return StudentNum;
	}

	public void setStudentNum(String studentNum) {
		StudentNum = studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

	@Override
	public String toString() {
		return "Student [StudentNum=" + StudentNum + ", name=" + name + ", korean=" + korean + ", math=" + math
				+ ", english=" + english + ", sum=" + sum + ", grade=" + grade + "]";
	}
	@Override
	public int compareTo(Student stu) {
		// TODO Auto-generated method stub
		
		return this.getStudentNum().compareTo(stu.getStudentNum());
		
	}
}
