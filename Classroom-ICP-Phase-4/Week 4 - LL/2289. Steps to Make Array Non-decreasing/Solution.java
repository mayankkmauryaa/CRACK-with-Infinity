import java.util.ArrayList;
import java.util.List;

public class Solution {

    // In one step, remove all nums[i] where nums[i-1] > nums[i]

    public int totalSteps(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int x : nums)
            arr.add(x);

        int steps = 0;

        while (true) {
            List<Integer> next = new ArrayList<>();
            next.add(arr.get(0));
            boolean removed = false;

            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i - 1) <= arr.get(i)) {
                    next.add(arr.get(i));
                } else {
                    removed = true; // this element is removed
                }
            }

            if (!removed)
                break;

            arr = next;
            steps++;
        }

        return steps;
    }
}
