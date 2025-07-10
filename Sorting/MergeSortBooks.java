public class MergeSortBooks {

    // Main function to sort the array using merge sort
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the left half
            mergeSort(prices, left, mid);

            // Recursively sort the right half
            mergeSort(prices, mid + 1, right);

            // Merge the two sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Function to merge two sorted subarrays
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;  // Size of left subarray
        int n2 = right - mid;     // Size of right subarray

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge the temporary arrays back into prices[]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }

    // Utility function to print the array
    public static void printArray(int[] prices) {
        for (int price : prices)
            System.out.print(price + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] bookPrices = {450, 200, 799, 150, 550, 300};

        System.out.println("Original Book Prices:");
        printArray(bookPrices);

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Book Prices:");
        printArray(bookPrices);
    }
}
