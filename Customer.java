import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String customerId;
	private String name;
	private List<Account> accounts;
	
	
	public Customer(String customerId, String name) {
		//super();
		this.customerId = customerId;
		this.name = name;
		this.accounts = new ArrayList();
	}


	public String getCustomerId() {
		return customerId;
	}


	public String getName() {
		return name;
	}

	
	public void addSavingsAccount(String accountNumber,double balance,double interestRate) {
		SavingsAccount savingsAccount=new SavingsAccount(accountNumber,balance,interestRate);
		
		accounts.add(savingsAccount);
		System.out.println("Savings Account created Successfully");
	}
	
	public void addCheckingAccount(String accountNumber,double balance,double overdraftLimit) {
		
		CheckingAccount checkingAccount=new CheckingAccount(accountNumber,balance,overdraftLimit);
		accounts.add(checkingAccount);
		System.out.println("Checking Account created Successfully");
	}


	
	public void displayAccounts() {
		if(accounts.isEmpty())
		{
			System.out.println("No accounts found for "+name);
		}
		
		
		else {
			System.out.println("Accounts for "+name+":");
			 for(Account account : accounts)
			  {
					System.out.println("Account No: "+account.getAccountNumber()+" , Balance: "+account.getBalance());

			  }
		}
		
		
	}
	
	//to find the account 
	public Account getAccount(String accountNumber) {
		
		for(Account account:accounts)
		{
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}
	
	public void closeAccount(String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account " + accountNumber + " closed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

	
	
	
}
