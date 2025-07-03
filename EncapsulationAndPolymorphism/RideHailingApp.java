// Interface for GPS tracking
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class Vehicle
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Encapsulated getters
    public String getVehicleId() { return vehicleId; }
    public String getMaskedDriverName() {
        return driverName.charAt(0) + "***";
    }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + getMaskedDriverName());
        System.out.println("Rate/Km: ₹" + ratePerKm);
        System.out.println("Location: " + currentLocation);
    }

    // GPS interface methods
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        if (newLocation != null && !newLocation.isEmpty()) {
            currentLocation = newLocation;
        }
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}

// Subclass: Car
class Car extends Vehicle {
    private static final double BASE_CHARGE = 50;

    public Car(String id, String driver, double rate, String location) {
        super(id, driver, rate, location);
    }

    public double calculateFare(double distance) {
        return BASE_CHARGE + (getRatePerKm() * distance);
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    public Bike(String id, String driver, double rate, String location) {
        super(id, driver, rate, location);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

// Subclass: Auto
class Auto extends Vehicle {
    private static final double MINIMUM_FARE = 30;

    public Auto(String id, String driver, double rate, String location) {
        super(id, driver, rate, location);
    }

    public double calculateFare(double distance) {
        double fare = getRatePerKm() * distance;
        return Math.max(fare, MINIMUM_FARE);
    }
}

// Test class
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle[] rides = {
            new Car("CAR101", "Amit", 15, "Station"),
            new Bike("BIK202", "Sneha", 8, "Mall"),
            new Auto("AUT303", "Ravi", 10, "Market")
        };

        double travelDistance = 10.0; // in kilometers

        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + travelDistance + " km: ₹" + ride.calculateFare(travelDistance));
            ride.updateLocation("City Center");
            System.out.println("Updated Location: " + ride.getCurrentLocation());
            System.out.println("----------------------------");
        }
    }
}
