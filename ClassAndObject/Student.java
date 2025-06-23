import java.util.Scanner;

class Student {
    // Attributes
    private String name;
    private int rollNumber;
    private double marks;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade
    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    // Method to display student details and grade
    public void displayDetails() {
        System.out.println("\nStudent Report:");
        System.out.println("Name:        " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks:       " + marks);
        System.out.println("Grade:       " + calculateGrade());
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get student details from user
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();

        // Create Student object
        Student student = new Student(name, rollNumber, marks);

        // Display details and grade
        student.displayDetails();

        scanner.close();
    }
}
