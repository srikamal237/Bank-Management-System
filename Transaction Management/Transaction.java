package Transaction Management;

public class Transaction {
    private String transactionType;
    private double amount;
    private LocalDateTime dateTime;


    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }


    public String getTransactionType() {
        return transactionType;
    }


    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void displayTransactionDetails(){
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.err.println("Date & Time: " + dateTime);
        
    }

    


}
