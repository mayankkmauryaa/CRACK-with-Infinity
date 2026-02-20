import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }

            long max = Long.MIN_VALUE;
            long[] c = new long[n];

            for (int i = 0; i < n; i++) {
                c[i] = a[i] - b[i];
                max = Math.max(max, c[i]);
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (c[i] == max) {
                    result.add(i + 1); // 1-based index
                }
            }

            System.out.println(result.size());

            for (int idx : result) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}