// Base Class
class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed";
    }

    void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass - ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped with Tracking No: " + trackingNumber;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass - DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order delivered on: " + deliveryDate;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class to run the program
public class OrderManagementSystem {
    public static void main(String[] args) {
        Order order = new Order("ORD001", "2025-07-01");
        ShippedOrder shipped = new ShippedOrder("ORD002", "2025-07-01", "TRK123456");
        DeliveredOrder delivered = new DeliveredOrder("ORD003", "2025-06-28", "TRK987654", "2025-07-01");

        System.out.println(" Order Info");
        order.displayDetails();

        System.out.println("\nShipped Order Info");
        shipped.displayDetails();

        System.out.println("\n Delivered Order Info");
        delivered.displayDetails();
    }
}
