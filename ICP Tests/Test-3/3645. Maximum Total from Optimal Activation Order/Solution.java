
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        HashMap<Integer, PriorityQueue<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lim = limit[i];
            mp.putIfAbsent(lim, new PriorityQueue<>());
            PriorityQueue<Integer> pq = mp.get(lim);
            pq.add(value[i]);
            if (pq.size() > lim) {
                pq.poll();
            }
        }

        long ans = 0;
        for (int key : mp.keySet()) {
            PriorityQueue<Integer> pq = mp.get(key);
            while (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        return ans;
    }
}

class Solution1 {

    public long maxTotal(int[] value, int[] limit) {
        HashMap<Integer, ArrayList<Integer>> buckets = new HashMap<>();
        int n = value.length;
        for (int i = 0; i < n; i++) {
            buckets.computeIfAbsent(limit[i], k -> new ArrayList<>()).add(value[i]);
        }
        long ans = 0;
        for (HashMap.Entry<Integer, ArrayList<Integer>> e : buckets.entrySet()) {

            int L = e.getKey();
            ArrayList<Integer> arr = e.getValue();
            arr.sort(Comparator.reverseOrder());

            int take = Math.min(L, arr.size());
            for (int i = 0; i < take; i++) {
                ans += arr.get(i);
            }
        }
        return ans;
    }
}
