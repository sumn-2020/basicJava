package Exercise20220827.Exercise04;

public class CheckingAccount extends BankAccount { //BankAccount 클래스를 상속받는다. 
	
	//필드
	private SavingsAccount protectedBy; //SavingsAccount객체를 선언
	
	//생성자
	public CheckingAccount(int balance) {
		//수퍼클래스의 생성자를 이용하여 잔액 초기화
		super(balance);
	}
	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		//수퍼클래스의 생성자를 이용하여 잔액을 초기화하고, 
		//인자로 전달된 SavingsAccount로 protectedBy  초기화 
		super(balance);
		this.protectedBy = protectedBy;
	}
	
	//메소드
	@Override
	public boolean withdraw(int amount) {
		//수퍼클래스의 withdraw(int amount)를 재정의하고 
		//만약 잔액보다 더 많은 값을 인출하려고 하면 
		//초과되는 만큼의 돈을 / 참조하고있는 SavingsAccount객체에서 인출
		int rest =  amount % balance;
		protectedBy.balance = protectedBy.balance - rest;
		
		if(amount < balance) {
			balance = amount - balance;
			return true;
		}
		
		return false;
		
		
	}
	
}
