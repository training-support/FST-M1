package Activity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import Activity.BankAccount;
import Activity.NotEnoughFundsException;

import static org.junit.jupiter.api.Assertions.*;

class ExpectedExceptionTest {

    @Test
    void notEnoughFunds() {
        // Create an object for BankAccount class
        final BankAccount account = new BankAccount(9);

        // Assertion for exception
        assertThrows(NotEnoughFundsException.class, new Executable() {
			public void execute() throws Throwable {
				account.withdraw(10);
			}
		},
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class
        final BankAccount account = new BankAccount(100);
    
        // Assertion for no exceptions
        assertDoesNotThrow(new Executable() {
			public void execute() throws Throwable {
				account.withdraw(100);
			}
		});
    }
}