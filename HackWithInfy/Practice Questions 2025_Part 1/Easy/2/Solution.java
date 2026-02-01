
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = max_good_subarray(n, arr, k);
        System.out.println(ans);
    }

    private static long max_good_subarray(int n, int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        long sum = 0;
        long maxSum = 0;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > k) {
                int count = map.get(arr[l]) - 1;
                if (count == 0)
                    map.remove(arr[l]);
                else
                    map.put(arr[l], count);
                sum -= arr[l];
                l++;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}