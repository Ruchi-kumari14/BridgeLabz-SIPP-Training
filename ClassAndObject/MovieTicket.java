import java.util.Scanner;

class MovieTicket {
    // Attributes
    private String movieName;
    private int seatNumber;
    private double price;

    // Constructor
    public MovieTicket() {
        this.movieName = "";
        this.seatNumber = -1;
        this.price = 0.0;
    }

    // Method to book a ticket
    public void bookTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    // Method to display ticket details
    public void displayTicket() {
        if (seatNumber == -1) {
            System.out.println("No ticket has been booked yet.");
        } else {
            System.out.println("\n=== Ticket Details ===");
            System.out.println("Movie Name:  " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();

        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();

        System.out.print("Enter ticket price: ");
        double price = scanner.nextDouble();

        // Book and display ticket
        ticket.bookTicket(movieName, seatNumber, price);
        ticket.displayTicket();

        scanner.close();
    }
}
