
public class Solution {

    public int totalStrength(int[] strength) {
        long total = 0;
        int n = strength.length;
        int mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            long sum = 0;

            for (int j = i; j < n; j++) {
                int val = strength[j];
                min = Math.min(min, val);
                sum += val;
                total = (total + (long) min * sum) % mod;
            }
        }
        return (int) total;
    }

}
