package classPractice.method;

public class Car {
	
	int gas;
	
	//초기 가스양 메소드
	void setGas(int gas) { //void는 리턴 값 없기 때문에 초기값 없어도 됨 
		this.gas = gas; //받아온 gas를 제일상단에 있는 gas필드에 넣어줌
	}
	
	
	//남아있는 가스의 양 메소드 
	boolean isLeftGas() {
		if(gas == 0) { //제일 상단 gas필드에 담긴 값을 가져와서 0하고 비교(남아있는 가스의 양이 0일 경우) 
			System.out.println("gas가 없습니다.");
			return false; //return이라는 글자가 나오는 순간 메소드가 완전히 종료되면서 끝나기 때문에 굳이 else if 사용할 필요 없음 
		}
		//남아있는 가스가 0이 아닐 경우 
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	
	//달리는 메소드 
	void run() {
		while(true) {
			if(this.gas > 0) { //제일 상단 필드에 담긴 gas이 0보다 클 경우 
				System.out.println("달립니다(gas의 잔량) : " + this.gas);
				gas--; //가스가 없어질때까지 계속 달리게 하기(가스 하나씩 감소시킴)
			}else {
				System.out.println("멈춥니다(gas의 잔량) :" + this.gas);
				return; //가스가 0이 되는 순간 반복문을 멈추고 메소드 빠져나감 
			}
		}
		
		
		
		
	}
	
	
	
	
	
}
