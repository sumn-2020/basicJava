package exercise20220831.exercise2;

public abstract class BankAccount {
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
		if (balance >= amount) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}

	public boolean transfer(int amount, BankAccount otherAccount) {
		if (withdraw(amount)) {
			otherAccount.deposit(amount);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("%,d", balance);
	}

	
	//BankAccount를 abstract로 바꾼 후 getAccountType 추상메소드 추가한 후 SavingAccount, CheckingAccount는 이걸 상속받아서 사용 
	public abstract String getAccountType();

}