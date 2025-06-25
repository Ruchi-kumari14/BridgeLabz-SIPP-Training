class Book {
    // Static variable shared across all book objects
    static String libraryName = "Maitree Public Library";

    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final variable: cannot be changed once assigned

    // Constructor using 'this' to resolve ambiguity
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Book b1 = new Book("The Alchemist", "Paulo Coelho", "9780061122415");
        Book b2 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", "9788173711466");

        // Static method call
        Book.displayLibraryName();

        // instanceof check before displaying details
        if (b1 instanceof Book) {
            System.out.println("\nBook 1 Details:");
            b1.displayDetails();
        }

        if (b2 instanceof Book) {
            System.out.println("\nBook 2 Details:");
            b2.displayDetails();
        }
    }
}
