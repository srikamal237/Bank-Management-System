import java.util.ArrayList;
import java.util.List;


public class Bank {

	//to store customer of the bank
	List<Customer> customers;
	
	public Bank(){
		this.customers=new ArrayList();
		
	}
	
	
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
		System.out.println("Customer "+customer.getName()+" added successfully.");
	}
	
	
	//retrive the customer by their ID
	public Customer getCustomer(String customerId) {
		for(Customer customer : customers)
		{
			if(customer.getCustomerId().equals(customerId)) {
				
				return customer;
			}
		}
		return null; //if customer is not found
		
	}
	
	public List<Customer> getAllCustomers()
	{
		return customers;
	}
	
	public void displayAllCustomers()
	{
		
		if(customers.isEmpty()){
			System.out.println("No Customers found.");
		}
		
		else {
			System.out.println("Customers");
			 	for(Customer customer : customers)
			 	{
					System.out.println("Customer ID: "+customer.getCustomerId()+" , Name: "+customer.getName());

			 	}
		}
	}
	
	
  public void deposit(String customerId,String accountNumber,double amount) {
	  Customer customer=getCustomer(customerId);
	  
	  if(customer!=null) {
		  Account account=customer.getAccount(accountNumber);
		  if(account !=null) {
			  account.deposit(amount);
		  }
		  else {
			  System.out.println("Account Not Found");
		  }
	  }
	  else {
		  System.out.println("Customer Not Found");
	  }
	  
  }

  public void withdraw(String customerId,String accountNumber,double amount) {
	  Customer customer=getCustomer(customerId);
	  
	  if(customer!=null) {
		  Account account=customer.getAccount(accountNumber);
		  if(account !=null) {
			  account.withdraw(amount);
		  }
		  else {
			  System.out.println("Account Not Found");
		  }
	  }
	  else {
		  System.out.println("Customer Not Found");
	  }
	  
  }


}



	
	

