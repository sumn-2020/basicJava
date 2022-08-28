package Exercise20220827.Exercise04;

import java.text.DecimalFormat;
import java.text.Format;

public class Customer {

	// 필드
	private String firstName; //고객이름
	private String lastName; //고객 성
	private BankAccount[] accounts; //고객이 소유한 계좌
	private int numberOfAccounts; //고객이 소유한 계좌수(최대 보유가능 계좌수 = 5)

	// 생성자
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//accounts 배열의 크기는 5로 초기화
		this.accounts = new BankAccount[5];
	}

	// 메소드
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public BankAccount getAccount(int index) {
		//accounts배열의 index에 해당하는 BankAccount 객체를 반환
	
		return accounts[index];
	}
	
	public void addAccount(BankAccount account) {
		//BankAccount배열에 인자로 전달된계좌를 추가하고,
		//numberOfAccounts값을 1만큼 증가시킨다.
		this.accounts[numberOfAccounts] = account;
		numberOfAccounts++;
	}
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public String toString() {// 고객계좌(account)의 잔액(balance)를 문자열로 반환
		return "이름: " + firstName + " " + lastName + ", 계좌의 갯수 : " + numberOfAccounts;
		
		//accounts[numberOfAccounts] :  accounts 의 "numberOfAccount"번째 객체의 값
		//numberOfAccounts : 그냥 계좌 갯수
	}
}
