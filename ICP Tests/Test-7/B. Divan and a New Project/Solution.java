import java.util.*;

public class Solution {

    static class Pair {
        long value;
        int index;

        Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            Pair[] arr = new Pair[n];

            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(sc.nextLong(), i + 1);
            }

            // Sort in descending order of a[i]
            Arrays.sort(arr, (a, b) -> Long.compare(b.value, a.value));

            long[] x = new long[n + 1]; // x0 to xn
            x[0] = 0;

            long total = 0;
            long dist = 1;

            for (int i = 0; i < n; i++) {

                if (i % 2 == 0) {
                    x[arr[i].index] = dist;
                } else {
                    x[arr[i].index] = -dist;
                    dist++;
                }

                total += 2L * arr[i].value * Math.abs(x[arr[i].index]);
            }

            System.out.println(total);

            for (int i = 0; i <= n; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}