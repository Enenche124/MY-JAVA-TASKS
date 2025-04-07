import java.util.Scanner;

public class BankePrototype {

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
             8. Exit the program.
             
             """);
            int choice = 0;
            try {
                System.out.println("Enter your choice: ");
                choice = input.nextInt();
            }catch (Exception e) {
                System.out.println("Invalid choice, Enter choice as integer between 1 - 8");
            }
            input.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Enter your first name: ");
                    String firstName = input.next().trim();
                    while (true) {
                        if (!firstName.matches("[a-zA-Z\\s]+") || firstName.length() > 20 || firstName.length() <= 1) {
                            System.out.printf("%n%s","First name must be a valid letter, please enter a valid letter ranging from 2 and above, But less than 20");
                            firstName = input.next();
                        }else {
                            break;
                        }
                    }

                    System.out.println("Enter your last name: ");
                    String lastName = input.next();
                    while (true) {
                        if (lastName.length() <= 1 || !lastName.matches("[a-zA-Z\\s]+") || lastName.length() > 20) {
                            System.out.printf("%n%s%n","Last name must be a valid letter, please enter a last name ranging from 2 and above, But less than 20");
                            lastName = input.next();
                        }else {
                            break;
                        }

                    }
                    System.out.println("Enter your pin: ");
                    String pin = input.next();
                    while (true) {
                        if (pin.length() <= 1 || !pin.matches("[0-9]{4}")) {
                            System.out.printf("%n%s%n","Invalid, Pin must be a valid 4 digit number ");
                            pin = input.next();
                        }else {
                            break;
                        }
                    }
                    try {
                        bank.createAccount(firstName, lastName, pin);
                        long accountNumber = bank.createAccount(firstName, lastName, pin);
                        System.out.printf("%n%s%s %s%n","Account created successfully for ", firstName, lastName);
                        System.out.println("Your account number is " + accountNumber);

                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter your pin: ");
                    String pin2 = input.next();
                    try {
                        bank.closeAccount(pin2);
                        System.out.printf("%n%s%n", "Your account has been closed successfully");
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter amount to be deposited: ");
                    double amount = input.nextDouble();


                    System.out.println("Enter your pin: ");
                    String pin3 = input.next();
                    while (true){
                        if (pin3.length() <= 1 || !pin3.matches("[0-9]{4}")) {
                            System.out.printf("%n%s%n","Invalid, Pin must be a valid 4 digit number ");
                            pin3 = input.next();
                        }else {
                            break;
                        }
                    }

                    try {
                        bank.deposit(amount, pin3);
                        System.out.printf("%n%s%,.2f%n", "You have successfully deposited ", amount);
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
                        System.out.printf("%n%s%,.2f%n", "You have successfully withdrawn ", amount2);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter your pin: ");
                    String pin5 = input.next();
                    try {

                        System.out.printf("%n%s%,.2f", "Balance: ", bank.checkAccountBalance(pin5));
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
                        pin7 = bank.accounts.getLast().getFirstname();
                        System.out.printf("%n%s%,.2f%s%s%n", "You have successfully transferred ", amount3, " to ", pin7);
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
                        System.out.printf("%n%s%n", "Your pin has been changed successfully");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Exiting the program....");
                    break;
                default:
                    System.out.println("Invalid choice, choose between 1 - 8");
                    break;

            }

            if (choice == 8)break;
        }
    }


}
