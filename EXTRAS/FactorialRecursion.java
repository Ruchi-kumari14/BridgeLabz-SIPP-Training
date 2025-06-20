import java.util.Scanner;

public class FactorialRecursion {

    public static void main(String[] args) {
        int number = getInput("Enter a non-negative integer to calculate factorial: ");
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(number);
            displayResult(number, result);
        }
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void displayResult(int number, long factorial) {
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
