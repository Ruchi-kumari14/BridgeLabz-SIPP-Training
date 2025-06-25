class BankAccount {
    // Static variable shared across all accounts
    static String bankName = "Maitree Bank";
    static int totalAccounts = 0;

    // Instance variables
    private String accountHolderName;
    private final int accountNumber; // Final variable - cannot be changed after assignment

    // Constructor
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName; // 'this' resolves ambiguity
        this.accountNumber = accountNumber;
        totalAccounts++; // Count each new account
    }

    // Static method to get total number of accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    // Main method to test the class
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Ruchi Kumari", 1001);
        BankAccount acc2 = new BankAccount("Amit Verma", 1002);

        // instanceof check
        if (acc1 instanceof BankAccount) {
            System.out.println("Account 1 details:");
            acc1.displayDetails();
        }

        if (acc2 instanceof BankAccount) {
            System.out.println("\nAccount 2 details:");
            acc2.displayDetails();
        }

        // Static method usage
        System.out.println("\nTotal Bank Accounts Created: " + BankAccount.getTotalAccounts());
    }
}
