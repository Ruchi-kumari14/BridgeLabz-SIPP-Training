import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add a new ticket at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newTicket;
            tail.next = head; // circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }

        System.out.println("Ticket booked successfully.");
    }

    // Remove a ticket by ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == head && current == tail) { // only one node
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket removed successfully.");
                return;
            }

            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
        }
    }

    // Display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.println("Ticket ID: " + current.ticketId);
            System.out.println("Customer: " + current.customerName);
            System.out.println("Movie: " + current.movieName);
            System.out.println("Seat: " + current.seatNumber);
            System.out.println("Booking Time: " + current.bookingTime);
            System.out.println("------------------------");
            current = current.next;
        } while (current != head);
    }

    // Search by customer name or movie name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        System.out.println("\n--- Search Results ---");
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + current.ticketId);
                System.out.println("Customer: " + current.customerName);
                System.out.println("Movie: " + current.movieName);
                System.out.println("Seat: " + current.seatNumber);
                System.out.println("Booking Time: " + current.bookingTime);
                System.out.println("------------------------");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No ticket found for keyword: " + keyword);
        }
    }

    // Count total tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total Booked Tickets: 0");
            return;
        }

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        System.out.println("Total Booked Tickets: " + count);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketSystem system = new TicketSystem();

        while (true) {
            System.out.println("\n--- Online Ticket Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int removeId = sc.nextInt();
                    system.removeTicket(removeId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 6:
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
