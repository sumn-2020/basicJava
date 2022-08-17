package loop;

import java.util.Scanner;

public class loopExercise01 {
	public static void main(String[] args) {
		
		//사용자로부터 세 변의 길이를 입력받은 후, 
		//입력받은 변의 길이로 삼각형을 만들 수 있는지 판별하는 프로그램을 만들어 보자.
		//삼각형을 판별하는 방법은 가장 긴 변의 길이가 다른 두 변의 길이의 합보다 작으면 삼각형을 만들 수 있다.
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("삼각형의 첫번째 변의 길이를 입력하세요 : ");
		int length1 = scanner.nextInt();//첫번째 길이 입력
		System.out.println("삼각형의 두번째 변의 길이를 입력하세요 : ");
		int length2 = scanner.nextInt();//두번째 길이 입력
		System.out.println("삼각형의 세번째 변의 길이를 입력하세요 : ");
		int length3 = scanner.nextInt();//세번째 길이 입력
		
		if((length1 < length2+length3) && (length2 < length1+length3) && (length3 < length1+length2)) { //항상 가장 긴 변이 다른 두 변의 길이의 합보다 작아야 함
			System.out.println("삼각형을 만들 수 있습니다.");
		}else {
			System.out.println("삼각형을 만들 수 없습니다.");
		}
		
		
	}
}
