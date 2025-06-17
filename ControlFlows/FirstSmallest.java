import java.util.Scanner;

public class FirstSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int number3 = scanner.nextInt();

        if (number1 < number2 && number1 < number3) {
            System.out.println("first number is the smallest of all three");
        } else {
            System.out.println("the first is not the smallest");
        }

        scanner.close();
    }
}
