class Employee {
    // Attributes
    private String name;
    private int id;
    private double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: ₹" + salary);
    }

    // Main method
    public static void main(String[] args) {
        // Creating employee object
        Employee emp1 = new Employee("Ruchi Kumari", 1001, 50000.0);

        // Display employee details
        emp1.displayDetails();
    }
}

