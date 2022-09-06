package chapter11;

public class Child {
	
	public String cstr1 = "1";
	public String cstr2 = "2";
	
	public Child() {
		// TODO Auto-generated constructor stub
	}
	
	private Child(String str) {
		cstr1 = str;
	}
	
	public int method4(int n) {
		System.out.println("method4");
		return n;
	}
	
	private int method5(int n) {
		System.out.println("method5");
		return n;
	}
	
	
	
	
}
