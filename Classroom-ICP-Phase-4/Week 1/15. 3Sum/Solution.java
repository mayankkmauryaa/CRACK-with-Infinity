
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] > 0)
//                 return result;
//             if (i > 0 && nums[i] == nums[i - 1])
//                 continue;
//             int left = i + 1;
//             int right = nums.length - 1;
//             while (right > left) {
//                 int sum = nums[i] + nums[left] + nums[right];
//                 if (sum > 0)
//                     right--;
//                 else if (sum < 0)
//                     left++;
//                 else {
//                     result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                     while (right > left && nums[right] == nums[right - 1])
//                         right--;
//                     while (right > left && nums[left] == nums[left + 1])
//                         left++;
//                     right--;
//                     left++;
//                 }
//             }
//         }
//         return result;
//     }
// }
