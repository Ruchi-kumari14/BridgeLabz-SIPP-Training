import java.util.Scanner;

public class HeightCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        double heightCm = scanner.nextDouble();
        double totalInches = heightCm / 2.54;
        int feet = (int)(totalInches / 12);
        double inches = totalInches % 12;
        System.out.print("Your Height in cm is " + heightCm + 
                         " while in feet is " + feet + 
                         " and inches is " + String.format("%.2f", inches));
        scanner.close();
    }
}
