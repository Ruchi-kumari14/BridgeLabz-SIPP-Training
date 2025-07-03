// Insurable interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    // Constructor with encapsulation
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Getters
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    // Restricted access to insurance policy number
    protected String getInsurancePolicyNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    // Display vehicle details
    public void displayInfo() {
        System.out.println("Vehicle No: " + vehicleNumber + ", Type: " + type + ", Rate/Day: ₹" + rentalRate);
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle {
    public Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // includes additional car service fee
    }

    public double calculateInsurance() {
        return 2500; // flat car insurance
    }

    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + getInsurancePolicyNumber();
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 800; // bike insurance
    }

    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + getInsurancePolicyNumber();
    }
}

// Truck class
class Truck extends Vehicle {
    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 2000; // includes cargo surcharge
    }

    public double calculateInsurance() {
        return 4000; // higher insurance
    }

    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + getInsurancePolicyNumber();
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create vehicles
        Vehicle[] vehicles = {
            new Car("MH12AB1234", 1500, "CAR2024POL001"),
            new Bike("MH31XY5678", 500, "BIK2024POL123"),
            new Truck("MH14TR0001", 3000, "TRK2024POL999")
        };

        int rentalDays = 5;

        // Display and process each vehicle
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println(v.getInsuranceDetails());
            System.out.println("Insurance Cost: ₹" + v.calculateInsurance());
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + v.calculateRentalCost(rentalDays));
            System.out.println("------------------------------");
        }
    }
}
