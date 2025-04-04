import java.util.ArrayList;
import java.util.List;

public class BankeBank {
     private final List<BankeAccounts> accounts = new ArrayList<>();


     public boolean createAccount(String firstname, String lastname, String pin) {
          if (!firstname.isEmpty() && !lastname.isEmpty() && pin.length() == 4 && pin.matches("[0-9]{4}")) {

          }

          BankeAccounts account1 = new BankeAccounts(firstname, lastname, pin);
          accounts.add(account1);
          return true;
     }

     public boolean isEmpty() {
          System.out.println(accounts.size());
          return accounts.isEmpty();
     }


     public Object size() {
          for (BankeAccounts account : accounts) {
               System.out.println("First Name: " + account.getFirstname() + ", Last Name: " +  account.getLastname() + ", Pin: " + account.getPin() +  ", Email: " + account.getEmail());
          }
          return accounts.size();
     }

     public void closeAccount(String email) {
          for (BankeAccounts account : accounts) {
               if (account.getEmail().equals(email)) {
                    accounts.remove(account);
                    return;
               }
          }
     }

     public boolean contains(String mail) {
          for (BankeAccounts account : accounts) {
               if (account.getEmail().equals(mail)) {
                    return true;
               }
          }
          return false;
     }




     public int depositMoney(double amount) {
          if (accounts.isEmpty() || amount < 0) {
               throw new IllegalArgumentException("Account is empty");
          }else {
               for (BankeAccounts account : accounts) {
                    if (account.getDeposit() >= amount ||
                            account.getDeposit() > 0) {
                         account.setBalance(account.getBalance()
                                 + amount);
                    }

               }
          }
          return 0;
     }


     public int balance() {
        if (accounts.isEmpty()) {
             return 0;
        }else {
             for (BankeAccounts account : accounts) {
                  if (account.getDeposit() > 0) {
                 account.setBalance(account.getBalance() + account.getDeposit());

                  }
             }
        }
        return 0;

     }


     public static void main(String[] args) {
          BankeBank bank = new BankeBank();
          bank.createAccount("John","Enenche", "5646", "John56@gmail.com",0,2000,0);
          bank.depositMoney(2000);
          System.out.println(bank.balance());
          System.out.println(bank.size());
          System.out.println(bank);
     }
}