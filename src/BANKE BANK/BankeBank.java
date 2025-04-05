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
               throw new IllegalArgumentException("Incorrect pin, please enter a valid 4 digit number");
          }
          if (toPin == null || toPin.length() < 4 || !toPin.matches("[0-9]{4}")) {
               throw new IllegalArgumentException("Incorrect pin, please enter a valid 4 digit number");
          }
          if (fromPin.equals(toPin)) {
               throw new IllegalArgumentException("Incorrect pin, Receiver pin and Sender pin cannot be the same");
          }

          BankeAccounts sender = null, receiver = null;
          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(fromPin)) {
                    sender = account;
               }
               if (account.getPin().equals(toPin)) {
                    receiver = account;
               }
               if (sender != null && receiver != null) {
                    break;
               }
          }

          if(sender == null) {
               throw new IllegalArgumentException("Sender account not found");
          }
          if(receiver == null) {
               throw new IllegalArgumentException("Receiver account not found");
          }
          sender.setBalance(sender.getBalance() - amount);
          receiver.setBalance(receiver.getBalance() + amount);
     }
}