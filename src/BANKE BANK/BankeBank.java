import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankeBank {
     private final List<BankeAccounts> accounts = new ArrayList<>();

     public void createAccount(String firstname, String lastname, String pin) {
          if (!firstname.trim().isEmpty() && !lastname.trim().isEmpty() && pin.length() == 4 && pin.matches("[0-9]{4}")) {
               if (!accounts.contains(pin)) {
                    BankeAccounts newAccount = new BankeAccounts(firstname, lastname, pin);
                    accounts.add(newAccount);
                    return;
               }
          }
          throw new IllegalArgumentException("Firstname and lastname and pin are required");
     }

     public boolean isEmpty() {
          System.out.println(accounts.size());
          return accounts.isEmpty();
     }

     public int size() {
          return accounts.size();
     }

     public void closeAccount(String pin) {
          Iterator<BankeAccounts> iterating = accounts.iterator();
          while (iterating.hasNext()) {
               BankeAccounts account = iterating.next();
               if (account.getPin().equals(pin)) {
                    iterating.remove();
                    return;
               }
          }
//         accounts.removeIf(account -> account.getPin().equals(pin));

     }

     public void deposit(String pin, double amount) {
          if(amount < 0) {
               throw new IllegalArgumentException("You can't deposit negative amount");
          }else {
               for (BankeAccounts account : accounts) {
                    if (account.getPin().equals(pin)) {
                         account.setBalance(account.getBalance() + amount);
                         System.out.println("Deposited " + amount + " to " + account.getFirstname() + " " + account.getLastname() + " Account");
                         return;
                    }
               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");
     }

     public double accountBalance(String pin) {
          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(pin)) {
                    return account.getBalance();
               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");
     }

     public void withdraw(String pin, double amount) {
          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(pin)) {
                    account.setBalance(account.getBalance() - amount);
                    System.out.println(account.getFirstname()  + " You have successfully withdraw " + amount);
                    return;
               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");
     }


}