import java.util.*;

// Class to represent a product and manage the catalog
public class EcommerceProduct {

    // Inner class to represent a product
    static class Product {
        String name;
        String category;
        double price;
        int stock;

        // Constructor
        Product(String name, String category, double price, int stock) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.stock = stock;
        }

        // Display product details
        public String toString() {
            return "Name: " + name + ", Category: " + category + ", Price: ₹" + price + ", Stock: " + stock;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List to store products
        List<Product> products = new ArrayList<>();

        while (true) {
            // Menu options
            System.out.println("\n--- E-commerce Product Catalog ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product by Name or Category");
            System.out.println("3. Update Product Stock");
            System.out.println("4. Show All Products Sorted by Price");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add product
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine(); // consume newline

                    if (stock < 0 || stock > 1000) {
                        System.out.println("Stock must be between 0 and 1000.");
                    } else {
                        Product newProduct = new Product(name, category, price, stock);
                        products.add(newProduct);
                        System.out.println("Product added.");
                    }
                    break;

                case 2:
                    // Search product
                    System.out.print("Enter name or category to search: ");
                    String keyword = sc.nextLine().toLowerCase();
                    boolean found = false;

                    for (Product p : products) {
                        if (p.name.toLowerCase().contains(keyword) || p.category.toLowerCase().contains(keyword)) {
                            System.out.println(p);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println(" No matching product found.");
                    }
                    break;

                case 3:
                    // Update stock
                    System.out.print("Enter product name to update stock: ");
                    String updateName = sc.nextLine();
                    boolean updated = false;

                    for (Product p : products) {
                        if (p.name.equalsIgnoreCase(updateName)) {
                            System.out.print("Enter new stock: ");
                            int newStock = sc.nextInt();
                            sc.nextLine();

                            if (newStock < 0 || newStock > 1000) {
                                System.out.println(" Invalid stock value.");
                            } else {
                                p.stock = newStock;
                                System.out.println(" Stock updated.");
                            }
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    // Sort and display
                    if (products.isEmpty()) {
                        System.out.println(" No products to display.");
                        break;
                    }

                    System.out.print("Sort by price (1: Ascending, 2: Descending): ");
                    int sortChoice = sc.nextInt();
                    sc.nextLine();

                    // Sort based on user choice
                    if (sortChoice == 1) {
                        products.sort(Comparator.comparingDouble(p -> p.price));
                    } else {
                        products.sort((p1, p2) -> Double.compare(p2.price, p1.price));
                    }

                    // Sh2ow sorted products
                    System.out.println("--- Product List ---");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    // Exit program
                    System.out.println("Exiting program.");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
