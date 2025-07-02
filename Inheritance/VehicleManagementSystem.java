// Interface
interface Refuelable {
    void refuel();
}

// Superclass
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Subclass: ElectricVehicle
class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging vehicle...");
    }
}

// Subclass: PetrolVehicle implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public void refuel() {
        displayInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
        System.out.println("Refueling petrol vehicle...");
    }
}

// Main class
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(180, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(160, "Maruti Swift", 40);

        ev.charge();
        System.out.println(); // space between outputs
        pv.refuel();
    }
}
