
import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007;

    public static int sumOfPower(int[] nums) {
        Arrays.sort(nums);

        long result = 0;
        long prefixMinSum = 0;

        for (int x : nums) {
            long maxSquared = (long) x * x % MOD;
            result = (result + maxSquared * (x + prefixMinSum) % MOD) % MOD;
            prefixMinSum = (prefixMinSum * 2 + x) % MOD;
        }
        return (int) result;
    }
}
