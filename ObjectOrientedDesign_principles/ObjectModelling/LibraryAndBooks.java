import java.util.*;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    String name;
    List<Book> books = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book); // Aggregation: we’re using book object passed from outside
    }

    public void displayLibrary() {
        System.out.println("Library: " + name);
        System.out.println("Books in this library:");
        for (Book book : books) {
            book.displayBook(); // Call Book's method to print its info
        }
        System.out.println();
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        // Step 1: Create Book objects (they exist independently)
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        // Step 2: Create Library objects
        Library centralLibrary = new Library("Central Library");
        Library cityLibrary = new Library("City Library");

        // Step 3: Add books to libraries (aggregation happens here)
        centralLibrary.addBook(b1);
        centralLibrary.addBook(b2);

        cityLibrary.addBook(b2);  // same book added to multiple libraries
        cityLibrary.addBook(b3);

        // Step 4: Display all libraries and their books
        centralLibrary.displayLibrary();
        cityLibrary.displayLibrary();
    }
}
