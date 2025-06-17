import java.util.Scanner;

public class LargestTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = Math.abs(sc.nextLong());

        int[] digits = new int[20];
        int index = 0;

        while (num != 0) {
            digits[index++] = (int)(num % 10);
            num /= 10;
        }

        int max = -1, secondMax = -1;
        for (int i = 0; i < index; i++) {
            int d = digits[i];
            if (d > max) {
                secondMax = max;
                max = d;
            } else if (d > secondMax && d != max) {
                secondMax = d;
            }
        }

        System.out.print("Digits: ");
        for (int i = 0; i < index; i++) System.out.print(digits[i] + " ");
        System.out.println("\nLargest: " + max);
        System.out.println("Second Largest: " + (secondMax != -1 ? secondMax : "Not found"));
        sc.close();
    }
}
