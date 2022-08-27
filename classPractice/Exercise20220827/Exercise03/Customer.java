package Exercise20220827.Exercise03;

import java.text.DecimalFormat;
import java.text.Format;

public class Customer {

	// 필드
	private String firstName; //고객이름
	private String lastName; //고객 성
	private BankAccount account; //고객이 소유한 계좌

	// 생성자
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// 메소드
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public BankAccount getAccount() {
		return account;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public String toString() {// 고객계좌(account)의 잔액(balance)를 문자열로 반환
		DecimalFormat dc = new DecimalFormat("###,###"); //balance에 콤마찍기
		return "이름: " + firstName + " " + lastName + ", 잔고: " + dc.format(account.getBalance()) + "원";
	}

}
