import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the countdown start value: ");
        int counter = scanner.nextInt();

       
        if (counter <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            
            for (int i = counter; i >= 1; i--) {
                System.out.println(i);
            }

        
            System.out.println("LAUNCH");
        }

        scanner.close();
    }
}
