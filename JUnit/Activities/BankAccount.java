package activities;

public class BankAccount {
    private Integer balance;

    // Create a constructor
    public BankAccount(Integer initialBalance) {
        balance = initialBalance;
    }
    public Integer withdraw(Integer amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }
}