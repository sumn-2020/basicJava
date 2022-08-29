package Exercise20220826.Exercise04;

public class CheckingAccount extends BankAccount {
	private SavingsAccount protectedBy;

	public CheckingAccount(int balance) {
		super(balance);
	}

	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}

	@Override
	public boolean withdraw(int amount) {
		// 만약 savingsAccount에 10000원이 있고,
		// checkingAccount에 5000원이 있을 경우
		// 백지수표로 2500원짜리 물건을 구매했을 경우
		
		if(amount > balance) { //실패하면 
			protectedBy.balance -= amount - balance;
			balance = 0;
			return true;
		}
		return super.withdraw(amount); //amount < balance이면, bankAccount에 있는 withdraw메소드 실행해서 결과값 리턴 

//		if (amount < balance) {
//			balance -= amount;
//
//		} else {
//			protectedBy.balance -= amount - balance;
//			balance = 0;
//		}
//		return super.withdraw(amount);
//		
		

	}
}
