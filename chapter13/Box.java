package chapter13;

public class Box<E> { //어떤 타입이 들어올지 모르니까 일단 임의로 지정해 놓은 후 
	
	private E value;
	
	public E getValue() { 
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Box(E value) {
		this.value = value;
	}
}
