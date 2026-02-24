import java.util.*;

class Solution_Brute {
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

public class Solution {
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        
        List<Integer> list = new ArrayList<>();
        
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        
        int idx = 0;
        
        for (int i = 0; i < q; i++) {
            int l = queries[idx++];
            int r = queries[idx++];
            
            int sum = prefix[r] - prefix[l - 1];
            list.add(sum);
        }
        
        return list;
    }
}