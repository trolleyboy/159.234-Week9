package tutorial9.task3;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    
    // attributes
    private int accountNumber;
    private double amount;
    private String transactionType;
    private LocalDate date;
    // constructors

    /**
     * @param accountNumber
     * @param amount
     * @param transactionType
     * @param date
     */
    public Transaction(int accountNumber, double amount, String transactionType, LocalDate date) {
        this.setAccountNumber(accountNumber);
        this.setAmount(amount);
        this.setTransactionType(transactionType);
        this.setDate(date);
    }

    // methods
    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    /**
     * @param accountNumber the accountNumber to set
     */
    private void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }
    /**
     * @param amount the amount to set
     */
    private void setAmount(double amount) {
        this.amount = amount;
    }
    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }
    /**
     * @param transactionType the transactionType to set
     */
    private void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }
    /**
     * @param date the date to set
     */
    private void setDate(LocalDate date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Transaction [accountNumber=" + accountNumber + ", amount=" + amount + ", date=" + date
                + ", transactionType=" + transactionType + "]";
    }

}
