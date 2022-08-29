
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		String strNum = Integer.toString(b); //int를 string으로 변환후 
		int[] arrNum = new int[strNum.length()]; //입력된 글자 만큼의 배열상자를 만들고
		for(int i=0; i<strNum.length(); i++) {//strNum 배열 상자 크기만큼 반복문 실행
			arrNum[i] = strNum.charAt(i) - '0'; //'0'은 아스키코드 48
		}
		//System.out.println(arrNum[0]);
		
		System.out.println(a * arrNum[2]);
		System.out.println(a * arrNum[1]);
		System.out.println(a * arrNum[0]);
		System.out.println(a * b);
		
		
		
		
//		System.out.println(a* b[0]);
//		System.out.println(a* b[1]);
//		System.out.println(a* b[2]);
		//System.out.println(a*b);
		
		
	
	}
}
