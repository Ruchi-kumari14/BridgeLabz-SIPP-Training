import java.util.Scanner;

public class TravelSummary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter From City: ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter Via City: ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter To City: ");
        String toCity = scanner.nextLine();

        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double distance1 = scanner.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (in miles): ");
        double distance2 = scanner.nextDouble();

        System.out.print("Enter time from " + fromCity + " to " + viaCity + " (in minutes): ");
        double time1 = scanner.nextDouble();

        System.out.print("Enter time from " + viaCity + " to " + toCity + " (in minutes): ");
        double time2 = scanner.nextDouble();

        double totalDistanceKm = (distance1 + distance2) * 1.60934;
        double totalTime = time1 + time2;

        System.out.println("The Total Distance travelled by " + name + " from " + fromCity +
                           " to " + toCity + " via " + viaCity + " is " + totalDistanceKm +
                           " km and the Total Time taken is " + totalTime + " minutes.");

        scanner.close();
    }
}
