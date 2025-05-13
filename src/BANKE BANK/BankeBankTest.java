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
        String accountNumberstr =  bank.createAccount("Josh", "Enenche", "2235");
        BankeAccounts acc1 = new BankeAccounts("Josh", "Enenche", "2235",accountNumberstr);
       System.out.println(accountNumberstr);
        acc1.deposit( accountNumberstr,20000,"2235");
        assertEquals(20000, acc1.getBalance());
   }

   @Test
    @DisplayName("Test that users can withdraw money from their account")
    public void testThatUsersCanWithdrawMoneyFromTheirAccount() {
        BankeBank bank = new BankeBank();
        String accountNumber =  bank.createAccount("Josh", "Enenche", "2235");
       System.out.println(accountNumber);
        BankeAccounts account2 = new BankeAccounts("Josh", "Enenche", "2235",accountNumber);
       account2.deposit(accountNumber, 2000,"2235");
       account2.withdrawal(accountNumber,  1000, "2235");
        assertEquals(1000, account2.getBalance());
   }

   @Test
    @DisplayName("Test that users can check their account balance")
    public void testThatUsersCanCheckTheirAccountBalance() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Josh", "Enenche", "2235");
        BankeAccounts account3 = new BankeAccounts("Josh", "Enenche", "2235",accountNumber);
       account3.deposit( accountNumber,20000,"2235");
       account3.withdrawal(accountNumber, 15000, "2235");
        assertEquals(5000, account3.getBalance());
   }

   @Test
    @DisplayName("Test that users can transfer money from their account to another account")
    public void testThatUsersCanTransferMoneyFromTheirAccountToAnotherAccount() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Josh", "Enenche", "2235");
        BankeAccounts account4 = new BankeAccounts("Josh", "Enenche", "2235",accountNumber);
       account4.deposit(accountNumber, 20000,"2235");




        String accountNumber2 = bank.createAccount("Nicholas", "Enenche", "2231");
        BankeAccounts account5 = new BankeAccounts("Nicholas", "Enenche", "2235",accountNumber2);
       account5.deposit( accountNumber2,200,"2235");
       account4.transferMoney(account4, account5, 4000, "2231");
        assertEquals(16000, account4.getBalance());
   }

   @Test
    @DisplayName("Test that users can change their pin")
    public void testThatUsersCanChangeTheirPin() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Josh", "Enenche", "2235");
        BankeAccounts account1 = new BankeAccounts("Josh", "Enenche", "2235",accountNumber);
       account1.changePin(accountNumber,"2235", "5646");
       account1.deposit( accountNumber,20000, "5646");
       account1.withdrawal(accountNumber,  1000, "2235");
        assertEquals(20000, account1.getBalance());
       assertEquals(20000, account1.getBalance());

   }



}
