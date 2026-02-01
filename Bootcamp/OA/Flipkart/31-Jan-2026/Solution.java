import java.util.*;

class Solution {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : arr1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int[] result = new int[arr1.length];
        int idx = 0;

        for (int x : arr2) {
            int count = freq.get(x);
            while (count-- > 0) {
                result[idx++] = x;
            }
            freq.remove(x);
        }

        List<Integer> remaining = new ArrayList<>();
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            while (count-- > 0) {
                remaining.add(key);
            }
        }

        Collections.sort(remaining);
        for (int x : remaining) {
            result[idx++] = x;
        }

        return result;
    }
}
