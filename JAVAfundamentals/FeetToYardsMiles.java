import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = scanner.nextDouble();

        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;

        System.out.print("The distance in yards is " + distanceInYards + 
                         " while the distance in miles is " + distanceInMiles);

        scanner.close();
    }
}
