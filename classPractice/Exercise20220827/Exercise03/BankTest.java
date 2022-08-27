package Exercise20220827.Exercise03;

public class BankTest {
    public static void main(String[] args) {
    	
    	
    	//(1) 고객 정보 및 잔액 정보 정리해서 은행고객정보에 넣기 
        Bank bank = new Bank();

        Customer customer1 = new Customer("Tony", "Stark");
        customer1.setAccount(new BankAccount(100_000));
        bank.addCustomer(customer1);

        Customer customer2 = new Customer("Peter", "Parker");
        customer2.setAccount(new BankAccount(100));
        bank.addCustomer(customer2);

        Customer customer3 = new Customer("Thor", "Odinson");
        customer3.setAccount(new BankAccount(30_000));
        bank.addCustomer(customer3);
        
        
        
        //(2) 현재 잔액 계산  
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Customer maxBalanceCustomer = null; //잔고가 가장 많은 사람
        Customer minBalanceCustomer = null; //잔고가 가장 적은 사람 
        
        for (int i = 0; i < bank.getNumberOfCustomers(); i++) { //고객의 수만큼 반복문 실행 
           
        	Customer account = bank.getCustomer(i); // 배열의 index번째 고객(Customer)을 한명씩 확인 - 배열 속에 들어있는 customer의 정보는 이름과 잔액이 들어있음
            
            if (account.getAccount().getBalance() > max) { //잔액이 max보다 많으면 
                max = account.getAccount().getBalance();
                maxBalanceCustomer = account;
            }
            if (account.getAccount().getBalance() < min) {
                min = account.getAccount().getBalance();
                minBalanceCustomer = account;
            }
        }
        System.out.println("잔고가 가장 많은 사람");
        System.out.println(maxBalanceCustomer);
        System.out.println("잔고가 가장 적은 사람");
        System.out.println(minBalanceCustomer);
        
        
        //(3) 금액이 큰사람이 적은사람에게 본인의 계좌에서 절반송금
        if (maxBalanceCustomer.getAccount().transfer(max / 2, minBalanceCustomer.getAccount())) {
            System.out.println(maxBalanceCustomer.getFirstName() + "가 " + minBalanceCustomer.getFirstName() + "에게 잔고의 반을 송금");
        } else {
            System.out.println("송금되지 않았습니다.");
        }
        System.out.println("송금 후 모든 고객의 정보");
        for (Customer c : bank.getCustomers()) {
            if (c != null) {
                System.out.println(c);
            }
        }
    }
}

