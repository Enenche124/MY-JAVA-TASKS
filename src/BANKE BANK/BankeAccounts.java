import java.math.BigDecimal;

public class BankeAccounts {
    private final String firstname;
    private final String lastname;
    private String pin;
    private final String email;
    private double balance;
    private double deposit;
    private double withdrawal;


    public BankeAccounts(String firstname, String lastname, String pin, String email, double balance, double deposit, double withdrawal ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pin = pin;
        this.email = email;

        if (balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }else{
            this.balance = balance;
        }


        if (deposit  <  0) {
            throw new IllegalArgumentException("Deposit must be greater than zero");
        }else {
            this.balance += deposit;
        }
        if (withdrawal > balance) {
            throw new IllegalArgumentException("Withdrawal amount can not be greater than balance");
        }else {
            this.withdrawal = withdrawal;
        }
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
    public String getEmail() {
        return email;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if (balance <= 0) {
            throw new IllegalArgumentException("Balance must be greater than zero");
        }else {
            this.balance = balance;
        }
    }
    public double getDeposit() {
        return deposit;
    }
    public void setDeposit(double deposit) {
        if (deposit  <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero");
        }else {
            this.deposit = deposit;
        }
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawalAmount) {
        if (withdrawalAmount > balance) {
            throw new IllegalArgumentException("Withdrawal amount can not be greater than balance");
        }else {
            this.balance -= withdrawalAmount;
        }
    }



}
