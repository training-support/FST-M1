package Activity;

import org.junit.jupiter.api.Test;
import Examples.BankAccount;
import Examples.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

class ExpectedExceptionTest {

    @Test
    void notEnoughFunds() {
        BankAccount account = new BankAccount(10);
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(15),
                "Balance should be greater then the amount withdrawn");
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(100);

        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}