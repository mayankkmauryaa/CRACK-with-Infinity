
import java.util.Deque;
import java.util.LinkedList;

class Solution_XOR {

    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                count++;
            }
        }
        return (nums[n - 2] == 1 && nums[n - 1] == 1) ? count : -1;
    }
}

public class Solution {

    public int minOperations(int[] nums) {
        Deque<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        while (q.size() >= 3) {
            while (!q.isEmpty() && q.getFirst() == 1) {
                q.remove();
            }

            if (q.size() < 3) {
                break;
            }

            if (q.getFirst() == 0) {
                count++;
                q.removeFirst();
                int second = q.removeFirst();
                int third = q.removeFirst();

                if (second == 1) {
                    if (third == 1) {
                        q.addFirst(0);
                        q.addFirst(0);
                    } else {
                        q.addFirst(1);
                        q.addFirst(0);
                    }
                } else {
                    if (third == 1) {
                        q.addFirst(0);
                    }
                }
            }
        }

        for (int val : q) {
            if (val != 1) {
                return -1;
            }
        }
        return count;
    }
}
