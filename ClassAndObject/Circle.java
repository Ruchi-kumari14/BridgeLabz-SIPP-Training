import java.util.Scanner;

class Circle {
    // Attribute
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display results
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for radius
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        // Create Circle object
        Circle circle = new Circle(radius);

        // Display area and circumference
        circle.displayDetails();

        scanner.close();
    }
}
