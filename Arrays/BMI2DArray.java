import java.util.Scanner;

public class BMI2DArray{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();

        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            double weight, height;

            while (true) {
                System.out.print("Enter weight (kg): ");
                weight = scanner.nextDouble();
                if (weight > 0) break;
                System.out.println("Weight must be positive.");
            }

            while (true) {
                System.out.print("Enter height (m): ");
                height = scanner.nextDouble();
                if (height > 0) break;
                System.out.println("Height must be positive.");
            }

            double bmi = weight / (height * height);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d: Weight = %.2f kg, Height = %.2f m, BMI = %.2f, Status = %s\n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }
}
