package chapter10;

public class ThrowsExample {
	public static void main(String[] args){ //에러를 넘겨받은 놈은 try catch로 오류 해결 
		try {
			method1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void method1()  throws ClassNotFoundException { // 코드가 돌다가 에러가 발생하면 출력을 중단하고, 그 에러를 호출한 놈(클래스)한테 떠넘김(던짐)  
		Class.forName("java.lang.String"); 
	}
}


