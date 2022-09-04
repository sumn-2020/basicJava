package practiceException;

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

	public boolean transfer(int amount, BankAccount otherAccount)
			throws IllegalArgumentException, NullPointerException {

		if (amount < 0 || amount > balance) {
			throw new IllegalArgumentException();
		} else if (otherAccount == null) {
			throw new NullPointerException();
		}

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

	public abstract String getAccountType();

}