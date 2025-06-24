public class BankAccount {
    public long accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Display details
    public void displayAccountDetails() {
        System.out.println("Account Number (public): " + accountNumber);
        System.out.println("Account Holder (protected): " + accountHolder);
        System.out.println("Balance (private via getter): ₹" + getBalance());
    }

    // Main method
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1234567890L, "Ruchi Kumari", 5000.0);

        account.displayAccountDetails();

        account.deposit(2000);
        System.out.println("After depositing ₹2000, Balance: ₹" + account.getBalance());

        account.withdraw(1500);
        System.out.println("After withdrawing ₹1500, Balance: ₹" + account.getBalance());
    }
}
