// Interface for applying discount
interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

// Abstract class representing a food item
abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;
    private double discount;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        setPrice(price);
        setQuantity(quantity);
        this.discount = 0;
    }

    // Encapsulation
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) this.quantity = quantity;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: ₹" + price + ", Qty: " + quantity);
        System.out.println(getDiscountDetails());
    }

    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            this.discount = percent;
        }
    }

    public String getDiscountDetails() {
        return discount > 0 ? "Discount: " + discount + "%" : "No Discount";
    }

    public double getDiscountRate() {
        return discount;
    }

    public abstract double calculateTotalPrice(); // price × qty ± charges
}

// VegItem subclass
class VegItem extends FoodItem {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        double discount = (total * getDiscountRate()) / 100;
        return total - discount;
    }
}

// NonVegItem subclass with extra charge
class NonVegItem extends FoodItem {
    private static final double NONVEG_CHARGE = 30.0;

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        double base = (getPrice() * getQuantity()) + NONVEG_CHARGE;
        double discount = (base * getDiscountRate()) / 100;
        return base - discount;
    }
}

// Main class
public class FoodDeliverySystem {
    public static void main(String[] args) {
        // Polymorphic food item list
        FoodItem[] order = {
            new VegItem("Paneer Butter Masala", 180, 2),
            new NonVegItem("Chicken Biryani", 250, 1),
            new VegItem("Veg Burger", 80, 3),
            new NonVegItem("Mutton Curry", 300, 1)
        };

        // Apply discounts and process order
        for (FoodItem item : order) {
            item.applyDiscount(10); // 10% discount
            item.getItemDetails();
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());
            System.out.println("-----------------------------");
        }
    }
}
