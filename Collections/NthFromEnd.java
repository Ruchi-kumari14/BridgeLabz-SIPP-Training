import java.util.*;

public class NthFromEnd {

    // Method to find the Nth element from the end using List interface
    public static <T> T findNthFromEnd(List<T> list, int N) {
        int first = 0;
        int second = 0;

        // Advance second pointer N steps
        while (second < N) {
            if (second >= list.size()) {
                throw new IllegalArgumentException("N is greater than the number of elements.");
            }
            second++;
        }

        // Move both pointers until second reaches the end
        while (second < list.size()) {
            first++;
            second++;
        }

        return list.get(first);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> linkedList = new LinkedList<>(); // Using List interface with LinkedList implementation

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            linkedList.add(scanner.nextLine());
        }

        System.out.print("Enter value of N (Nth element from end): ");
        int N = scanner.nextInt();

        try {
            String result = findNthFromEnd(linkedList, N);
            System.out.println("The " + N + "th element from the end is: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
