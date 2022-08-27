package Exercise20220827.Exercise03;

public class BankAccount {

	// 필드
	private int balance; // 잔액

	// 생성자
	public BankAccount(int balance) {
		// 인자로 전달되는 값을 필드의 balance를 초기화
		this.balance = balance;
	}

	// 메소드
	public int getBalance() { // 현재 계좌의 잔액
		return balance;
	}

	public void deposit(int amount) { // 입금 메소드 => 내계좌 + 들어오는 돈
		this.balance += amount;
	}

	public boolean withdraw(int amount) { // 출금메소드 => 내계좌 - 빠져나가는 돈(내 잔액보다 빠져나가면 안되니까 그걸 계산해야됨)
		if(amount > balance) {
			return false;
		}
		this.balance -= amount;
		return true;
	}

	public boolean transfer(int amount, BankAccount otherAccount) {
		// 현재 계좌에서 amount만큼을 다른 계좌로 송금하는 메소드
		if(balance < otherAccount.balance) { //현재 내 잔고가 상대방 잔고보다 적다면 송금X
			return false; 
		}
		otherAccount.balance += amount; //내잔고가많다면  상대방 잔고에 입금
		this.balance -= amount; //내 잔고는 그만큼 깎임
		return true;
	}

}
