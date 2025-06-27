import java.util.*;

class Course {
    String name;
    List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("\nStudents enrolled in " + name + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses;

    public Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this); // bidirectional link
    }

    public void displayCourses() {
        System.out.println("\nCourses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

class School {
    String name;
    List<Student> students;

    public School(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);  // aggregation — school has students
    }

    public void displayStudents() {
        System.out.println("\nStudents in " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

public class SchoolAndStudents{
    public static void main(String[] args) {
        // Create school
        School gla = new School("GLA University");

        // Create courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");
        Course history = new Course("History");

        // Create students
        Student ruchi = new Student("Ruchi");
        Student aman = new Student("Aman");

        // Add students to school
        gla.addStudent(ruchi);
        gla.addStudent(aman);

        // Enroll students in courses
        ruchi.enrollInCourse(math);
        ruchi.enrollInCourse(cs);

        aman.enrollInCourse(cs);
        aman.enrollInCourse(history);

        // Display school students
        gla.displayStudents();

        // Display student-course enrollments
        ruchi.displayCourses();
        aman.displayCourses();

        // Display course-student enrollments
        math.displayEnrolledStudents();
        cs.displayEnrolledStudents();
        history.displayEnrolledStudents();
    }
}
