import java.util.Scanner;

public class FibonacciGenerator {

    public static void main(String[] args) {
        int terms = getInput("Enter the number of Fibonacci terms to generate: ");
        generateFibonacci(terms);
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        long first = 0;
        long second = 1;

        System.out.print("Fibonacci sequence: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + (i < n ? ", " : "\n"));
            long next = first + second;
            first = second;
            second = next;
        }
    }
}
