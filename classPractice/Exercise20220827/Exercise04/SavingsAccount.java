package exercise.exercise07.savecheck;

public class SavingsAccount extends BankAccount {
	private double interestRate;
	
	public SavingsAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}
	
	public void updateBalance(int period) {
		balance += balance * interestRate * period;
	}
	
}
