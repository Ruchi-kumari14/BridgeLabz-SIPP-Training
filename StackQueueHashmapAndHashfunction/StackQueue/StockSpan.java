import java.util.Stack;

public class StockSpan {

    // Function to calculate span
    public static int[] calculateSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Pop all smaller or equal prices
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If stack is empty, price[i] is greater than all left elements
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index to stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};

        int[] span = calculateSpan(price);

        System.out.println("Stock prices:");
        for (int p : price) {
            System.out.print(p + " ");
        }

        System.out.println("\nSpan values:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
