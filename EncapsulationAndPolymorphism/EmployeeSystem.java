// Interface for Department functionalities
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract class representing a generic employee
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor using encapsulation
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getter methods
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    // Setter method with validation
    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0)
            this.baseSalary = baseSalary;
    }

    // Concrete method to display employee details
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
    }

    // Interface method implementations
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();
}

// Full-time employee subclass
class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(int id, String name, double baseSalary, double allowance) {
        super(id, name, baseSalary);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + allowance;
    }
}

// Part-time employee subclass
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(id, name, baseSalary); // baseSalary will be 0 here, calculated from hours
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Test class to demonstrate polymorphism and encapsulation
public class EmployeeSystem {
    public static void main(String[] args) {
        // Create employees using Employee reference (Polymorphism)
        Employee emp1 = new FullTimeEmployee(101, "Alice", 30000, 5000);
        Employee emp2 = new PartTimeEmployee(102, "Bob", 0, 20, 500);

        emp1.assignDepartment("Human Resources");
        emp2.assignDepartment("IT Support");

        // Polymorphic behavior: loop through employee list
        Employee[] employees = { emp1, emp2 };

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: ₹" + emp.calculateSalary());
            System.out.println("---------------------------");
        }
    }
}
