import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
          if (amount < 0) {
               throw new IllegalArgumentException("You can't withdraw negative amount");
          }

          if (amount == 0) {
               throw new IllegalArgumentException("You can't withdraw zero amount");
          }
          if (amount > this.accountBalance(pin)) {
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


public static void main(String[] args) {
Scanner input = new Scanner(System.in);
BankeBank bank = new BankeBank();
while (true){
     System.out.println("""
             1. Create an account with their first name and last name and pin.
             2. Close account.
             3. Deposit money.
             4. Withdraw money.
             5. Check Account balance
             6. Transfer from one account to another.
             7. Change Pin
             """);
     int choice = 0;
     try {
     System.out.println("Enter your choice: ");
     choice = input.nextInt();
     }catch (Exception e) {
          System.out.println("Invalid choice, Enter choice as integer between 1 - 7");
     }
    input.nextLine();
          switch (choice) {
          case 1:
          System.out.println("Enter your first name: ");
          String firstName = input.next();
          System.out.println("Enter your last name: ");
          String lastName = input.next();
          System.out.println("Enter your pin: ");
          String pin = input.next();
          try {
          bank.createAccount(firstName, lastName, pin);
          System.out.println("Account created successfully");
          }catch (Exception e) {
          System.out.println(e.getMessage());
          }
          break;
          case 2:
          System.out.println("Enter your pin: ");
          String pin2 = input.next();
          try {
          bank.closeAccount(pin2);
          System.out.println("Account closed successfully");
          }catch (Exception e) {
          System.out.println(e.getMessage());
          }
          break;
          case 3:
          System.out.println("Enter your pin: ");
          String pin3 = input.next();
          System.out.println("Enter amount to be deposited: ");
          double amount = input.nextDouble();
          try {
          bank.deposit(pin3,  amount);
          System.out.println(amount + " deposited successfully");
          }catch (Exception e){
          System.out.println(e.getMessage());
          }
          break;
          case 4:
          System.out.println("Enter your pin: ");
          String pin4 = input.next();
               System.out.println("Enter amount to be withdrawn: ");
          double amount2 = input.nextDouble();
          try {
               bank.withdraw(pin4, amount2);
               System.out.println(amount2 + " withdrawn successfully");
          }catch (Exception e){
               System.out.println(e.getMessage());
          }
          break;
          case 5:
          System.out.println("Enter your pin: ");
          String pin5 = input.next();
          try {

               System.out.println("Balance: " + bank.checkAccountBalance(pin5));
          }catch (Exception e){
               System.out.println(e.getMessage());
          }
          break;
          case 6:
               System.out.println("Enter your pin: ");
               String pin6 = input.next();
               System.out.println("Enter receiver pin: ");
               String pin7 = input.next();
               System.out.println("Enter amount to transfer: ");
               double amount3 = input.nextDouble();
               try {
                    bank.transferMoney(pin6, pin7, amount3);
                    System.out.println(amount3 + " transfer successfully");
               }catch (Exception e){
                    System.out.println(e.getMessage());
               }
               break;
               case 7:
                    System.out.println("Enter your pin: ");
                    String pin8 = input.next();
                    System.out.println("Enter new pin: ");
                    String pin9 = input.next();
                    try {

                         bank.changePin(pin8, pin9);
                         System.out.println("Your pin has change successfully");
                    }catch (Exception e){
                         System.out.println(e.getMessage());
                    }
                    break;
                    default:
                         System.out.println("Invalid choice");
                         break;

     }
          }
     }
}