class Vehicle{
   int maxSpeed;
   String fuelType;
   
   Vehicle(int maxSpeed,String fuelType){
       this.maxSpeed=maxSpeed;
       this.fuelType=fuelType;
   }

   void displayInfo(){
    System.out.println("Max Speed: " + maxSpeed + "km/h, Fuel Type: " + fuelType);
   }
}

class Car extends Vehicle{
    int seatCapacity;
 
    Car(int maxSpeed,String fuelType,int seatCapacity){
       super(maxSpeed,fuelType);
       this.seatCapacity=seatCapacity;
    }
    @Override
    void displayInfo(){
       super.displayInfo();
       System.out.println("Vehicle Type:Car, Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
   int loadCapacity;
   
   Truck(int maxSpeed,String fuelType,int loadCapacity){
      super(maxSpeed,fuelType);
      this.loadCapacity=loadCapacity;
   }
   @Override
   void displayInfo(){
      super.displayInfo();
      System.out.println("vehicle Type:Truck, Load capacity: "+ loadCapacity + "kg");
   }
}

class Motorcycle extends Vehicle {
    boolean hasStorage;

    Motorcycle(int maxSpeed, String fuelType, boolean hasStorage) {
        super(maxSpeed, fuelType);
        this.hasStorage = hasStorage;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Motorcycle, Has Storage: " + (hasStorage ? "Yes" : "No"));
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10000);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println(); 
        }
    }
}


   