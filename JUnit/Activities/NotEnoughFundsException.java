package activityPrograms;

public class NotEnoughFundsException extends Throwable {
    public NotEnoughFundsException(Integer amount, Integer balance) {
        super("Attempted to withdraw " + amount + " with a balance of " + balance);
    }
}
