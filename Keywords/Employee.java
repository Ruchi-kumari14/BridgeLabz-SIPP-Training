class Employee {
    // Static variable shared across all employees
    static String companyName = "Maitree Group";
    static int totalEmployees = 0;

    // Instance variables
    private String name;
    private String designation;
    private final int id; // Final: cannot be changed once assigned

    // Constructor using 'this' to initialize values
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++; // Count each new employee
    }

    // Static method to display total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Instance method to display employee details
    public void displayDetails() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Employee ID: " + id);
        System.out.println("Name       : " + name);
        System.out.println("Designation: " + designation);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Employee e1 = new Employee("Ruchi Kumari", 101, "Software Engineer");
        Employee e2 = new Employee("Amit Verma", 102, "Data Analyst");

        // instanceof check before displaying details
        if (e1 instanceof Employee) {
            System.out.println("\nEmployee 1 Details:");
            e1.displayDetails();
        }

        if (e2 instanceof Employee) {
            System.out.println("\nEmployee 2 Details:");
            e2.displayDetails();
        }

        // Display total number of employees using static method
        System.out.println();
        Employee.displayTotalEmployees();
    }
}
