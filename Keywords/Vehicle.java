class Vehicle {
    // Static variable: common registration fee for all vehicles
    static double registrationFee = 5000.0;

    // Instance variables
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber; // Final: unique and unchangeable

    // Constructor using 'this' keyword
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Owner Name         : " + ownerName);
        System.out.println("Vehicle Type       : " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee   : ₹" + registrationFee);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Ruchi Kumari", "Scooter", "UP85-1234");
        Vehicle v2 = new Vehicle("Amit Verma", "Car", "UP85-5678");

        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(6000.0);

        // instanceof checks before displaying details
        if (v1 instanceof Vehicle) {
            System.out.println("\nVehicle 1 Details:");
            v1.displayDetails();
        }

        if (v2 instanceof Vehicle) {
            System.out.println("\nVehicle 2 Details:");
            v2.displayDetails();
        }
    }
}
