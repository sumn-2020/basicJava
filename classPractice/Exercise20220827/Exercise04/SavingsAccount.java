package Exercise20220827.Exercise04;

public class SavingsAccount extends BankAccount { //BankAccount 클래스를 상속받는다. 
	
	//필드
	private double interestRate; //이자율 
	
	//생성자
	public SavingsAccount(int balance, double interestRate) { 
		//잔액과 이자율 필드를 초기화한다.
		//이 때 상속받은 balance필드는 슈퍼클래스의 생성자를 호출해서 초기화한다.
		super(balance);
		this.interestRate = interestRate;
	}
	
	//메소드
	public void updateBalance(int period) {
		//저축기간을 인자로 받아 이자를 계산하여 잔액에 추가한다.
		// 이 때, 저축기간은 월 단위이고, 이자는 단리법을 따른다.
		// 단리원리금 = 원금 * 이율 * 기간 + 원금
		balance += balance * interestRate * period + balance;
	}
	

}
