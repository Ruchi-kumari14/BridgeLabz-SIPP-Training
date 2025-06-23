import java.util.Scanner;

class MobilePhone {
    // Attributes
    private String brand;
    private String model;
    private double price;

    // Constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display phone details
    public void displayDetails() {
        System.out.println("\nMobile Phone Details:");
        System.out.println("Brand:  " + brand);
        System.out.println("Model:  " + model);
        System.out.println("Price:  " + price);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get phone details from user
        System.out.print("Enter brand name: ");
        String brand = scanner.nextLine();

        System.out.print("Enter model name: ");
        String model = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        // Create MobilePhone object
        MobilePhone phone = new MobilePhone(brand, model, price);

        // Display phone details
        phone.displayDetails();

        scanner.close();
    }
}
