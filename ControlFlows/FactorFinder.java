import java.util.Scanner;
class FactorFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number > 0) {
            System.out.println("Factors of " + number + " (excluding itself):");
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Invalid input. Please enter a positive integer.");
        }

        sc.close();
    }
}
