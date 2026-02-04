# 3. Edges and Queries

[Check Solution](#solution)

**Problem:**

You are given a edges with root node as `1`. Every edge in the edges is undirected.
Each node has been assigned a values. You have to handle two kinds of queries.

`1 X Y` : change values of node `X` to `Y`
`0 X Y` : check whether the path from node `X` to node `Y` is dancing.

Path is dancing if all valuess form alternating sequence while travelling from node `X` to node `Y`.

Eg. of alternating valuess sequence: `4 9 6 7 2 100 18`

---

## Input

First line contains number `N` and `Q` as input.
Next `N - 1` lines contain `u` and `v` denoting there is an undirected edge between node `u` and `v`.
Next line contains `N` integers denoting values of each node.

---

## Output

Output for only query type `0` whether the path from node `u` to `v` is alternating or not.
Output should be `YES` or `NO`.

---

## Constraints

`1 ≤ N ≤ 5*10^4`
`1 ≤ u ≤ v ≤ N`

`1 ≤ Q ≤ 10^5`
`0 ≤ values of node ≤ 100`

---

## Example #1

**Input**

```
5 2
1 2
2 3
2 4
1 5
1 3 5 4 2
1 1 7
0 3 5
```

**Output**

```
YES
```

**Explanation:**

The path after updating becomes `3 7 2` which is alternating so answer for the query is `YES`.

---

## Solution

```java
import java.util.*;

class Main {

    static List<Integer>[] edges;
    static int[] values;
    static int[] parent, depth;

    static void dfs(int node, int par, int d) {
        parent[node] = par;
        depth[node] = d;
        for (int nxt : edges[node]) {
            if (nxt != par) {
                dfs(nxt, node, d + 1);
            }
        }
    }

    static void handleQuery(int type, int x, int y) {

        // update query
        if (type == 1) {
            values[x] = y;
            return;
        }

        // check alternating path
        int u = x, v = y;
        boolean ok = true;

        // make depths equal
        while (depth[u] > depth[v]) {
            if (parent[u] != 0 && values[u] == values[parent[u]]) {
                ok = false;
                break;
            }
            u = parent[u];
        }

        while (depth[v] > depth[u]) {
            if (parent[v] != 0 && values[v] == values[parent[v]]) {
                ok = false;
                break;
            }
            v = parent[v];
        }

        // move both until LCA
        while (u != v && ok) {
            if ((parent[u] != 0 && values[u] == values[parent[u]]) ||
                    (parent[v] != 0 && values[v] == values[parent[v]])) {
                ok = false;
                break;
            }
            u = parent[u];
            v = parent[v];
        }

        System.out.println(ok ? "YES" : "NO");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }

        values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        parent = new int[n + 1];
        depth = new int[n + 1];

        dfs(1, 0, 0);

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            handleQuery(type, x, y);
        }
    }
}
```