import java.util.Scanner;

public class bankMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Apply Interest to Savings Account");
            System.out.println("6. Close Account");
            System.out.println("7. View Transaction History");
            System.out.println("8. View Customer Accounts");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    // Add a new customer
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    bank.addCustomer(new Customer(customerId, customerName));
                    System.out.println("Customer added successfully.");
                    break;

                case 2:
                    // Add an account for a customer
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    Customer customer = bank.getCustomer(customerId);
                    if (customer != null) {
                        System.out.print("Enter account type (1 for Savings, 2 for Checking): ");
                        int accountType = scanner.nextInt();
                        scanner.nextLine(); // consume the newline
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double balance = scanner.nextDouble();

                        if (accountType == 1) {
                            System.out.print("Enter interest rate for Savings Account: ");
                            double interestRate = scanner.nextDouble();
                            customer.addSavingsAccount(accountNumber, balance, interestRate);
                            System.out.println("Savings Account added successfully.");
                        } else if (accountType == 2) {
                            System.out.print("Enter overdraft limit for Checking Account: ");
                            double overdraftLimit = scanner.nextDouble();
                            customer.addCheckingAccount(accountNumber, balance, overdraftLimit);
                            System.out.println("Checking Account added successfully.");
                        } else {
                            System.out.println("Invalid account type.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    // Deposit money
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(customerId, depositAccountNumber, depositAmount);
                    break;

                case 4:
                    // Withdraw money
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(customerId, withdrawAccountNumber, withdrawAmount);
                    break;

                case 5:
                    // Apply interest to savings account
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    System.out.print("Enter savings account number: ");
                    String savingsAccountNumber = scanner.nextLine();
                    Customer savingsCustomer = bank.getCustomer(customerId);
                    if (savingsCustomer != null) {
                        Account account = savingsCustomer.getAccount(savingsAccountNumber);
                        if (account instanceof SavingsAccount) {
                            SavingsAccount savingsAccount = (SavingsAccount) account;
                            savingsAccount.applyInterest();
                            System.out.println("Interest applied to savings account.");
                        } else {
                            System.out.println("Invalid account type for applying interest.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    // Close account
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    System.out.print("Enter account number to close: ");
                    String closeAccountNumber = scanner.nextLine();
                    Customer closeCustomer = bank.getCustomer(customerId);
                    if (closeCustomer != null) {
                        closeCustomer.closeAccount(closeAccountNumber);
                        System.out.println("Account closed successfully.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    // View transaction history
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String transAccountNumber = scanner.nextLine();
                    Customer transCustomer = bank.getCustomer(customerId);
                    if (transCustomer != null) {
                        Account transAccount = transCustomer.getAccount(transAccountNumber);
                        if (transAccount != null) {
                            transAccount.displayTransactionHistory();
                        } else {
                            System.out.println("Account not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 8:
                    // View all customer accounts
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    Customer viewCustomer = bank.getCustomer(customerId);
                    if (viewCustomer != null) {
                        viewCustomer.displayAccounts();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 9:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting the system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
