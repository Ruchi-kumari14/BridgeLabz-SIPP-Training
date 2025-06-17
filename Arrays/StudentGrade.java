import java.util.Scanner;
class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] physics = new int[numStudents];
        int[] chemistry = new int[numStudents];
        int[] maths = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            physics[i] = getValidMarks(scanner, "Physics");
            chemistry[i] = getValidMarks(scanner, "Chemistry");
            maths[i] = getValidMarks(scanner, "Maths");

            int total = physics[i] + chemistry[i] + maths[i];
            percentages[i] = total / 3.0;

            if (percentages[i] >= 90) {
                grades[i] = 'A';
            } else if (percentages[i] >= 80) {
                grades[i] = 'B';
            } else if (percentages[i] >= 70) {
                grades[i] = 'C';
            } else if (percentages[i] >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }

        System.out.println("\n--- Results ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + physics[i] +
                               ", Chemistry: " + chemistry[i] +
                               ", Maths: " + maths[i]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i] + "\n");
        }

        scanner.close();
    }

    private static int getValidMarks(Scanner scanner, String subject) {
        int mark;
        while (true) {
            System.out.print(subject + " marks: ");
            mark = scanner.nextInt();
            if (mark >= 0 && mark <= 100) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a positive number (0-100).");
            }
        }
        return mark;
    }
}
