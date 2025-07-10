public class SelectionSortScores {

    // Selection Sort function
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Assume the current index is the minimum
            int minIndex = i;

            // Find the index of the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Utility function to print the array
    public static void printArray(int[] scores) {
        for (int score : scores)
            System.out.print(score + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] examScores = {88, 76, 92, 65, 70, 85};

        System.out.println("Original Exam Scores:");
        printArray(examScores);

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores:");
        printArray(examScores);
    }
}
