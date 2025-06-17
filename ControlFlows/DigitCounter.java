import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int count = 0;

        
        if (number == 0) {
            count = 1;
        } else {
         
            number = Math.abs(number);
            while (number != 0) {
                number /= 10;  // Remove last digit
                count++;       // Increase count
            }
        }

       
        System.out.println("Number of digits: " + count);
    }
}
