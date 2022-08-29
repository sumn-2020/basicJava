package Exercise20220826.Exercise3;

public class BankAccount {

	private int balance;

	/**
	 * 계좌
	 * 
	 * @param balance 계좌의잔액
	 */
	public BankAccount(int balance) {
		this.balance = balance;
	}

	public int getBalance() { // 현재 계좌의 잔액
		return balance;
	}

	/**
	 * 입금메소드
	 * 
	 * @param amount 입금할 금액
	 * 
	 */
	public void deposit(int amount) { // 입금메소드
		this.balance += amount;
	}

	/**
	 * 출금메소드
	 * 
	 * @param amount: 출금할 금액
	 * @return 출금 성공시 true, 실패시 false반환
	 * 
	 */
	public boolean withdraw(int amount) {// 출금메소드
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}

	/**
	 * 이체메소드
	 * 
	 * @param amount       이체할 금액
	 * @param otherAccount 이체될 계좌번호
	 * @return 출금 성공시 true, 실패시 false반환
	 * 
	 */
	public boolean transfer(int amount, BankAccount otherAccount) {
		if (withdraw(amount) == true) { // 내 돈이 빠져나가는게 성공이 되면
			otherAccount.deposit(amount); // 상대방 계좌에 + 증액
			return true;
		}
		return false;
	}

}
