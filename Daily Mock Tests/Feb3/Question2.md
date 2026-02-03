# Problem 2: Minimum Number of Bridges (Monk and the Islands)

[Check Solution](#solution)

## Problem Statement

Monk visits the land of Islands. There are `N islands` and `M bridges` connecting some of the islands. Monk is standing at island `1` and wants to reach island `N`.

Each bridge connects `two islands` and can be crossed in both directions. Monk can cross any bridge at most once.

Find the **minimum number** of bridges Monk has to cross to reach island `N`.

- extract :

  You are given **N islands** and **M bridges** connecting some pairs of islands.
  Each bridge connects two islands bidirectionally.

  Your task is to determine the **minimum number of bridges required to connect all islands**, so that every island is reachable from every other island.

  If it is **not possible** to connect all islands, print `-1`.

---

## Input Format

- The first line contains a single integer **T** — number of test cases.
- For each test case:
  - The first line contains two integers **N** and **M**.
  - The next **M** lines each contain two integers **X** and **Y**, representing a bridge between island **X** and island **Y**.

---

## Output Format

- For each test case, print a **single integer** — the minimum number of bridges required to connect all islands, or `-1` if impossible.

---

## Constraints

`1 ≤ T ≤ 10`

`1 ≤ N ≤ 10^5`

`0 ≤ M ≤ 10^5`

`1 ≤ X, Y ≤ N`

---

## Notes

- Islands form an **undirected graph**.
- If the graph has **C connected components**, then at least **C − 1** bridges are required.
- If **M < N − 1**, connecting all islands is impossible.

---

## Sample Test Cases

### Test Case 1

**Input**

```
2
3 2
1 2
2 3
4 4
1 2
2 3
3 4
4 2
```

**Output**

```
2
2
```

### Test Case 2

**Input**

```
1
4 2
1 2
3 4
```

**Output**

```
1
```

---

### Test Case 3

**Input**

```
1
3 3
1 2
2 3
1 3
```

**Output**

```
0
```

---

### Test Case 4

**Input**

```
1
5 1
1 2
```

**Output**

```
-1
```

---

## Expected Time Complexity

- **O(N + M)** per test case

---

## Hint (Optional)

Count the number of connected components using DFS or BFS.

---

## Solution

```java
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph;

    static void findMinimumBridges(int n, int m) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == n) {
                System.out.println(dist[curr]);
                return;
            }

            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            findMinimumBridges(n, m);
        }
        sc.close();
    }
}
```
