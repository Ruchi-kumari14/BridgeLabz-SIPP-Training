import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head;
    private Movie tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);

        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }

    // Remove by movie title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Movie current = head;

        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Movie \"" + title + "\" removed.");
    }

    // Search by director
    public void searchByDirector(String director) {
        boolean found = false;
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    // Search by rating
    public void searchByRating(double rating) {
        boolean found = false;
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display all movies forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        Movie temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display all movies in reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        Movie temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Display movie details
    private void displayMovie(Movie movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director +
                ", Year: " + movie.year + ", Rating: " + movie.rating);
    }
}

public class MovieManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        while (true) {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.next();
                    director = sc.next();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    list.addAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.next();
                    director = sc.next();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    list.addAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter Position, Title, Director, Year, Rating: ");
                    pos = sc.nextInt();
                    title = sc.next();
                    director = sc.next();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    list.addAtPosition(pos, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter Title to remove: ");
                    title = sc.next();
                    list.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter Director to search: ");
                    director = sc.next();
                    list.searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Enter Rating to search: ");
                    rating = sc.nextDouble();
                    list.searchByRating(rating);
                    break;

                case 7:
                    System.out.print("Enter Title to update and new Rating: ");
                    title = sc.next();
                    rating = sc.nextDouble();
                    list.updateRating(title, rating);
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                case 10:
                    sc.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
