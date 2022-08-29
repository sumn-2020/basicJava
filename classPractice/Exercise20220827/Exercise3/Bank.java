package Exercise20220826.Exercise3;

public class Bank {
	
	/**
	 * 은행의 고객목록 - 하나의 은행이 여러명의 고객 (배열 안에 들어가는 실제 고객 수는 모름)
	 */
	private Customer[] customers; 
	
	/**
	 *  은행의 실제 고객 수
	 */
	private int numberOfCustomers; // numberOfCustomers = 0;으로 초기화

	//필드의 값을 초기화 할 때 생성자를 많이 사용
	public Bank() {
		this.customers = new Customer[10];  // customers의 배열 크기를 10으로 초기화한다.
	}

	// 메소드
	public void addCustomer(Customer customer1) { // 인자로 받은 customer를 customers배열에 할당한다. 이 후에 numberofCustomer의 값을 1
		customers[numberOfCustomers++] = customer1;
		//numberOfCustomers++;
	}
	public Customer[] getCustomers() {
		return customers;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	/**
	 * 배열의 index번째 고객(Customer)객체를 반환
	 * @param index
	 * @return
	 */
	public Customer getCustomer(int index) { 
		return customers[index];
	}
}
