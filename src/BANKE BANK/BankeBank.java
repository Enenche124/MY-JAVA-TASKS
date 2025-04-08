import java.util.ArrayList;
import java.util.*;

public class BankeBank {
     public final List<BankeAccounts> accounts = new ArrayList<>();
     private final Set<String> existingAccountNumber = new HashSet<>();

     public String createAccount(String firstname, String lastname, String pin) {
          if (firstname == null || firstname.trim().isEmpty()){
               throw new IllegalArgumentException("Firstname cannot be empty");
          }

          if (lastname == null || lastname.trim().isEmpty()) {
               throw new IllegalArgumentException("Lastname cannot be empty");
          }
          if (pin == null || pin.length() != 4 || !pin.matches("[0-9]{4}")) {
               throw new IllegalArgumentException("Pin must be a valid 4 digit number");
          }

          Random random = new Random();
          String accountNumber;
          do {
               accountNumber = String.valueOf(random.nextLong(1000000000L) + 9000000000L);

          }
          while (existingAccountNumber.contains(accountNumber));
          BankeAccounts newAccount = new BankeAccounts(firstname, lastname, pin, accountNumber);
          existingAccountNumber.add(accountNumber);


          accounts.add(newAccount);
          return accountNumber;
     }

     public boolean isEmpty() {
          return accounts.isEmpty();
     }

     public int size() {
          return accounts.size();
     }

     public void closeAccount(String pin) {
//          Iterator<BankeAccounts> iterating = accounts.iterator();
//          while (iterating.hasNext()) {
//               BankeAccounts account = iterating.next();
//               if (account.getPin().equals(pin)) {
//                    iterating.remove();
//                    return;
//               }
//          }
        accounts.removeIf(account -> account.getPin().equals(pin));


     }

     public void deposit(String accountNumber, double amount, String pin) {
          if (accountNumber == null || accountNumber.trim().isEmpty()) {
               throw new IllegalArgumentException("Account number cannot be empty");
          }
          if (!accountNumber.matches("[0-9]{10}")) {
               throw new IllegalArgumentException("Account number must be a valid 10 digit number");
          }

         if (pin == null || pin.length() != 4 || !pin.matches("[0-9]{4}")) {
             throw new IllegalArgumentException("Pin must be a valid 4 digit number");
         }
          if(amount < 0) {
               throw new IllegalArgumentException("You can't deposit negative amount");
          }else {
               for (BankeAccounts account : accounts) {
                    if (account.getAccountNumber().equals(accountNumber) && account.getPin().equals(pin)) {
                         account.setBalance(account.getBalance() + amount);
                         return;
                    }
               }
          }
          throw new IllegalArgumentException("Invalid PIN, Check your PIN and try again");
     }

     public double accountBalance(String accountNumber, String pin) {
         if (pin == null || pin.length() != 4 || !pin.matches("[0-9]{4}")) {
             throw new IllegalArgumentException("Pin must be a valid 4 digit number");
         }

          for (BankeAccounts account : accounts) {
               if (account.getAccountNumber().equals(accountNumber) && account.getPin().equals(pin)) {
                    return account.getBalance();
               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");
     }

     public void withdraw(String accountNumber, double amount, String pin) {
          if (amount < 0) {
               throw new IllegalArgumentException("You can't withdraw negative amount");
          }
          if (!accountNumber.matches("[0-9]{10}")) {
               throw new IllegalArgumentException("Account number must be a valid 10 digit number");
          }
          if (pin == null || pin.length() != 4 || !pin.matches("[0-9]{4}")) {
              throw new IllegalArgumentException("Pin must be a valid 4 digit number");
          }

          if (amount == 0) {
               throw new IllegalArgumentException("You can't withdraw zero amount");
          }

          if (amount > accountBalance(accountNumber, pin)) {
               throw new IllegalArgumentException("Insufficient balance");
          }

          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(pin)) {
                    account.setBalance(account.getBalance() - amount);
                    return;
               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");
     }


//     public double checkAccountBalance(String pin) {
//          for (BankeAccounts account : accounts) {
//               if (account.getPin().equals(pin)) {
//                    return account.getBalance();
//               }
//          }
//          throw new IllegalArgumentException("Account not found, Check your pin and try again");
//
//     }


     public void transferMoney(String fromAccountNumber, String toAccountNumber, double amount, String fromPin) {
          if(amount < 0) {
               throw new IllegalArgumentException("You can't transfer negative amount");
          }
          if (fromAccountNumber == null || fromAccountNumber.length() < 10 || !fromAccountNumber.matches("[0-9]{10}")) {
               throw new IllegalArgumentException("Incorrect account number, enter a valid 10 digit account number");
          }if ( toAccountNumber == null || toAccountNumber.length() < 10 || !toAccountNumber.matches("[0-9]{10}")) {
               throw new IllegalArgumentException("Incorrect account number, enter a valid 10 digit account number");
          }

          if (fromPin == null || fromPin.length() < 4 || !fromPin.matches("[0-9]{4}")) {
               throw new IllegalArgumentException("Incorrect pin, please enter a valid 4 digit number");
          }
          if (fromAccountNumber.equals(toAccountNumber)) {
               throw new IllegalArgumentException("Incorrect account number, Receiver account number and Sender account number cannot be the same");
          }

          BankeAccounts sender = null, receiver = null;
          for (BankeAccounts account : accounts) {
               if (account.getAccountNumber().equals(fromAccountNumber)) {
                    sender = account;
               }
               if (account.getAccountNumber().equals(toAccountNumber)) {
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

















//     public void transferMoney(String fromPin, String toPin, double amount) {
//          if(amount < 0) {
//               throw new IllegalArgumentException("You can't transfer negative amount");
//          }
//          if (fromPin == null || fromPin.length() < 4 || !fromPin.matches("[0-9]{4}")) {
//               throw new IllegalArgumentException("Incorrect pin, please enter a valid 4 digit number");
//          }
//          if (toPin == null || toPin.length() < 4 || !toPin.matches("[0-9]{4}")) {
//               throw new IllegalArgumentException("Incorrect pin, please enter a valid 4 digit number");
//          }
//          if (fromPin.equals(toPin)) {
//               throw new IllegalArgumentException("Incorrect pin, Receiver pin and Sender pin cannot be the same");
//          }
//
//          BankeAccounts sender = null, receiver = null;
//          for (BankeAccounts account : accounts) {
//               if (account.getAccountNumber().equals(fromPin)) {
//                    sender = account;
//               }
//               if (account.getPin().equals(toPin)) {
//                    receiver = account;
//               }
//               if (sender != null && receiver != null) {
//                    break;
//               }
//          }
//
//          if(sender == null) {
//               throw new IllegalArgumentException("Sender account not found");
//          }
//          if(receiver == null) {
//               throw new IllegalArgumentException("Receiver account not found");
//          }
//          sender.setBalance(sender.getBalance() - amount);
//          receiver.setBalance(receiver.getBalance() + amount);
//     }

     public void changePin(String pin, String newPin) {
          if (newPin == null || newPin.length() < 4 || !newPin.matches("[0-9]{4}")) {
               throw new IllegalArgumentException("Incorrect pin, please enter a valid 4 digit number");
          }
          if (newPin.equals(pin)) {
               throw new IllegalArgumentException("Enter a different pin not the same as the old pin");
          }
          for (BankeAccounts account : accounts) {
               if (account.getPin().equals(pin)) {
                    account.setPin(newPin);
                    return;
               }
          }
          throw new IllegalArgumentException("Account not found, Check your pin and try again");

     }

}