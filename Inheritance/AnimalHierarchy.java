// Superclass
class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " woof woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " meow meow!");
    }
}

// Subclass Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " tweet tweet!");
    }
}

// Main class
public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Bruno", 4);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        dog.makeSound();   // Bruno woof woof!
        cat.makeSound();   // Whiskers meow meow!
        bird.makeSound();  // Tweety tweet tweet!
    }
}


           


