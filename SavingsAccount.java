
public class SavingsAccount extends Account{

	private double interestRate;

	public SavingsAccount(String accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}

	
	public double getInteresrRate() {
		return interestRate;
	}
	
	//calculating the interest after deposit
	
	
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if(amount>0 && getBalance()>=amount)
		{
			double newBalance=getBalance()-amount;
			System.out.println("Withdrawal successful. New balance: "+newBalance);
		}
		
		else {
			System.out.println("Insufficient Balance or Invalid Amount.");
		}
		
	}
	
	// Method to calculate interest and add it to the balance
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of " + interest + " added. New balance: " + getBalance());
   
    }
	
	
}
