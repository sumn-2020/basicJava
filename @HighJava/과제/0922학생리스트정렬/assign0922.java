package assign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class assign0922 {
	public static void main(String[] args) {

		/*
		 * 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다. 생성자는 학번, 이름, 국어,
		 * 영어, 수학 점수만 매개변수로 받아서 처리한다.
		 * 
		 * 이 Student객체들은 List에 저장하여 관리한다. List에 저장된 데이터들을 1) 학번의 오름차순으로 정렬하여 출력하는 부분과 2)
		 * 총점의 역순으로 정렬하는 부분을 프로그램 하시오.(등수)
		 * 
		 * 
		 * (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.) (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고, =>
		 * comparable 총점 정렬기준은 외부클래스에서 제공하도록 한다. => comparator 총점이 같은 데이터도 입력해야됨 )
		 * 
		 */

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("220922", "홍길동", 50, 50, 60));
		studentList.add(new Student("220921", "일지매", 50, 50, 60));
		studentList.add(new Student("220916", "변학도", 25, 63, 70));
		studentList.add(new Student("220915", "성춘향", 45, 100, 90));
		studentList.add(new Student("220920", "향순이", 79, 45, 65));

		System.out.println("학번의 오름차순 정렬 전 : ");
		System.out.println(studentList);
		System.out.println("-----------------------------------------------------");

		Collections.sort(studentList);
		System.out.println("학번의 오름차순으로 정렬 후: ");
		for (Student student : studentList) {
			System.out.print(student);
		}

		System.out.println();
		System.out.println("-----------------------------------------------------");

		Collections.sort(studentList, new totalScore());
		System.out.println("총점 역순으로 정렬 후: ");
		for (Student student : studentList) {
			System.out.print(student);
		}

		System.out.println();
		System.out.println("-----------------------------------------------------");

		System.out.println("등수:  ");
		for (int i = 0; i < studentList.size(); i++) {
			int grade = 1;
			for (int j = 0; j < studentList.size(); j++) {
				if (studentList.get(i).getTotalScore() < studentList.get(j).getTotalScore()) {
					grade++;
				}
				studentList.get(i).setGrade(grade);
			}
		}
		System.out.println();

	}
}

//총점 정렬기준
class totalScore implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		
		if(student1.getTotalScore() > student2.getTotalScore()) {
			return -1;
		}else if(student1.getTotalScore() < student2.getTotalScore()) {
			return 1;
		}else {
			return Integer.compare(student1.getTotalScore(), student2.getTotalScore()) * -1;
		}	
	}
}

// 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
// 이 Student객체들은 List에 저장하여 관리한다. 
// List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력 (Comparable)
class Student implements Comparable<Student> {

	private String num;
	private String name;
	private int scoreKo;
	private int scoreEn;
	private int scoreMa;
	private int totalScore;
	private int grade;

	public Student(String num) {
		super();
		this.num = num;
	}

	// 생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
	public Student(String num, String name, int scoreKo, int scoreEn, int scoreMa) {
		super();
		this.num = num;
		this.name = name;
		this.scoreKo = scoreKo;
		this.scoreEn = scoreEn;
		this.scoreMa = scoreMa;

		setTotalScore(scoreKo + scoreEn + scoreMa);
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScoreKo() {
		return scoreKo;
	}

	public void setScoreKo(int scoreKo) {
		this.scoreKo = scoreKo;
	}

	public int getScoreEn() {
		return scoreEn;
	}

	public void setScoreEn(int scoreEn) {
		this.scoreEn = scoreEn;
	}

	public int getScoreMa() {
		return scoreMa;
	}

	public void setScoreMa(int scoreMa) {
		this.scoreMa = scoreMa;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Student [num=").append(num);
		builder.append(", name=").append(name);
		builder.append(", scoreKo=").append(scoreKo);
		builder.append(", scoreEn=").append(scoreEn);
		builder.append(", scoreMa=").append(scoreMa);
		builder.append(", totalScore=").append(totalScore);
		builder.append(", grade=").append(grade);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student student) {

		// List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력 (Comparable)
		return this.getNum().compareTo(student.getNum());

	}
}
