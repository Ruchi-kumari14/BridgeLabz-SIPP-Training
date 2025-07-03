// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class representing a general library item
abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    private String borrower; // sensitive info

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrower = null;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Reserved by " + getMaskedBorrower()));
    }

    protected String getMaskedBorrower() {
        if (borrower == null) return "";
        return borrower.charAt(0) + "****";
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            this.borrower = borrowerName;
            isAvailable = false;
            System.out.println("Item reserved successfully for " + getMaskedBorrower());
        } else {
            System.out.println("Item is currently not available.");
        }
    }

    public abstract int getLoanDuration(); // in days
}

// Subclass: Book
class Book extends LibraryItem {
    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }
}

// Subclass: DVD
class DVD extends LibraryItem {
    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }
}

// Test class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Use polymorphism to create various items
        LibraryItem[] items = {
            new Book("B001", "Java Basics", "James Gosling"),
            new Magazine("M001", "Tech Monthly", "Jane Doe"),
            new DVD("D001", "Interstellar", "Christopher Nolan")
        };

        // Display details and reserve items
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            item.reserveItem("Rahul"); // borrower info is masked
            item.getItemDetails();
            System.out.println("-------------------------");
        }
    }
}
