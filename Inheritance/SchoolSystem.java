// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass: Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
        displayBasicInfo();
        System.out.println("Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
        displayBasicInfo();
        System.out.println("Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
        displayBasicInfo();
        System.out.println("Department: " + department);
    }
}

// Main class
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Riya", 16, 10);
        Staff staff = new Staff("Mrs. Verma", 35, "Administration");

        System.out.println("Teacher Info ");
        teacher.displayRole();

        System.out.println("\n Student Info ");
        student.displayRole();

        System.out.println("\n Staff Info ");
        staff.displayRole();
    }
}
