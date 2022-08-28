package exercise.exercise07.savecheck;

public class CheckingAccount extends BankAccount{
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
		if(balance + protectedBy.balance < amount) {
			return false;
		} else if(balance < amount) {
			protectedBy.withdraw(amount - balance);
			balance -= balance;
			return true;
		} else {
			super.withdraw(amount);
			return true;
		}
	}
}
