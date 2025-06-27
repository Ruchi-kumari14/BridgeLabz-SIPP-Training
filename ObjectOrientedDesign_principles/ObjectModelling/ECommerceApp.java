import java.util.*;

// Product class
class Product {
    int productId;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.productId = id;
        this.name = name;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: ₹" + price);
    }
}

// Order class aggregates Products
class Order {
    int orderId;
    List<Product> productList;
    Customer customer;

    public Order(int id, Customer customer) {
        this.orderId = id;
        this.customer = customer;
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void displayOrderDetails() {
        System.out.println("\nOrder ID: " + orderId + ", Placed by: " + customer.name);
        System.out.println("Products in this order:");
        for (Product p : productList) {
            p.displayProduct();
        }
    }
}

// Customer class communicates through Order
class Customer {
    String name;
    List<Order> orderHistory;

    public Customer(String name) {
        this.name = name;
        orderHistory = new ArrayList<>();
    }

    // Communication method
    public Order placeOrder(int orderId) {
        Order order = new Order(orderId, this);
        orderHistory.add(order);
        System.out.println(name + " placed a new order (Order ID: " + orderId + ")");
        return order;
    }

    public void displayOrderHistory() {
        System.out.println("\nOrder history for customer: " + name);
        for (Order o : orderHistory) {
            o.displayOrderDetails();
        }
    }
}

// Main class
public class ECommerceApp {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product(101, "Laptop", 55000);
        Product p2 = new Product(102, "Mouse", 500);
        Product p3 = new Product(103, "Keyboard", 1000);

        // Create customer
        Customer ruchi = new Customer("Ruchi");

        // Customer places an order
        Order order1 = ruchi.placeOrder(1);
        order1.addProduct(p1);
        order1.addProduct(p2);

        // Another order
        Order order2 = ruchi.placeOrder(2);
        order2.addProduct(p3);

        // Display full order history
        ruchi.displayOrderHistory();
    }
}
