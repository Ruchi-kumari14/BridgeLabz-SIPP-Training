import java.util.*;

class Bank {
    String name;
    List<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    // Associate a customer with this bank
    public void openAccount(Customer customer, String accountType, double initialBalance) {
        Account account = new Account(this, accountType, initialBalance); // Link back to bank
        customer.addAccount(account);
        customers.add(customer); // associate customer with bank
        System.out.println("Account opened for " + customer.name + " in " + name + " (" + accountType + ")");
    }

    public void listCustomers() {
        System.out.println("\nCustomers of " + name + ":");
        for (Customer c : customers) {
            System.out.println("- " + c.name);
        }
    }
}

class Customer {
    String name;
    List<Account> accounts = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("\n" + name + "'s Accounts:");
        for (Account a : accounts) {
            System.out.println("Bank: " + a.bank.name + ", Type: " + a.accountType + ", Balance: ₹" + a.balance);
        }
    }
}

class Account {
    Bank bank;
    String accountType;
    double balance;

    public Account(Bank bank, String accountType, double balance) {
        this.bank = bank;
        this.accountType = accountType;
        this.balance = balance;
    }
}

public class BankAndAccounts {
    public static void main(String[] args) {
        // Create Bank
        Bank sbi = new Bank("SBI");
        Bank hdfc = new Bank("HDFC");

        // Create Customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts
        sbi.openAccount(alice, "Savings", 10000);
        sbi.openAccount(bob, "Current", 25000);
        hdfc.openAccount(alice, "Fixed Deposit", 50000);

        // View balances
        alice.viewBalance();
        bob.viewBalance();

        // List customers in banks
        sbi.listCustomers();
        hdfc.listCustomers();
    }
}
