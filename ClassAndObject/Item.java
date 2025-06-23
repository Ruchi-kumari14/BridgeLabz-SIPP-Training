import java.util.Scanner;

class Item {
    // Attributes
    private int itemCode;
    private String itemName;
    private double price;

    // Constructor
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayDetails() {
        System.out.println("\nItem Details:");
        System.out.println("Item Code:  " + itemCode);
        System.out.println("Item Name:  " + itemName);
        System.out.println("Unit Price: ₹" + price);
    }

    // Method to calculate total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get item details from user
        System.out.print("Enter item code: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        // Create Item object
        Item item = new Item(code, name, price);

        // Get quantity from user
        System.out.print("Enter quantity to purchase: ");
        int quantity = scanner.nextInt();

        // Display item details
        item.displayDetails();

        // Display total cost
        double totalCost = item.calculateTotalCost(quantity);
        System.out.println("Total Cost for " + quantity + " items: " + totalCost);

        scanner.close();
    }
}
