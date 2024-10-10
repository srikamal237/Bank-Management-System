package Core;
public class Account {
   
    protected String accountNumber;
    protected double balance;
    
    protected Customer customer;

    public Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    //desposit 
    public void deposit(double amount){
        if(amount>0){
          this.balance += amount;
          System.out.println("Deposit Successful , New Balance : " + this.balance);
        }
        else{
            System.out.println("Invalid Deposit Amount.");
        }
    }


    public boolean withdraw(double amount){
        if(amount>0 && balance>=amount)
        {
            this.balance -= amount;
            System.out.println("Withdrwal Successful. New Balance: " + balance);
            return true;
        }
        else {
            System.out.println("Insufficient Balance or Invalid Withdraw Amount.");
            return false;
        }
        
    }

    

}
