import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Activity2 {

    @Test
    void notEnoughFunds() {

        BankAccount account = new BankAccount(9);

        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10), "Balance must be greater than amount of withdrawal");
    }
    @Test
    void enoughFunds() {

        BankAccount account = new BankAccount(100);

        assertDoesNotThrow(() -> account.withdraw(100));
    }

}