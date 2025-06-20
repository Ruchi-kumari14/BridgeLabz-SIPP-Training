import java.util.Scanner;
class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temp = scanner.nextDouble();

        System.out.print("Convert to (C)elsius or (F)ahrenheit? ");
        char choice = scanner.next().toUpperCase().charAt(0);

        if (choice == 'C') {
            double celsius = fahrenheitToCelsius(temp);
            System.out.println(temp + " Fahrenheit is " + celsius + " Celsius.");
        } else if (choice == 'F') {
            double fahrenheit = celsiusToFahrenheit(temp);
            System.out.println(temp + " Celsius is " + fahrenheit + " Fahrenheit.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
