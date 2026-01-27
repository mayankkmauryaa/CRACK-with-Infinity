
import java.util.*;

public class Solution {

    static class Disc {

        int radius;
        int height;

        Disc(int r, int h) {
            radius = r;
            height = h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Disc[] discs = new Disc[n];

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int h = sc.nextInt();
            discs[i] = new Disc(r, h);
        }

        // Sort by radius descending, then height descending
        Arrays.sort(discs, (a, b) -> {
            if (b.radius != a.radius) {
                return b.radius - a.radius;
            }
            return b.height - a.height;
        });

        int[] dp = new int[n];
        int maxHeight = 0;

        // Initialize DP
        for (int i = 0; i < n; i++) {
            dp[i] = discs[i].height;
        }

        // Compute maximum tower height
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (discs[i].radius < discs[j].radius
                        && discs[i].height < discs[j].height) {

                    dp[i] = Math.max(dp[i], dp[j] + discs[i].height);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        System.out.println(maxHeight);
        sc.close();
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 2D matrix: matrix[i][0] = radius, matrix[i][1] = height
        int[][] matrix = new int[n][2];

        for (int i = 0; i < n; i++) {
            matrix[i][0] = sc.nextInt(); // radius
            matrix[i][1] = sc.nextInt(); // height
        }

        int result = maxTowerHeight(matrix, n);
        System.out.println(result);

        sc.close();
    }

    // Separate function to calculate maximum height
    public static int maxTowerHeight(int[][] matrix, int n) {

        // Sort by radius descending, then height descending
        Arrays.sort(matrix, (a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });

        int[] dp = new int[n];
        int maxHeight = 0;

        // Initialize DP
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[i][1];
        }

        // DP computation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][0] < matrix[j][0]
                        && matrix[i][1] < matrix[j][1]) {

                    dp[i] = Math.max(dp[i], dp[j] + matrix[i][1]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }
}
