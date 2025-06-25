class Product {
    // Static variable shared among all products
    static double discount = 10.0; // percentage discount (e.g., 10%)
    
    // Instance variables
    private String productName;
    private double price;
    private int quantity;
    private final int productID; // Final variable: unique and unchangeable

    // Constructor using 'this' to initialize instance variables
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount for all products
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to display product details
    public void displayDetails() {
        System.out.println("Product ID   : " + productID);
        System.out.println("Name         : " + productName);
        System.out.println("Price        : ₹" + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Discount     : " + discount + "%");
        double discountedPrice = price - (price * discount / 100);
        System.out.println("Final Price  : ₹" + discountedPrice);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Product p1 = new Product(101, "Wireless Mouse", 799.00, 2);
        Product p2 = new Product(102, "Mechanical Keyboard", 2499.00, 1);

        // Update discount using static method
        Product.updateDiscount(15.0); // Set discount to 15%

        // instanceof check before processing details
        if (p1 instanceof Product) {
            System.out.println("\nProduct 1 Details:");
            p1.displayDetails();
        }

        if (p2 instanceof Product) {
            System.out.println("\nProduct 2 Details:");
            p2.displayDetails();
        }
    }
}
