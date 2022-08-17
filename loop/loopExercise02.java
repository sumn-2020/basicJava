package loop;

import java.util.Scanner;

public class loopExercise02 {
	public static void main(String[] args) {
		
		//사용자로부터 특정 월을 입력받은 후, 
		//입력 받은 월의 계절이 어떤 계절인지 알아내는 프로그램을 만들어 보자. 
		//3월~5월은 봄, 6월~8월은 여름, 9월~11월은 가을, 12월~2월은 겨울을 출력한다.
		//실행 결과는 3번 반복되어 있지만 1번만 나오도록 작성하시면 됩니다.
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("월을 입력하세요(1~12) : ");
		int month = scanner.nextInt();
		String season = "" ;
		
		
		//switch문 사용할 경우
		switch(month) {
		case 1: case 2: case 12://month가 1, 2, 12이면 
			season = "겨울";
			System.out.println(month + "월은 " + season + "입니다.");
			break;
		case 3: case 4: case 5:
			season = "봄";
			System.out.println(month + "월은 " + season + "입니다.");
			break;
		case 6: case 7: case 8:
			season = "여름";
			System.out.println(month + "월은 " + season + "입니다.");
			break;
		case 9: case 10: case 11:
			season = "가을";
			System.out.println(month + "월은 " + season + "입니다.");
			break;
		 default:
			 season="알수없는계절";
			 System.out.println(month + "월은 " + "알 수 없는 계절 입니다.");
			 break;
		}
		
		
		//if문 사용할 경우
//		if(month == 1 || month == 2 || month == 12) {
//			season = "겨울";
//			System.out.println(month + "월은 " + season + "입니다.");
//		}else if(month == 3 || month == 4 || month == 5) {
//			season = "봄";
//			System.out.println(month + "월은 " + season + "입니다.");
//		}else if(month == 6 || month == 7 || month == 8) {
//			season = "여름";
//			System.out.println(month + "월은 " + season + "입니다.");
//		}else if(month == 9 || month == 10 || month == 11) {
//			season = "가을";
//			System.out.println(month + "월은 " + season + "입니다.");
//		}else {
//			System.out.println(month+"월은 계절이 아닙니다.");
//		}
//		
		
		
		
		
		
	}
}
