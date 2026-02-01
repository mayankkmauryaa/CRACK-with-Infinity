import java.util.Scanner;

public class Solution {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        long total = 0;

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            if (type == 1) {
                long base = arr[left];
                for (int j = left; j <= right; j++) {
                    arr[j] = (j - left + 1) * base;
                }
            } else {
                long sum = 0;
                for (int j = left; j <= right; j++) {
                    sum = (sum + arr[j]) % MOD;
                }
                total = (total + sum) % MOD;
            }
        }

        System.out.println(total);
    }
}
