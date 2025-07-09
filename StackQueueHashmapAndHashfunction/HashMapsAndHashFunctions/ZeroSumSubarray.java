import java.util.*;

public class ZeroSumSubarray {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1); // to handle subarrays starting from index 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, -2};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero sum subarrays (startIndex to endIndex):");
        for (int[] pair : subarrays) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
