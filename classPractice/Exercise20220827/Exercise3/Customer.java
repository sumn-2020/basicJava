package Exercise20220826.Exercise3;

public class Customer{

	/**
	 * 고객의 이름 
	 */
	
	private String firstName; 
	
	/**
	 * 고객 성
	 */
	private String lastName;
	
	/**
	 * 고객이 소유한 계좌
	 */
	private BankAccount account; 
	
	//생성자
	public Customer(String firstName, String lastName) { // 주어진 인자로 각 필드 초기화
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//메소드
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
	@Override
	public String toString() { //고객의 이름(firstName + lastName)과 고객계좌(account)의 잔액(balance)을 문자열로 반환
		return String.format("이름: %s %s, 잔고: %,d원", firstName, lastName, account.getBalance());
	}
	
	
	
}
