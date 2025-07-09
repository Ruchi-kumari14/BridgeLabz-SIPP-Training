import java.util.Stack;

public class SortStackRecursively {

    // Main method to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();          // Step 1: Pop the top
            sortStack(stack);              // Step 2: Sort the remaining stack
            insertInSortedOrder(stack, top); // Step 3: Insert the popped element in sorted order
        }
    }

    // Helper method to insert element in sorted order
    public static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base condition: if stack is empty or top of stack is less than the element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertInSortedOrder(stack, element); // Recur until correct position is found
            stack.push(top);                     // Push everything back
        }
    }

    // Display stack from top to bottom
    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}
