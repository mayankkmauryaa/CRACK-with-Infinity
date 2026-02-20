import java.util.*;

class Solution {
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {

        List<Integer> list = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < q; i++) {

            int l = queries[idx++];
            int r = queries[idx++];

            int sum = 0;

            for (int j = l - 1; j <= r - 1; j++) {
                sum += arr[j];
            }

            list.add(sum);
        }

        return list;
    }
}