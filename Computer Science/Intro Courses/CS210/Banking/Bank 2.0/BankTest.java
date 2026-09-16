/** 
* JUnit test for Bank class and BankMap class
* @author Paul Hoang
*/



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {
    private BankInterface bank;

    @BeforeEach
    void setUp() {
    	//bank = new Bank();
        bank = new BankMap(); 
    }

    @Test
    void testOpenAndDeposit() {
        bank.openAccount("Paul", "Hoang", "Seattle");
        
        // Verify account exists by depositing
        boolean test = bank.depositMoney("Paul", "Hoang", 100.0);
        assertTrue(test, "Deposit successful");
        
        // Verify balance
        double balance = bank.getBalance("Paul", "Hoang");
        assertEquals(100.0, balance, 0.001, "Balance is 100.0");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        bank.openAccount("Paul", "Hoang", "Seattle");
        bank.depositMoney("Paul", "Hoang", 50.0);
        
        // Try to withdraw more than 50
        boolean success = bank.withdrawalMoney("Paul", "Hoang", 100.0);
        assertFalse(success, "Withdrawal fail, insufficient funds");
    }
    
    @Test
    void testAccountNotFound() {
        // Try to access an account that was never created
        boolean success = bank.depositMoney("Paul", "Hoang", 50.0);
        assertFalse(success, "Deposit fail, no info found");
    }
}