import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Add at beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at end
    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int roll, String name, int age, char grade) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        Student newStudent = new Student(roll, name, age, grade);

        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by roll number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student with roll number " + roll + " not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Search by roll number
    public void searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Found: Roll: " + temp.rollNumber + ", Name: " + temp.name +
                        ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade
    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            int roll, age, position;
            String name;
            char grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next().charAt(0);
                    list.addAtBeginning(roll, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next().charAt(0);
                    list.addAtEnd(roll, name, age, grade);
                    break;

                case 3:
                    System.out.print("Enter Position, Roll, Name, Age, Grade: ");
                    position = sc.nextInt();
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next().charAt(0);
                    list.addAtPosition(position, roll, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter Roll to delete: ");
                    roll = sc.nextInt();
                    list.deleteByRollNumber(roll);
                    break;

                case 5:
                    System.out.print("Enter Roll to search: ");
                    roll = sc.nextInt();
                    list.searchByRollNumber(roll);
                    break;

                case 6:
                    System.out.print("Enter Roll to update and new Grade: ");
                    roll = sc.nextInt();
                    grade = sc.next().charAt(0);
                    list.updateGrade(roll, grade);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    sc.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
