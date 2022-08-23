package singleTon;

public class Singleton {

	private static Singleton instance = new Singleton(); 

	private Singleton() { // public Singleton()은 new를 통해서 외부에서 언제든접근 가능 => 이걸 막아야됨 private Singleton()

	}

	public static Singleton getInstance() {
		return instance;
	}

}
