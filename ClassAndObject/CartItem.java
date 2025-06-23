import java.util.Scanner;

public class CartItem {
    // Attributes
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public CartItem() {
        this.itemName = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    // Method to add an item to the cart
    public void addItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity += quantity;
        System.out.println(quantity + " " + itemName + "(s) added to the cart.");
    }

    // Method to remove item quantity from cart
    public void removeItem(int qtyToRemove) {
        if (qtyToRemove <= quantity && qtyToRemove > 0) {
            quantity -= qtyToRemove;
            System.out.println(qtyToRemove + " item(s) removed from the cart.");
        } else {
            System.out.println("Invalid quantity to remove!");
        }
    }

    // Method to display total cost
    public void displayTotalCost() {
        double total = price * quantity;
        System.out.println("\n=== Cart Summary ===");
        System.out.println("Item:     " + itemName);
        System.out.println("Price:    " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total:    " + total);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CartItem cart = new CartItem();

        // Add item
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity to add: ");
        int qtyAdd = scanner.nextInt();

        cart.addItem(name, price, qtyAdd);

        // Option to remove items
        System.out.print("Enter quantity to remove: ");
        int qtyRemove = scanner.nextInt();
        cart.removeItem(qtyRemove);

        // Display total cost
        cart.displayTotalCost();

        scanner.close();
    }
}
