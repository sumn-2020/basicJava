package abstractPackage;

public abstract class Animal {

	public String kind;
	
	public void breath() {
		System.out.println("숨을 쉰다.");
	}
	
	//	public void sound() {
	//		
	//	} 
	public abstract void sound(); 
	//보통 메소드에는 body가 필수적으로 들어가야하는데, 이 메소드는 body가 필요없는 추상 메소드라는걸 알려줘야됨 => 메소드에 abstract 붙여야됨
	// 클래스 내부에 abstract 메소드가 있다는 걸 반드시 알려줘야됨 => 클래스에 abstract 붙여야됨
	
}
