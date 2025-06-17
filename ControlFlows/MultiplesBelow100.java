import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input. Please enter a number > 0 and < 100.");
        } else {
            int counter = number - 1;
            System.out.println("Multiples of " + number + " below 100:");
            while (counter > 1) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        }

        sc.close();
    }
}
