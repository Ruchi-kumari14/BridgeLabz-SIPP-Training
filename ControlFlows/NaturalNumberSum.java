import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n > 0) {
            int sumWhile = 0;
            int i = 1;

            while (i <= n) {
                sumWhile += i;
                i++;
            }

            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumWhile == sumFormula) {
                System.out.println("Both computations are correct and match.");
            } else {
                System.out.println("Mismatch in results. Please check the logic.");
            }
        } else {
            System.out.println("Invalid input. Enter a natural number (greater than 0).");
        }

        scanner.close();
    }
}
