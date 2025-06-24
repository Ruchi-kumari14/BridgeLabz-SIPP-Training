public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double ratePerDay = 1000.0; // fixed rate

    // Default constructor
    public CarRental() {
        this.customerName = "Customer";
        this.carModel = "Unknown";
        this.rentalDays = 1;
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * ratePerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel +
                ", Days: " + rentalDays + ", Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental cr1 = new CarRental();
        CarRental cr2 = new CarRental("Priya", "Hyundai i20", 5);
        cr1.display();
        cr2.display();
    }
}
