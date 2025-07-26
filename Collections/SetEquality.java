import java.util.*;

public class SetEquality {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.print("Enter number of elements in Set1: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter " + n1 + " elements for Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(scanner.nextInt());
        }

        System.out.print("Enter number of elements in Set2: ");
        int n2 = scanner.nextInt();
        System.out.println("Enter " + n2 + " elements for Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(scanner.nextInt());
        }

        // Check equality using equals()
        boolean areEqual = set1.equals(set2);

        System.out.println("Are both sets equal? " + areEqual);

        scanner.close();
    }
}
