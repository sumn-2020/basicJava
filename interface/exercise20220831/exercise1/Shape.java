package exercise20220831.exercise1;

//Comparable : 인터페이스
//<Shape> : 제네릭
//Shape : 클래스
public abstract class Shape implements Comparable<Shape> { //같은 것끼리 비교

	
	/**
	 * 면접 구하기
	 * @return
	 */
	public abstract double area(); //다른 도형들의 area()를 받아옴 

	/**
	 * 둘레 구하기
	 * @return
	 */
	public abstract double perimeter();

	
	@Override
	public int compareTo(Shape target) {  //현재 shape객체 area와 비교할 shape객체 area가 매개변수로 들어옴 
		//return 0;
		if(this.area() > target.area()) { //this.area()리턴값이 target.area()리턴값보다 크면 
			return 1; //오름차순
		}else if(this.area() < target.area()) {
			return -1;//내림차순
		}else {
			return 0;//같을 땐
		}

	}
}
