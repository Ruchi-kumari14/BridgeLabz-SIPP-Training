import java.util.*;

public class SetToSortedList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a HashSet of Integers
        Set<Integer> numberSet = new HashSet<>();

        // Input from user
        System.out.print("Enter number of elements in the Set: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            numberSet.add(scanner.nextInt());
        }

        // Convert Set to List
        List<Integer> sortedList = new ArrayList<>(numberSet);

        // Sort the List
        Collections.sort(sortedList);

        // Output the sorted list
        System.out.println("Sorted List: " + sortedList);

        scanner.close();
    }
}
