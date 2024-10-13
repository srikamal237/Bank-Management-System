
public class CheckingAccount extends Account{
	
	private double overdraftLimit;

	public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
		super(accountNumber, balance);
		this.overdraftLimit = overdraftLimit;
	}
	
	public double getOverdraftLimit()
	{
		return overdraftLimit;
	}

	@Override
	public void withdraw(double amount) {
		
		if(amount>0 && getBalance()+overdraftLimit>=amount) {
			double newBalance=getBalance()-amount;
			System.out.println("Withdrawal successful. New balance: "+newBalance);
		}

		else {
			System.out.println("Insufficient Balance or overdraft Limit exceeded.");
		}
		
	}
	
	

}
