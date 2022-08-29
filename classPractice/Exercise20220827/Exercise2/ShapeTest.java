package Exercise20220826.Exercise2;

public class ShapeTest {
	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[3]; //Shape생성자 안에 세칸의 상자 들어감 
		
		shapes[0] = new Circle(1.0);	// 0번째 => 	Shape[] shapes = new Circle(1.0);
		shapes[1] = new Triangle(2.0);	// 1번째 => 	Shape[] shapes = new Circle(2.0);
		shapes[2] = new Rectangle(2.0, 3.0);  // 2번째 => Shape[] shapes = new Circle(2.0, 3.0);
		
		
		for(Shape shape : shapes) { 
			System.out.println(shape); 
			// Shape shape = new Circle(1.0);
			// Shape shape = new Triangle(1.0);
			// Shape shape = new Rectangle(1.0);
		}
		
		
		//for( A : B ) => B에서 차례대로 객체를 꺼내서 A에다가 넣겠다 
		// B에 0 ~ 5까지 있을 경우
		//A = 0;  A = 1 .... A = 5
		
	}
}
