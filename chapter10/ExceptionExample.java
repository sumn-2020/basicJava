package chapter10;

import java.util.Scanner;

import chapter08.Student;

public class ExceptionExample {
	public static void main(String[] args) {
		// 1. 일반예외
		try {
			Class.forName("java.ang.String"); // try 부분을 쭉 실행하다가 에러가 발생하면
		} catch (ClassNotFoundException e) { // ClassNotFoundException이러한 에러가 발생하면 그 오류를 잡아서 catch body속 구문 실행
			System.out.println("입력하신 클래스가 존재하지 않습니다.");
		}

		try {

			// NullPointerException오류
			Student student = null;
			student.compareTo(new Student("홍길동", 10));

			// ArrayIndexOutOfBoundsException 오류
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[5]);

		} catch (NullPointerException e) { // NullPointerException 오류는 여기서 실행
			System.out.println("Null 참조 에러 발생");
		} catch (ArrayIndexOutOfBoundsException e) { // ArrayIndexOutOfBoundsException오류는 여기서 실행
			System.out.println("인덱스 에러");
		} catch (Exception e) { // NullPointerException 에러를 제외한 나머지 오류는 여기거 실행
			e.printStackTrace();
		}

		try {
			Student student = null;
			student.compareTo(new Student("홍길동", 10)); // 1) null point에러 발생

			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[5]);

		} catch (NullPointerException e) {
			System.out.println("Null 참조 에러 발생"); // 2) catch문 실행
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 에러");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 3) finally문 실행
			// try문이 정상적으로 끝나서 catch문이 실행안되더라도 실행되고, catch문이 실행되더라도 실행됨
			// 반드시 실행되는 부분
			System.out.println("반드시 출력해야 할 문장");
		}

		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[5]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		try (Scanner scanner = new Scanner(System.in)) {
			int nextInt = scanner.nextInt();
			System.out.println(nextInt);
			scanner.close();
		}
		
		
		
		

	}
}
