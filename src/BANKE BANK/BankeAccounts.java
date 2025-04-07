import java.util.Random;

public class BankeAccounts {
    private String firstname;
    private String lastname;
    private final long accountNumber;
    private String pin;
    private double balance;

    public BankeAccounts(String firstname, String lastname, String pin, long accountNumber) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.pin = pin;
        this.accountNumber = accountNumber;

        this.balance = 0;
    }



    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }else {
            this.balance = balance;
        }
    }


    public void deposit(double deposit) {
        if (deposit  < 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero");
        }else {
            this.balance += deposit;
        }
    }


public void  setWithdrawal(double withdrawalAmount, String newPin) {
        if (withdrawalAmount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }else if (withdrawalAmount < 0) {
            throw new IllegalArgumentException("Withdrawal can't be negative");
        }else {
            if (newPin.equals(this.pin)) {
                this.balance -= withdrawalAmount;
            }
        }
    }

public long getAccountNumber(){
        return accountNumber;
}


}
