class Solution {
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int minPrime = Integer.MAX_VALUE;
            int maxPrime = Integer.MIN_VALUE;
            int primeCount = 0;

            for (int j = i; j < n; j++) {
                if (isPrime(nums[j])) {
                    primeCount++;
                    minPrime = Math.min(minPrime, nums[j]);
                    maxPrime = Math.max(maxPrime, nums[j]);
                }
                if (primeCount >= 2 && maxPrime - minPrime <= k) count++;
            }
        }
        return count;
    }
}