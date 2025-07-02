// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayCommonDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass 1: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayCommonDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayCommonDetails();
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// Subclass 3: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int lockInPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayCommonDetails();
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", 25000.00, 4.5);
        CheckingAccount checking = new CheckingAccount("CHK456", 15000.00, 10000.00);
        FixedDepositAccount fixed = new FixedDepositAccount("FD789", 100000.00, 12);

        System.out.println(" Savings Account");
        savings.displayAccountType();

        System.out.println("\n Checking Account");
        checking.displayAccountType();

        System.out.println("\n Fixed Deposit Account");
        fixed.displayAccountType();
    }
}
