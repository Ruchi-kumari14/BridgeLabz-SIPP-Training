public class LibraryBooks {
    public String ISBN;
    protected String title;
    private String author;

    public LibraryBooks(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        LibraryBooks book = new LibraryBooks("978-0134685991", "Effective Java", "Joshua Bloch");
        System.out.println("ISBN (public): " + book.ISBN);
        System.out.println("Title (protected): " + book.title);
        System.out.println("Author (via getter): " + book.getAuthor());

        book.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + book.getAuthor());
    }
}
