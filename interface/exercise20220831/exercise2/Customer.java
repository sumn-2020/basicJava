package exercise20220831.exercise2;

public class Customer {
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

	public void addAccount(BankAccount account) {
		accounts[numberOfAccounts++] = account;
		// numberOfAccounts++;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public BankAccount getAccount(int index) {
		return accounts[index];
	}

	@Override
	public String toString() {
		return String.format("이름: %s %s", firstName, lastName);
	}

}