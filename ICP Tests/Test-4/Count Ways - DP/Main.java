
import java.util.Scanner;

public class Main {
    public static long countWays(int[] arr) {
        int n = arr.length;
        long total = 0;

        for (int x : arr) {
            total += x;
        }

        if (total % 3 != 0) {
            return 0;
        }

        long target = total / 3;
        long prefixSum = 0;
        long countFirst = 0;
        long ways = 0;

        for (int i = 0; i < n - 1; i++) {
            prefixSum += arr[i];

            if (prefixSum == 2 * target) {
                ways += countFirst;
            }

            if (prefixSum == target) {
                countFirst++;
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // int[] arr = { 1, 2, 3, 0, 3 }; // 2
        System.out.println(countWays(arr));
    }
}
