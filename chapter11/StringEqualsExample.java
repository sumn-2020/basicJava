package chapter11;

public class StringEqualsExample {
	public static void main(String[] args) {

		String strVar1 = new String("신민철");
		String strVar2 = "신민철";

		if (strVar1 == strVar2) { // == : 변수에 저장된 번지를 비교
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String객체를 참조");
		}

		if (strVar1.equals(strVar2)) { //equals : 문자열을 비교 
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}

	}
}
