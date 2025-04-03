import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CheckOutSystem{

    public static void main(String[] args){
        Scanner receiver = new Scanner(System.in);


        double userDiscount;
        double subTotal;
        double discount;
        double vat;
        double billTotal;
        double givenAmount;
        double balance = 0;
        String cashierName;
        String choice;
        double totalAmount;
        double totals = 0;
        int numberOfItem;
        double amount;

        Date current = new Date();

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Double> total = new ArrayList<>();

        System.out.println("What is the customer's name");
        String customerName = receiver.nextLine();

        while(!customerName.matches("[a-zA-Z\\s]+")){
            System.out.println("Enter a valid name");
            customerName = receiver.nextLine().trim();
        }


        do {
            System.out.println("What did the user buy?");
            String itemsName = receiver.nextLine();
            items.add(itemsName);

            while (!itemsName.matches("[a-zA-Z\\s]+")) {
                System.out.println("Enter a valid product name");
                itemsName = receiver.next();
            }


            while (true) {
                try {
                    System.out.println("How many pieces?");
                    numberOfItem = receiver.nextInt();
                    if (numberOfItem >= 1) {
                        quantity.add(numberOfItem);
                        break;
                    } else {
                        System.out.println("Please enter a positive number for the quantity");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, pls enter integer for quantity");
                    receiver.next();
                }
            }


            while(true){
            try {
                System.out.println("How much per unit");
                 amount = receiver.nextDouble();
                if (amount > 0) {
                    price.add(amount);
                    break;
                } else if (amount <= 0) {
                    System.out.println("Invalid, Amount must be greater than zero");

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input, pls enter integer for price");
                receiver.next();
            }

        }


            totalAmount = amount * numberOfItem;
            total.add(totalAmount);
            totals = totals + totalAmount;
            System.out.println("Add more items?");
            receiver.nextLine();
            choice = receiver.nextLine();

            while(!choice.equalsIgnoreCase("yes")&& !choice.equalsIgnoreCase("no")){
                System.out.println("You enter invalid input, choose either (Yes or No)");
                choice = receiver.nextLine();
            }
        }while
        (choice.equalsIgnoreCase("Yes"));

        if(!choice.equalsIgnoreCase("Yes")){
            System.out.println("what is the cashier name");
            cashierName = receiver.next();
            receiver.nextLine();
            while(!cashierName.matches("[a-zA-Z\\s]+")){
                System.out.println("Enter a valid name for your cashier");
                cashierName = receiver.nextLine();
            }


            while (true) {
                try {

                System.out.println("How much discount will he/she get?");
                userDiscount = receiver.nextDouble();
                if (userDiscount >= 1) {
                    discount = (userDiscount / 100) * totals;
                    break;
                }
                }catch (InputMismatchException e){
                    System.out.println("Invalid input, pls enter integer for user discount");
                    receiver.next();
                }
            }

            System.out.println(" ");
            subTotal = totals;
            vat = totals * 0.175;
            billTotal = totals + vat - discount;




            System.out.printf("%s%n%s", "SEMICOLON STORES", "MAIN BRANCH");
            System.out.printf("%s%n%s%n", "LOCATION: 312, HERBERT MACAULAY WAY, SABO  YABA, LAGOS.", "TELL: 090896757563");
            System.out.println("DATE: " + current);
            System.out.println("CASHIER: " + cashierName);
            System.out.println("CUSTOMER NAME: " + customerName);
            System.out.println("===================================================================");
            System.out.printf("%-10s %-10s %-10s %-10s %n", "ITEMS", "QTY", "PRICE", "TOTAL(NGN)");
            System.out.println("--------------------------------------------------------------------");

            for(int item = 0; item < items.size(); item++){
                System.out.printf("%-10s %-10d %-10.2f %-10.2f %n", items.get(item), quantity.get(item), price.get(item), total.get(item));

            }
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%30s%.2f%n", "Sub total: ", subTotal);
            System.out.printf("%30s%.2f%n", "Discount: ", discount);
            System.out.printf("%30s%.2f%n", "Vat @ 17.50%: ", vat);
            System.out.println("==========================================================================");
            System.out.printf("%30s%.2f%n", "Bill total: ", billTotal);
            System.out.println("===========================================================================");
            System.out.println("THIS IS NOT AN RECEIPT KINDLY PAY " + billTotal);
            System.out.println("============================================================================");

            System.out.println(" ");
            System.out.println(" ");


            while (true) {
                try {
                System.out.println("How much did the customer give to you? ");
                givenAmount = receiver.nextInt();
                    if(billTotal > givenAmount){
                        System.out.printf("%s%.2f%s%.2f%n","The amount you are to pay is -> ", billTotal, " Not ", givenAmount);
                        System.out.printf("%s%.2f", "Kindly pay your full money -> ", billTotal);
                    } else if (givenAmount > billTotal) {
                        balance = givenAmount - billTotal;
                        break;
                    } else if (givenAmount == billTotal) {
                        break;

                    }
                }catch (InputMismatchException e){
                    System.out.println("Invalid input, pls enter integer for given amount");
                    receiver.next();
                }
            }



            System.out.printf("%s%n%s", "SEMICOLON STORES", "MAIN BRANCH");
            System.out.printf("%s%n%s%n", "LOCATION: 312, HERBERT MACAULAY WAY, SABO  YABA, LAGOS.", "TELL: 090896757563");
            System.out.println("DATE: 3-JAN-2025 8:57:32PM");
            System.out.println("CASHIER: " + cashierName);
            System.out.println("CUSTOMER NAME: " + customerName);
            System.out.println("=====================================================================");
            System.out.printf("%-10s %-10s %-10s %-10s %n", "ITEMS", "QTY", "PRICE", "TOTAL(NGN)");
            System.out.println("-----------------------------------------------------");

            for(int i = 0; i < items.size(); i++){
                System.out.printf("%-10s %-10d %-10.2f %-10.2f %n", items.get(i), quantity.get(i), price.get(i), total.get(i));

            }
            System.out.println("----------------------------------------------------------------------");
            System.out.printf("%30s%.2f%n", "Sub total: ", subTotal);
            System.out.printf("%30s%.2f%n", "Discount: ", discount);
            System.out.printf("%30s%.2f%n", "Vat @ 17.50%: ", vat);
            System.out.println("==============================================");
            System.out.printf("%30s%.2f%n", "Bill total: ", billTotal);
            System.out.printf("%30s%.2f%n", "Amount paid: ", givenAmount);
            System.out.printf("%30s%.2f%n", "Balance: ", balance);
            System.out.println("==============================================");
            System.out.println("THANK YOU FOR YOUR PATRONAGE");


        }
    }

}
