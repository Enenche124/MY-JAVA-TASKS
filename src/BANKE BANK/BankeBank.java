import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankeBank {
     private final List<BankeAccounts> accounts = new ArrayList<>();

     public void createAccount(String firstname, String lastname, String pin) {
          if (firstname == null || firstname.trim().isEmpty()) {
               throw new IllegalArgumentException("Firstname cannot be empty");
          }
          if (lastname == null || lastname.trim().isEmpty()) {
               throw new IllegalArgumentException("Lastname cannot be empty");
          }
          if (pin == null || pin.length() != 4 || !pin.matches("[0-9]{4}")) {
               throw new IllegalArgumentException("Pin must be a valid 4 digit number");
          }

          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(pin)) {
                    throw new IllegalArgumentException("Account already exists, please choose a different pin");
               }
          }
          accounts.add(new BankeAccounts(firstname, lastname, pin));
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


     public double checkAccountBalance(String pin) {
          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(pin)) {
                    return account.getBalance();


               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");

     }

     public void transferMoney(String fromPin, String toPin, double amount) {
          if(amount < 0) {
               throw new IllegalArgumentException("You can't transfer negative amount");
          }
          if (fromPin == null || fromPin.length() < 4 || !fromPin.matches("[0-9]{4}")) {
               throw new IllegalArgumentException("Incorrect pin");
          }
          if (toPin == null || toPin.length() < 4) {
               throw new IllegalArgumentException("Incorrect pin");
          }
          if (fromPin.equals(toPin)) {
               throw new IllegalArgumentException("Incorrect pin, Receiver pin and Sender pin cannot be the same");
          }

          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(fromPin)) {
                    account.setBalance(account.getBalance() - amount);
                    return;
               }
          }
          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(toPin)) {
                    account.setBalance(account.getBalance() + amount);
                    return;
               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");
     }
}