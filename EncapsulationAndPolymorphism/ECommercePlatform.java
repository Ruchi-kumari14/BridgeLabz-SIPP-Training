// Interface for Taxable Products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor with encapsulation
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        setPrice(price); // apply validation
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Setter with validation
    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: ₹" + price);
    }
}

// Electronics class - implements Taxable
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    public String getTaxDetails() {
        return "Electronics GST: 18%";
    }
}

// Clothing class - implements Taxable
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    public String getTaxDetails() {
        return "Clothing GST: 5%";
    }
}

// Groceries - non-taxable
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main test class
public class ECommercePlatform {
    public static void main(String[] args) {
        // Creating products using Product reference (Polymorphism)
        Product[] products = {
            new Electronics(101, "Laptop", 60000),
            new Clothing(102, "T-Shirt", 1500),
            new Groceries(103, "Wheat", 1000)
        };

        // Display all product details
        for (Product product : products) {
            product.displayDetails();

            double discount = product.calculateDiscount();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;

            double finalPrice = product.getPrice() + tax - discount;

            // Show tax info if applicable
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }

            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("------------------------------");
        }
    }
}
