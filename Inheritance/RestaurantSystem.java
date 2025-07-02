// Interface
interface Worker {
    void performDuties();
}

// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Subclass: Chef
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Prepares meals and manages kitchen.");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {
    String shift;

    Waiter(String name, int id, String shift) {
        super(name, id);
        this.shift = shift;
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Role: Waiter");
        System.out.println("Shift: " + shift);
        System.out.println("Duties: Serves customers and manages tables.");
    }
}

// Main class
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Raj", 101, "Indian Cuisine");
        Waiter waiter = new Waiter("Amit", 102, "Evening");

        chef.performDuties();
        waiter.performDuties();
    }
}
