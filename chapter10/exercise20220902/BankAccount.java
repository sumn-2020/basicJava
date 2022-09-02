package exercise20220902;

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

	public boolean transfer(int amount, BankAccount otherAccount) throws IllegalArgumentException, NullPointerException {

		if (amount < 0 || amount > balance) {
			throw new IllegalArgumentException();
		}
		if (otherAccount == null) {
			throw new NullPointerException();
		}
		if (withdraw(amount)) {
			otherAccount.deposit(amount);
			return true;
		}
		return false;
		

	}

	@Override
	public String toString() {
		return String.format("%,d", balance);
	}

	/**
	 * 계좌의 종류를 반환하는 메소드
	 * 
	 * @return 계좌의 종료(저축계좌, 당좌예금)
	 */
	// BankAccount를 abstract로 바꾼 후 getAccountType 추상메소드 추가한 후/ SavingAccount,
	// CheckingAccount는 이걸 상속받아서 사용
	public abstract String getAccountType();

}