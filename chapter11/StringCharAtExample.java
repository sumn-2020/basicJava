package chapter11;

public class StringCharAtExample {
	public static void main(String[] args) {
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);// 매개값으로 주어진 인덱스의 문자 리턴
		switch(sex) {
		case '1' :
		case '3' :
			System.out.println("남자 입니다.");
			 break;
		case '2':
		case '4': 
			System.out.println("여자 입니다.");
			break;
		}
	}
}
