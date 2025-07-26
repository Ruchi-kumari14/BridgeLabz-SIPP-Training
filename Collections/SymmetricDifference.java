import java.util.*;

public class SymmetricDifference{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Input for Set1
        System.out.print("Enter number of elements in Set1: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter " + n1 + " elements for Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(scanner.nextInt());
        }

        // Input for Set2
        System.out.print("Enter number of elements in Set2: ");
        int n2 = scanner.nextInt();
        System.out.println("Enter " + n2 + " elements for Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(scanner.nextInt());
        }

        // Create union of both sets
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2); // union

        // Create intersection of both sets
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2); // intersection

        // Remove common elements from union to get symmetric difference
        symmetricDiff.removeAll(common);

        // Display result
        System.out.println("Symmetric Difference: " + symmetricDiff);

        scanner.close();
    }
}
