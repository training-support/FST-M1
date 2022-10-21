package activities;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

class Activity2 {

	@Test
	void notEnoughFunds() {		
		//BankAccount account = new BankAccount(10);
		BankAccount account1 = new BankAccount(9);
		assertThrows(NotEnoughFundsException.class, ()->account1.withdraw(10));
	}
	
	@Test
	void enoughFunds() {
		
		//BankAccount account2 = new BankAccount(100);
		BankAccount account2 = new BankAccount(100);
		assertDoesNotThrow(() -> account2.withdraw(100));
	}

}
