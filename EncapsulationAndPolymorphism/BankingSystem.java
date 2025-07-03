// Interface for loan services
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters (encapsulated)
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited. New Balance: ₹" + balance);
        }
    }

    // Withdraw method with validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn. New Balance: ₹" + balance);
        } else {
            System.out.println("Withdrawal failed: Insufficient balance or invalid amount.");
        }
    }

    // Protected method to allow subclasses to modify balance
    protected void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + holderName + ", Balance: ₹" + balance);
    }

    // Abstract method to be implemented
    public abstract double calculateInterest();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accNum, String holder, double bal) {
        super(accNum, holder, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for Savings Account: ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(String accNum, String holder, double bal) {
        super(accNum, holder, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan request received for Current Account: ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        // Create accounts (polymorphism)
        BankAccount acc1 = new SavingsAccount("SB123", "Priya", 15000);
        BankAccount acc2 = new CurrentAccount("CA456", "Rahul", 7000);

        BankAccount[] accounts = { acc1, acc2 };

        for (BankAccount account : accounts) {
            account.displayAccountDetails();

            double interest = account.calculateInterest();
            System.out.println("Interest Earned: ₹" + interest);

            account.deposit(1000);
            account.withdraw(500);

            // Loan interface methods
            account.applyForLoan(20000);
            boolean eligible = account.calculateLoanEligibility();
            System.out.println("Loan Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));

            System.out.println("----------------------------");
        }
    }
}
