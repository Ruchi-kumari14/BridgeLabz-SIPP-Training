import java.util.*;

// Professor class
class Professor {
    String name;
    List<Course> coursesTaught;

    public Professor(String name) {
        this.name = name;
        coursesTaught = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!coursesTaught.contains(course)) {
            coursesTaught.add(course);
            course.assignProfessor(this);
        }
    }

    public void displayCourses() {
        System.out.println("\nCourses taught by Professor " + name + ":");
        for (Course c : coursesTaught) {
            System.out.println("- " + c.courseName);
        }
    }
}

// Student class
class Student {
    String name;
    List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " has enrolled in " + course.courseName);
        }
    }

    public void displayEnrolledCourses() {
        System.out.println("\nCourses enrolled by " + name + ":");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.courseName + " (Professor: " + (c.professor != null ? c.professor.name : "Not Assigned") + ")");
        }
    }
}

// Course class
class Course {
    String courseName;
    Professor professor;
    List<Student> enrolledStudents;

    public Course(String name) {
        this.courseName = name;
        enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor prof) {
        this.professor = prof;
    }

    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void displayCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.name : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

// Main Application
public class UniversityManagement {
    public static void main(String[] args) {
        // Create Professors
        Professor prof1 = new Professor("Dr. Sharma");
        Professor prof2 = new Professor("Dr. Gupta");

        // Create Courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");

        // Assign Professors to Courses
        prof1.assignCourse(math);
        prof2.assignCourse(cs);

        // Create Students
        Student ruchi = new Student("Ruchi");
        Student arjun = new Student("Arjun");

        // Students enroll in courses
        ruchi.enrollCourse(math);
        ruchi.enrollCourse(cs);
        arjun.enrollCourse(cs);

        // Display data
        prof1.displayCourses();
        prof2.displayCourses();

        ruchi.displayEnrolledCourses();
        arjun.displayEnrolledCourses();

        math.displayCourseDetails();
        cs.displayCourseDetails();
    }
}
