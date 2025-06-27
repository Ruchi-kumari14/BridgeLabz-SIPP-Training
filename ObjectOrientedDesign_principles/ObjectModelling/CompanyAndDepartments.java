import java.util.*;

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        Employee e = new Employee(employeeName);
        employees.add(e);
    }

    public void display() {
        System.out.println("\nDepartment: " + name);
        for (Employee e : employees) {
            e.display();
        }
    }
}

class Company {
    String name;
    List<Department> departments;

    public Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
    }

    public Department getDepartment(String deptName) {
        for (Department d : departments) {
            if (d.name.equals(deptName)) {
                return d;
            }
        }
        return null;
    }

    public void displayCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.display();
        }
    }

    public void deleteCompany() {
        System.out.println("\nDeleting company " + name + "...");
        departments.clear(); // removes all departments and their employees
        System.out.println("All departments and employees deleted.");
    }
}

class CompanyAndDepartments {
    public static void main(String[] args) {
        Company tcs = new Company("TCS");

        tcs.addDepartment("HR");
        tcs.addDepartment("Development");

        Department hr = tcs.getDepartment("HR");
        Department dev = tcs.getDepartment("Development");

        hr.addEmployee("Alice");
        hr.addEmployee("Bob");

        dev.addEmployee("Charlie");
        dev.addEmployee("David");

        tcs.displayCompanyStructure();

        // Delete company (composition - everything goes)
        tcs.deleteCompany();

        tcs.displayCompanyStructure(); // should show empty structure
    }
}
