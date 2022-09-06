package chapter11;

public class WrapperExample {
	public static void main(String[] args) {
		int a = 10; //기본타입
		
//		Integer b = new Integer(100); //원래 이렇게 해야됨
		Integer b = 100; // autoBoxing : 이렇게 리터럴 형식으로 저장 가능함
		int d = b; // autoUnBoxing : 참조타입이었다가 기본타입으로 바뀌는 것. 자동으로 타입이 바뀌는 것 (autoBoxing, auto unboxing) 
		
		 
//		String c = new String("홍길동");//원래 이렇게 해야됨
		String c = "홍길동";// autoBoxing : 이렇게 리터럴 형식으로 저장 가능함
		
		//1부터 100까지의 합을 구하는 프로그램
		long startTime = System.nanoTime();
		Integer sum = 0;
//		int sum = 0;
		for (int i = 0; i < 100000; i++) {
			sum = sum + i;  //Integer은 int로 연산 안됨 => 반복문 들어갈땐 Integer을 int로 boxing하고 나올땐 unboxing하고 그걸 100000번 반복해야됨
		}
		System.out.println("합계 :" + sum);
		long endTime = System.nanoTime();
		System.out.println("걸린시간 :"  + (endTime - startTime));
		
	}
}
