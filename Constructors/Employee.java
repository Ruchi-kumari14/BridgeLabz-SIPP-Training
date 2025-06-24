// Base class
class BaseEmployee {
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    public BaseEmployee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to set salary
    public void setSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        }
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }
}

// Subclass + main class (must match file name)
public class Employee extends BaseEmployee {

    public Employee(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Display method
    public void displayManagerInfo() {
        System.out.println("Employee ID (public): " + employeeID);
        System.out.println("Department (protected): " + department);
        System.out.println("Salary (private via getter): ₹" + getSalary());
    }

    public static void main(String[] args) {
        Employee manager = new Employee(101, "IT", 90000.0);

        manager.displayManagerInfo();

        manager.setSalary(100000.0);
        System.out.println("Updated Salary: ₹" + manager.getSalary());
    }
}
