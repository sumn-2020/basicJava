package exercise.exercise07.savecheck;

public class BankAccount{
	protected int balance;
	
	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) { 
		balance += amount;
	}
	
	public boolean withdraw(int amount) { 
		if(balance>=amount) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transfer(int amount, BankAccount otherAccount) { 
		if(withdraw(amount)) {
			otherAccount.deposit(amount);
			return true;
		} else {
			return false;
		}
		
	}
	
	public String toString() {
		return String.format("%d", balance);
	}
}