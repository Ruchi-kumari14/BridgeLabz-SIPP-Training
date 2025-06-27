import java.util.*;

// Faculty is in aggregation with University — can exist independently
class Faculty {
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Faculty: " + name);
    }
}

// Department is in composition with University — dies with university
class Department {
    String name;

    public Department(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Department: " + name);
    }
}

// University has composition with Department, aggregation with Faculty
class University {
    String name;
    List<Department> departments; // Composition
    List<Faculty> faculties;      // Aggregation

    public University(String name) {
        this.name = name;
        departments = new ArrayList<>();
        faculties = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty); // Aggregation - references external object
    }

    public void displayStructure() {
        System.out.println("\nUniversity: " + name);

        System.out.println("Departments:");
        for (Department d : departments) {
            d.display();
        }

        System.out.println("\nFaculties:");
        for (Faculty f : faculties) {
            f.display();
        }
    }

    public void deleteUniversity() {
        System.out.println("\nDeleting University: " + name + "...");
        departments.clear(); // Composition: Departments destroyed
        faculties.clear();   // Faculties are disassociated (not destroyed in real-world logic)
        System.out.println("All departments deleted. Faculties disassociated.");
    }
}

public class UniversityApp {
    public static void main(String[] args) {
        // Faculties can be created independently (aggregation)
        Faculty drVerma = new Faculty("Dr. Verma");
        Faculty profSharma = new Faculty("Prof. Sharma");

        // Create university
        University gla = new University("GLA University");

        // Add departments (composition)
        gla.addDepartment("Computer Science");
        gla.addDepartment("Electrical Engineering");

        // Add faculties (aggregation)
        gla.addFaculty(drVerma);
        gla.addFaculty(profSharma);

        // Display university structure
        gla.displayStructure();

        // Delete the university (composition destroys departments)
        gla.deleteUniversity();

        // Display structure after deletion
        gla.displayStructure();

        // Faculties still exist (aggregation proof)
        System.out.println("\nFaculty objects still accessible independently:");
        drVerma.display();
        profSharma.display();
    }
}
