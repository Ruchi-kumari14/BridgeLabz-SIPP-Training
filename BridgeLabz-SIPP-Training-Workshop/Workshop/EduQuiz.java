import java.util.Scanner;

public class EduQuiz {

    // Method to calculate score and print feedback
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        System.out.println("\n--- Quiz Feedback ---");

        for (int i = 0; i < correct.length; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            
            // Case-insensitive comparison
            if (correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Correct");
                score++;
            } else {
                System.out.println("Incorrect");
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array of correct answers for 10 questions
        String[] correctAnswers = {
            "A", "C", "B", "D", "A",
            "B", "C", "D", "B", "A"
        };

        // Array to store student answers
        String[] studentAnswers = new String[10];

        System.out.println("Enter your answers for 10 questions (A/B/C/D):");

        // Input student answers
        for (int i = 0; i < 10; i++) {
            System.out.print("Answer for Question " + (i + 1) + ": ");
            studentAnswers[i] = scanner.nextLine();
        }

        // Call the grading method
        int score = calculateScore(correctAnswers, studentAnswers);

        // Display final score
        System.out.println("\nYour Final Score: " + score + "/10");

        scanner.close();
    }
}
