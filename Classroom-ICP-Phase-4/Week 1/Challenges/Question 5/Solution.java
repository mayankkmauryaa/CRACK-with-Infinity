
class Solution {

    public static int maxParityDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[5];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - '0']++;

                if (j - i + 1 >= k) {
                    for (int a = 0; a < 5; a++) {
                        if (freq[a] % 2 == 1) {
                            for (int b = 0; b < 5; b++) {
                                if (freq[b] > 0 && freq[b] % 2 == 0) {
                                    ans = Math.max(ans, freq[a] - freq[b]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
