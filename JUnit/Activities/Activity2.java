package activities;

import org.junit.jupiter.api.Test;
import activities.BankAccount;
import activities.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

class ExpectedExceptionTest {

    @Test
    void notEnoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(20);

        // Assertion for exception
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(30),
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(100);
        
        //Expected balance
        int expectedBalance=0;
    
        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(10));
        assertEquals(expectedBalance, account.withdraw(90));
    }
}