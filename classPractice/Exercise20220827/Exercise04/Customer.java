package exercise.exercise07.savecheck;

public class Customer{
	private String firstName;
	private String lastName;
	private BankAccount[] accounts;
	private int numberOfAccounts;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new BankAccount[5];
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public BankAccount getAccount(int index) {
		return accounts[index];
	}
	
	public void addAccount(BankAccount account) {
		accounts[numberOfAccounts] = account;
		numberOfAccounts++;
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public String toString() {
		return String.format("이름: %s %s, 계좌의 갯수: %d", firstName, lastName, numberOfAccounts);
	}
	
}