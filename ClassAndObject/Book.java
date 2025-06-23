import java.util.Scanner;

class Book {
    // Attributes
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("\nBook Details:");
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("Price:  ₹" + price);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();

        // Create Book object
        Book book = new Book(title, author, price);

        // Display book details
        book.displayDetails();

        scanner.close();
    }
}
