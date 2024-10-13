
public class bankMain {
	
	    public static void main(String[] args) {
	        Bank bank = new Bank();

	        // Add a customer
	        Customer customer1 = new Customer("C001", "Alice");
	        bank.addCustomer(customer1);

	        // Add accounts for the customer
	        customer1.addSavingsAccount("S001", 1000.0, 2.5);
	        customer1.addCheckingAccount("C001", 500.0, 200.0);

	        // Display all customers
	        bank.displayAllCustomers();

	        // Display customer's accounts
	        customer1.displayAccounts();

	        // Deposit into savings account
	        bank.deposit("C001", "S001", 500.0);

	        // Withdraw from checking account
	        bank.withdraw("C001", "C001", 200.0);

	        // Display customer's accounts after transactions
	        customer1.displayAccounts();
	        
	        
	     // Display transaction history for savings account
	        System.out.println("\nTransaction History for Savings Account:");
	        Account savingsAccount = customer1.getAccount("S001");
	        savingsAccount.displayTransactionHistory();

	        // Display transaction history for checking account
	        System.out.println("\nTransaction History for Checking Account:");
	        Account checkingAccount = customer1.getAccount("C001");
	        checkingAccount.displayTransactionHistory();
	   
	    }
	}


