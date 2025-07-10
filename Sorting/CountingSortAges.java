public class CountingSortAges {

    // Counting Sort function
    public static void countingSort(int[] ages) {
        int min = 10;  // minimum age
        int max = 18;  // maximum age
        int range = max - min + 1;

        // Step 1: Create count array and initialize with 0
        int[] count = new int[range];

        // Step 2: Count frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Step 3: Compute cumulative count (optional for stable sort)
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Build the output array
        int[] output = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        // Step 5: Copy the sorted result back to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    // Utility function to print array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 13, 17, 11, 10, 16};

        System.out.println("Original Student Ages:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("Sorted Student Ages:");
        printArray(studentAges);
    }
}
