public class BankeAccounts {
    private final String firstname;
    private final String lastname;
    private final String accountNumber;
    private String pin;
    private double balance;

    public BankeAccounts(String firstname, String lastname, String pin, String accountNumber) {
        if (accountNumber.length() != 10 || !accountNumber.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Invalid account number, Enter 10 digits only");
        }
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



    public void deposit(String accountNumber, double depositAmount, String pin) {
        if (depositAmount  < 0) {
            throw new IllegalArgumentException("Deposit must be a positive value");
        }
        if(accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if(pin == null || pin.isEmpty()) {
            throw new IllegalArgumentException("Pin cannot be empty");
        }

        if (!this.accountNumber.equals(accountNumber)) {
            throw new IllegalArgumentException("Account number does not match");
        }

        if(!pin.equals(this.pin)) {
            throw new IllegalArgumentException("Pin does not match");
        }

            this.balance += depositAmount;

    }


public void  withdrawal(String accountNumber, double withdrawalAmount, String withdrawaPin) {
        if (withdrawalAmount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
      if (withdrawalAmount < 0) {
            throw new IllegalArgumentException("Withdrawal can't be negative");
        }

            if (withdrawaPin.equals(this.pin) && accountNumber.equals(this.accountNumber)) {
                this.balance -= withdrawalAmount;
            }
    }

    public void transferMoney(BankeAccounts fromAccountNumber, BankeAccounts toAccountNumber, double amount, String fromPin) {

        if (fromAccountNumber.equals(toAccountNumber)) {
            throw new IllegalArgumentException("Receiver account number cannot be the same");
        }
        if(amount < 0) {
            throw new IllegalArgumentException("You can't transfer negative amount");
        }
        if(amount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }


        this.balance -= amount;
        toAccountNumber.balance += amount;

    }


public String getAccountNumber(){
        return accountNumber;
}


}
