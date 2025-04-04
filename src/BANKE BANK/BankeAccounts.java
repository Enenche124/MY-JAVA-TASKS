
public class BankeAccounts {
    private final String firstname;
    private final String lastname;
    private String pin;

    private double balance;




    public BankeAccounts(String firstname, String lastname, String pin) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pin = pin;
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
//    public double getDeposit() {
//        return deposit;
//    }

    public void deposit(double deposit) {
        if (deposit  < 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero");
        }else {
            this.balance += deposit;
        }
    }

//    public double getWithdrawal() {
//        return withdrawal;
//    }

    public void setWithdrawal(double withdrawalAmount) {
        if (withdrawalAmount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }else if (withdrawalAmount < 0) {
            throw new IllegalArgumentException("Withdrawal can't be negative");
        }else {
            this.balance -= withdrawalAmount;
        }
    }



}
