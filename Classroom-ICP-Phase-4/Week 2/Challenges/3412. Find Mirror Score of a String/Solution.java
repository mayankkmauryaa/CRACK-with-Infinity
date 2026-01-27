
import java.util.Stack;

public class Solution {

    public long calculateScore(String s) {
        int n = s.length();
        long score = 0;

        // One stack per character (a–z)
        Stack<Integer>[] st = new Stack[26];
        for (int i = 0; i < 26; i++) {
            st[i] = new Stack<>();
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            char mirror = getMirror(ch);

            int mirrorIdx = mirror - 'a';

            // If closest mirror exists, match it
            if (!st[mirrorIdx].isEmpty()) {
                int j = st[mirrorIdx].pop();
                score += (i - j);
            } // Otherwise, store this index
            else {
                st[ch - 'a'].push(i);
            }
        }

        return score;
    }

    char getMirror(char ch) {
        return (char) ('a' + 'z' - ch);
    }
}
