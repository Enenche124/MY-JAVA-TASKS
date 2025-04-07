import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankeBankTest {

    @Test
    @DisplayName("test that users can create account")
    public void testThatUserCanCreateAccount() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Josh", "Enenche", "2235");
        boolean result = !bank.isEmpty();
        assertTrue(result);
    }

    @Test
    @DisplayName("Test that multiple users can create account")
    public void testThatMultipleUserCanCreateAccount() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Josh", "Enenche", "2235");
        bank.createAccount("James", "Heinz", "4444");
        bank.createAccount("James", "Heinz", "5555");
        bank.createAccount("James", "Heinz", "6532");
        assertEquals( 4, bank.size());
    }

       @Test
    @DisplayName("test that users can close account")
    public void testThatUsersCanCloseAccount() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Mary", "James", "2001");
        bank.createAccount("Nicholas", "Agbo", "2003");
        bank.closeAccount("2003");
        assertEquals( 1, bank.size());
   }

   @Test
    @DisplayName("Test that users can deposit money into their account")
    public void testThatUsersCanDepositMoneyIntoTheirAccount() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Josh", "Enenche", "2235");
        bank.createAccount("Nicholas", "Enenche", "2231");
        bank.deposit( 2000,"2235");
        bank.deposit( 20000,"2231");
        assertEquals(2000, bank.accountBalance("2235"));
   }

   @Test
    @DisplayName("Test that users can withdraw money from their account")
    public void testThatUsersCanWithdrawMoneyFromTheirAccount() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Josh", "Enenche", "2235");
        bank.deposit( 2000,"2235");
       bank.withdraw("2235", 1000);
        assertEquals(1000, bank.accountBalance("2235"));
   }

   @Test
    @DisplayName("Test that users can check their account balance")
    public void testThatUsersCanCheckTheirAccountBalance() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Josh", "Enenche", "2235");
        bank.deposit( 20000,"2235");
        bank.withdraw("2235", 15000);
        bank.checkAccountBalance("2235");
        assertEquals(5000, bank.accountBalance("2235"));
   }

   @Test
    @DisplayName("Test that users can transfer money from their account to another account")
    public void testThatUsersCanTransferMoneyFromTheirAccountToAnotherAccount() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Josh", "Enenche", "2235");
        bank.createAccount("Nicholas", "Enenche", "2231");
        bank.deposit( 20000,"2235");
        bank.transferMoney("2235", "2231", 6000);
        assertEquals(6000, bank.accountBalance("2231"));
   }

   @Test
    @DisplayName("Test that users can change their pin")
    public void testThatUsersCanChangeTheirPin() {
        BankeBank bank = new BankeBank();
        bank.createAccount("Josh", "Enenche", "2235");
        bank.changePin("2235", "5646");
        bank.deposit( 20000, "5646");
        assertEquals(20000, bank.accountBalance("5646"));

   }



}
