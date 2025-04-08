import java.util.Scanner;

public class BankePrototype {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankeBank bank = new BankeBank();

        while (true){
            System.out.println("""
             
             1. Create an account.
             2. Close account.
             3. Deposit money.
             4. Withdraw money.
             5. Check Account balance
             6. Transfer from one account to another.
             7. Change Pin
             0. Exit the program.
             
             """);
            int choice = -1;

                try {
                    System.out.println("Enter your choice: ");
                   choice = input.nextInt();
                }catch (Exception e) {
                    System.out.println("Invalid choice, Enter choice as integer between 1 - 8");
                }


//            input.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Enter your first name: ");
                    String firstName = input.nextLine().trim();
                    while (!firstName.matches("[a-zA-Z\\s\\-']+") || firstName.length() <= 1) {
                        System.out.println("Enter a valid first name: ");
                        firstName = input.nextLine().trim();
                    }
                    System.out.println("Enter your last name: ");
                    String lastName = input.nextLine().trim();
                    while (lastName.length() <= 1 || !lastName.matches("[a-zA-Z\\s\\-']+")) {
                        System.out.println("Enter a valid last name: ");
                        lastName = input.nextLine().trim();
                    }

                    System.out.println("Enter your pin: ");
                    String pin = input.nextLine().trim();
                    while (!pin.matches("[0-9]{4}") || pin.length() < 4) {
                        System.out.println("Enter a valid 4 digits pin: ");
                        pin = input.nextLine().trim();
                    }

                    try {
                        bank.createAccount(firstName, lastName, pin);
                        String accountNumber = bank.createAccount(firstName, lastName, pin);
                        System.out.printf("%n%s%s %s%n","Account created successfully for ", firstName, lastName);
                        System.out.println("Your account number is " + accountNumber);

                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter your pin: ");
                    String pin2 = input.nextLine().trim();
                    while (!pin2.matches("[0-9]{4}") ) {
                        System.out.println("Enter a 4 valid pin: ");
                        pin2 = input.nextLine().trim();
                    }
                    try {
                        bank.closeAccount(pin2);
                        System.out.printf("%n%s%n", "Your account has been closed successfully");
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter your account number: ");
                    String accountNumber2 = input.next();
                    while (!accountNumber2.matches("[0-9]{10}")) {
                        System.out.println("Enter a valid account number: ");
                        accountNumber2 = input.nextLine().trim();
                    }

                    double amount;
                    while (true){
                        try {
                    System.out.println("Enter amount to be deposited: ");
                    amount = input.nextDouble();
                    break;
                        }catch (Exception e) {
                            System.out.println("Enter a valid integer amount for deposit");
                        }
                    }


                    System.out.println("Enter your pin: ");
                    String pin3 = input.next();
                    while (!pin3.matches("[0-9]{4}")) {
                        System.out.println("Enter a valid pin: ");
                        pin3 = input.nextLine().trim();
                    }


                    try {
                        bank.deposit(accountNumber2, amount, pin3);
                        System.out.printf("%n%s%,.2f%s%s%n", "You have successfully deposited ", amount, " to ", accountNumber2);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:

                    System.out.println("Enter your account number: ");
                    String withdrawAccountNumber = input.nextLine().trim();
                    while (!withdrawAccountNumber.matches("[0-9]{10}")) {
                        System.out.println("Enter a valid account number: ");
                        withdrawAccountNumber = input.nextLine().trim();
                    }

                    double amount2;
                    while (true) {
                        try {
                            System.out.println("Enter amount to be withdrawn: ");
                            amount2 = input.nextDouble();
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    System.out.println("Enter your pin: ");
                    String pin4 = input.next();

                    while (!pin4.matches("[0-9]{4}")) {
                        System.out.println("Enter a 4 valid pin: ");
                        pin4 = input.nextLine().trim();
                    }

                    try {
                        bank.withdraw(withdrawAccountNumber,  amount2, pin4);
                        System.out.printf("%n%s%,.2f%n", "You have successfully withdrawn ", amount2);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:

                    System.out.println("Enter your account number: ");
                    String accountNumber3 = input.next();
                    while (!accountNumber3.matches("[0-9]{10}")) {
                        System.out.println("Enter a valid account number: ");
                        accountNumber3 = input.nextLine().trim();
                    }
                    System.out.println("Enter your pin: ");
                    String pin5 = input.next();
                    while (!pin5.matches("[0-9]{4}")) {
                        System.out.println("Enter a valid pin: ");
                        pin5 = input.nextLine().trim();
                    }
                    try {

                        System.out.print("Balance: " +   bank.accountBalance(accountNumber3, pin5));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Enter your account number: ");
                    String fromAccountNumber = input.next();
                    while (!fromAccountNumber.matches("[0-9]{10}")) {
                        System.out.println("Enter a valid account number: ");
                        fromAccountNumber = input.nextLine().trim();
                    }
                    System.out.println("Enter receiver account number: ");
                    String toAccountNumber = input.next();
                    while (!toAccountNumber.matches("[0-9]{10}")) {
                        System.out.println("Enter a valid receiver account number: ");
                        toAccountNumber = input.nextLine().trim();
                    }
                    double amount3;
                    while (true){
                        try {
                    System.out.println("Enter amount to transfer: ");
                     amount3 = input.nextDouble();
                     break;
                        }catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Enter your pin: ");
                    String fromPin = input.next();
                    while (!fromPin.matches("[0-9]{4}")) {
                        System.out.println("Enter a valid pin: ");
                        fromPin = input.nextLine().trim();
                    }

                    try {
                        bank.transferMoney(fromAccountNumber, toAccountNumber, amount3, fromPin);
                        System.out.printf("%n%s%,.2f%n", "You have successfully transferred ", amount3);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Enter your account number: ");
                    String accountNumber4 = input.next();
                    while (!accountNumber4.matches("[0-9]{10}")) {
                        System.out.println("Enter a valid account number: ");
                        accountNumber4 = input.nextLine().trim();
                    }
                    System.out.println("Enter your old pin: ");
                    String oldPin = input.next();
                    while (!oldPin.matches("[0-9]{4}")) {
                        System.out.println("Enter a valid pin: ");
                        oldPin = input.nextLine().trim();
                    }
                    System.out.println("Enter new pin: ");
                    String newPin = input.next();
                    while (!newPin.matches("[0-9]{4}")) {
                        System.out.println("Enter a 4 valid pin: ");
                        newPin = input.nextLine().trim();
                    }
                    try {

                        bank.changePin(accountNumber4, oldPin, newPin);
                        System.out.printf("%n%s%n", "Your pin has been changed successfully");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Exiting the program....");
                    break;
                default:
                    System.out.println("Invalid choice, choose between 1 - 8");
                    break;

            }

            if (choice == 0)break;
        }
    }


}
