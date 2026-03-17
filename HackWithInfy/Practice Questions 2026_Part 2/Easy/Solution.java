
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // BruteForce();
        Optimised();
    }

    public static void Optimised() {
        long MOD = 1_000_000_007;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long arr[] = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        int queries = sc.nextInt();

        long[] diffA = new long[n + 1]; // x-l*y
        long[] diffB = new long[n + 1]; // y later i*y

        while (queries-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long val = (x - (long) l * y) % MOD;
            diffA[l] = (diffA[l] + val) % MOD;
            if (r + 1 < n) {
                diffA[r + 1] = (diffA[r + 1] - val + MOD) % MOD;
            }

            diffB[l] = (diffB[l] + y) % MOD;
            if (r + 1 < n) {
                diffB[r + 1] = (diffB[r + 1] - y + MOD) % MOD;
            }
        }
        long currA = 0;
        long currB = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            currA = (currA + diffA[i]) % MOD;
            currB = (currB + diffB[i]) % MOD;

            long val = (currA + currB * i) % MOD;
            sum = (sum + val) % MOD;
        }

        System.out.println(sum);
    }

    public static void BruteForce() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int queries = sc.nextInt();
        while (queries-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            //brute
            for (int i = l; i <= r; i++) {
                arr[i] = x + (i - l) * y;
            }
        }
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }

        System.out.println(sum);
    }
}

/*

5
5
5
0
3
0
5
0   2   1   2
0   1   6   5
2   3   8   0
2   4   9   6
3   4   8   9

 */
