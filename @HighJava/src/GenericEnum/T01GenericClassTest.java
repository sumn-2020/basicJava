package kr.or.ddit.basic;

public class T01GenericClassTest {

	/*
	 * 제너릭 클래스 선언하는 방법
	 * 
	 * 형식) 
	 * class 클래스명 <제네릭타입글자>{ 
	 * 제네릭타입글자 변수명; //변수 선언에 제네릭을 사용할 경우 ...
	 * 
	 * 제네릭타입글자 메서드명() { //반환값이 있는 메서드에서 사용하는 경우 ...
	 * 
	 * return 값; } ...
	 * 
	 * }
	 * 
	 * -- 제네릭 타입글자 -- 
	 * T => Type 
	 * K => Key 
	 * V => Value 
	 * E => Element(자료구조에 들어가는 것들을 나타낼 때 사용함 )
	 * 
	 */
	public static void main(String[] args) {
		
		//제네릭을 이용하지 않을 경우
		NonGeneric ng1 = new NonGeneric();
		ng1.setVal("가나다라");
		
		NonGeneric ng2 = new NonGeneric();
		ng2.setVal(100);
		
		String rtnVal1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 rtnVal1 => " + rtnVal1);
		
		Integer irtnVal2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 irtnVal2 => " + irtnVal2);
		System.out.println();
		
		
		//제네릭을 이용할 경우
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnVal1 = mg1.getVal();
		irtnVal2 = mg2.getVal();
		
		System.out.println("제네릭 문자열 반환값 : " + rtnVal1);
		System.out.println("제네릭 정수형 반환값 : " + irtnVal2);
		
	}

}

class NonGeneric {
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

}

class MyGeneric<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

}





