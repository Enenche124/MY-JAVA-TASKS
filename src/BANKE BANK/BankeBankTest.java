import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankeBankTest {

    BankeBank bank = new BankeBank();
    @Test
    @DisplayName("test that users can create account")
    public void testThatUserCanCreateAccount() {
        assertTrue(bank.createAccount("Enenche", "John", "2001", "apochi12@gmail.com",0, 0,0), "Account created");
    }

   @Test
    @DisplayName("test that many users can create account")
    public void testThatManyUsersCanCreateAccount() {
        bank.createAccount("Obida", "Janet", "1234", "obida78@gmail.com",0, 0,0);
       bank.createAccount("Naddo", "Mary", "2004", "mary77@gmail.com",0, 0,0);
       bank.createAccount("pastor", "Moses", "1983", "moses67@gmail.com", 0, 0,0);
       bank.createAccount("pastor", "Moses", "1983", "jaoses67@gmail.com", 0, 0,0);
       assertEquals( 4, bank.size());
   }

   @Test
    @DisplayName("Test that different users can not have the same email")
    public void testThatDifferentUsersCanNotHaveSameEmail() {
        bank.createAccount("Micheal", "Hilary", "1010", "hilary11@gmail.com", 0, 0,0);
        try {
        bank.createAccount("Jeremiah","Oyare", "2020", "hilary11@gmail.com", 0, 0,0);
            fail("have thrown an exception, try different email");
        }catch (Exception e) {
            assertEquals("Email already exists", e.getMessage());
        }
   }

   @Test
    @DisplayName("test that users can close account")
    public void testThatUsersCanCloseAccount() {
        bank.createAccount("Mary", "James", "2001", "Mary12@gmail.com", 0, 0,0);
        bank.createAccount("Nicholas", "Agbo", "2003", "Niko12@gmail.com",0, 0,0);
        bank.closeAccount("Mary12@gmail.com");
        assertEquals( 1, bank.size());
        assertFalse(bank.contains("Mary12@gmail.com"));

   }

   @Test
    @DisplayName("Test that user can deposit money into account")
    public void testThatUsersCanDepositMoneyIntoAccount() {
       boolean mary = bank.createAccount("Mary", "James", "2601", "Mary12@gmail.com",0, 0,0);
       int result = bank.depositMoney(2000);
       assertEquals( result, bank.balance());


   }


}
