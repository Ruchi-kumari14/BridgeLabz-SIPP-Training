import java.util.*;

public class SubsetChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Input for Set1 (possible subset)
        System.out.print("Enter number of elements in Set1: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter " + n1 + " elements for Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(scanner.nextInt());
        }

        // Input for Set2 (possible superset)
        System.out.print("Enter number of elements in Set2: ");
        int n2 = scanner.nextInt();
        System.out.println("Enter " + n2 + " elements for Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(scanner.nextInt());
        }

        // Check if set1 is subset of set2
        boolean isSubset = set2.containsAll(set1);

        // Output
        System.out.println("Is Set1 a subset of Set2? " + isSubset);

        scanner.close();
    }
}
