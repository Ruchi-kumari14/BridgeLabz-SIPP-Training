import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book prev, next;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;

    // Add book at beginning
    public void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at beginning.");
    }

    // Add book at end
    public void addAtEnd(Book newBook) {
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at end.");
    }

    // Add book at specific position (1-based)
    public void addAtPosition(int position, Book newBook) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addAtBeginning(newBook);
            return;
        }

        Book temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
            System.out.println("Book added at position " + position);
        }
    }

    // Remove book by Book ID
    public void removeById(int bookId) {
        Book current = head;

        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book ID not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Book with ID " + bookId + " removed.");
    }

    // Search book by title or author
    public void search(String keyword) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No book found matching: " + keyword);
    }

    // Update availability status
    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Availability status updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book ID not found.");
    }

    // Display all books (forward)
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\n--- Library (Forward) ---");
        Book temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display all books (reverse)
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\n--- Library (Reverse) ---");
        Book temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    // Display one book
    private void displayBook(Book b) {
        System.out.printf("ID: %d | Title: %s | Author: %s | Genre: %s | Available: %s\n",
                b.bookId, b.title, b.author, b.genre, b.isAvailable ? "Yes" : "No");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book (Beginning)");
            System.out.println("2. Add Book (End)");
            System.out.println("3. Add Book (Position)");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book (Title/Author)");
            System.out.println("6. Update Availability");
            System.out.println("7. Display All (Forward)");
            System.out.println("8. Display All (Reverse)");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int id;
            String title, author, genre;
            boolean available;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    title = sc.nextLine();
                    author = sc.nextLine();
                    genre = sc.nextLine();
                    id = sc.nextInt();
                    available = sc.nextBoolean();
                    library.addAtBeginning(new Book(title, author, genre, id, available));
                    break;

                case 2:
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    title = sc.nextLine();
                    author = sc.nextLine();
                    genre = sc.nextLine();
                    id = sc.nextInt();
                    available = sc.nextBoolean();
                    library.addAtEnd(new Book(title, author, genre, id, available));
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    title = sc.nextLine();
                    author = sc.nextLine();
                    genre = sc.nextLine();
                    id = sc.nextInt();
                    available = sc.nextBoolean();
                    library.addAtPosition(pos, new Book(title, author, genre, id, available));
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextInt();
                    library.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Book Title or Author to search: ");
                    String key = sc.nextLine();
                    library.search(key);
                    break;

                case 6:
                    System.out.print("Enter Book ID and new availability (true/false): ");
                    id = sc.nextInt();
                    available = sc.nextBoolean();
                    library.updateAvailability(id, available);
                    break;

                case 7:
                    library.displayForward();
                    break;

                case 8:
                    library.displayReverse();
                    break;

                case 9:
                    library.countBooks();
                    break;

                case 10:
                    System.out.println("Exiting Library System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
