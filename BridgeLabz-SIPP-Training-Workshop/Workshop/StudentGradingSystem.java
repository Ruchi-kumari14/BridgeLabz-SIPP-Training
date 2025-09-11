import java.util.Scanner;

public class StudentGradingSystem {

    // Max number of subjects
    static final int SUBJECT_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] studentNames = new String[studentCount];
        String[] studentIDs = new String[studentCount];
        int[][] grades = new int[studentCount][SUBJECT_COUNT];

        // Input student data
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            studentNames[i] = scanner.nextLine();

            System.out.print("ID: ");
            studentIDs[i] = scanner.nextLine();

            for (int j = 0; j < SUBJECT_COUNT; j++) {
                while (true) {
                    try {
                        System.out.print("Enter grade for Subject " + (j + 1) + ": ");
                        int grade = scanner.nextInt();
                        if (grade < 0 || grade > 100) {
                            throw new IllegalArgumentException("Grade must be between 0 and 100.");
                        }
                        grades[i][j] = grade;
                        break; // valid input
                    } catch (Exception e) {
                        System.out.println("Invalid input. " + e.getMessage());
                        scanner.nextLine(); // clear buffer
                    }
                }
            }
            scanner.nextLine(); // consume newline after grades
        }

        System.out.println("\n--- Student Results ---");

        double totalClassSum = 0;
        int totalClassGrades = 0;

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nStudent: " + studentNames[i] + " (ID: " + studentIDs[i] + ")");

            int total = 0;
            int validGrades = 0;

            for (int j = 0; j < SUBJECT_COUNT; j++) {
                total += grades[i][j];
                validGrades++;
            }

            double average = validGrades > 0 ? (double) total / validGrades : 0;
            totalClassSum += total;
            totalClassGrades += validGrades;

            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + average);
        }

        // Highest grade per subject
        System.out.println("\n--- Highest Grade per Subject ---");
        for (int j = 0; j < SUBJECT_COUNT; j++) {
            int max = -1;
            for (int i = 0; i < studentCount; i++) {
                if (grades[i][j] > max) {
                    max = grades[i][j];
                }
            }
            System.out.println("Subject " + (j + 1) + ": " + max);
        }

        // Class average
        double classAverage = totalClassGrades > 0 ? totalClassSum / totalClassGrades : 0;
        System.out.println("\nOverall Class Average: " + classAverage);

        scanner.close();
    }
}
