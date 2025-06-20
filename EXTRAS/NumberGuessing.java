import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean correct = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it. Respond with: 'high', 'low', or 'correct'.");

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "?");

            String feedback = getUserFeedback(scanner);

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! I guessed your number!");
                correct = true;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else {
                System.out.println("  type 'high', 'low', or 'correct'.");
            }
        }

        if (!correct) {
            System.out.println(" Something went wrong");
        }
    }

    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static String getUserFeedback(Scanner scanner) {
        System.out.print("Your response (high / low / correct): ");
        return scanner.nextLine();
    }
}
