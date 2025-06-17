import java.util.Scanner;

public class DivisibilityBy5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();


        if (number % 5 == 0) {
            System.out.println("the number is divisible by 5");
        } else {
            System.out.println("the number is not divisible by 5");
        }

        scanner.close();
    }
}
