
import java.util.*;

class Solution {

    public static int maxCandyTypes(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int c : candyType) {
            set.add(c);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
