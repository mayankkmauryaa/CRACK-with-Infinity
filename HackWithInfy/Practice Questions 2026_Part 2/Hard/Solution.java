
import java.util.*;

public class Solution {

    static List<Integer>[] tree;
    static int[] col;
    static int[] par;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            par[i] = sc.nextInt();
        }
        col = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            col[i] = sc.nextInt();
        }
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            tree[par[i]].add(i);
        }
        long ans = 0;
        int MOD = 1_000_000_007;
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int qi = sc.nextInt();
            ans = (ans + dfs(qi, new HashSet<>())) % MOD;
        }
        System.out.println(ans);
    }

    public static int dfs(int u, Set<Integer> set) {
        if (set.contains(col[u])) {
            return 0;
        }
        set.add(col[u]);

        int max = 0;
        for (int v : tree[u]) {
            max = Math.max(max, dfs(v, set));
        }
        set.remove(col[u]);
        return 1 + max;
    }
}
