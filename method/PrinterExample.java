package classPractice.method;

public class PrinterExample {
	public static void main(String[] args) {
		
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		//static으로 설정한 메소드는 클래스명.메소드로 바로 접근 가능
		//static은 메모리에 올라가므로..
		Printer.println("홍길동");
		
	}
}
