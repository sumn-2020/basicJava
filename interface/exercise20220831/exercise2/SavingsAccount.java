package exercise20220831.exercise2;

public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	public void updateBalance(int period) {
		balance += balance * interestRate * period;
	}

	@Override
	public String getAccountType() {
		return "저축예금";
	}

}
