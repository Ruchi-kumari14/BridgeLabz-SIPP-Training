class Student {
    // Static variable shared by all students
    static String universityName = "GLA University";
    static int totalStudents = 0;

    // Instance variables
    private String name;
    private final int rollNumber; // Final variable: can't be changed
    private String grade;

    // Constructor using 'this' to resolve ambiguity
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Increment total students on each object creation
    }

    // Static method to show total students enrolled
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to update grade
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("University   : " + universityName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Name         : " + name);
        System.out.println("Grade        : " + grade);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Student s1 = new Student("Ruchi Kumari", 101, "A");
        Student s2 = new Student("Amit Verma", 102, "B");

        // instanceof check before displaying/updating details
        if (s1 instanceof Student) {
            System.out.println("\nStudent 1 Details:");
            s1.displayDetails();
            s1.updateGrade("A+"); // updating grade
            System.out.println("Updated Grade:");
            s1.displayDetails();
        }

        if (s2 instanceof Student) {
            System.out.println("\nStudent 2 Details:");
            s2.displayDetails();
        }

        // Display total students
        System.out.println();
        Student.displayTotalStudents();
    }
}
