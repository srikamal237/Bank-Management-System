import java.util.ArrayList;
import java.util.List;

public abstract class Account {

		private String accountNumber;
		private double balance;
	    private List<Transaction> transactions;

		
		
		public Account(String accountNumber, double balance) {
			//super();
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.transactions=new ArrayList<>();
		}



		public String getAccountNumber() {
			return accountNumber;
		}

		public double getBalance() {
			return balance;
		}
		
		public void deposit(double amount) {
			if(amount>0) {
				balance+=amount;
				System.out.println("Deposit successful. New Balance: "+balance);
			}
		}
		
		public abstract void withdraw(double amount);
		

	    public void addTransaction(Transaction transaction) {
	        transactions.add(transaction);
	    }
	    
	    public List<Transaction> getTransactions() {
	        return transactions;
	    }
	    
	    public void displayTransactionHistory() {
	        if (transactions.isEmpty()) {
	            System.out.println("No transactions found.");
	        } else {
	            for (Transaction transaction : transactions) {
	                System.out.println(transaction);
	            }
	        }
	    }

		
		
}
