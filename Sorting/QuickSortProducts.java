public class QuickSortProducts {

    // Quick Sort main function
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort left and right of pivot
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition function
    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];  // Using last element as pivot
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot with element at i+1
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;  // Return pivot index
    }

    // Utility function to print the array
    public static void printArray(int[] prices) {
        for (int price : prices)
            System.out.print(price + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] productPrices = {799, 150, 550, 300, 450, 200};

        System.out.println("Original Product Prices:");
        printArray(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices:");
        printArray(productPrices);
    }
}
