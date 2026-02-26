# 1️⃣ GRAPH FUNDAMENTALS

# Tree VS Graph

```table
| Feature                    | Tree          | Graph                       |
| -------------------------- | ------------- | --------------------------- |
| Cycles                     | ❌ No         | ✅ Yes                     |
| Unique path between nodes  | ✅ Yes        | ❌ Not guaranteed          |
| Hierarchical modeling      | ✅ Ideal      | ⚠️ Overkill                |
| Many-to-many relationships | ❌ No         | ✅ Yes                     |
| Algorithmic complexity     | Often simpler | More general, often heavier |
| Structural constraints     | Strict        | Flexible                    |
```

## What is a Graph?

A graph is a non-linear data structure consisting of:

- **Vertices (V)** → Nodes
- **Edges (E)** → Connections between nodes

Formally:

```
G = (V, E)
```

---

## Types of Graphs

### 1. Undirected Graph

Edge has no direction.

```
A -- B
```

### 2. Directed Graph

Edges have direction.

```
A → B
```

### 3. Weighted Graph

Edges have weights.

### 4. Cyclic vs Acyclic

- Cyclic → Contains cycle
- Acyclic → No cycle

---

## Graph Representation

### 1️⃣ Adjacency Matrix

```
int[][] graph = new int[n][n];
```

- Space: O(n²)
- Used for dense graphs

---

### 2️⃣ Adjacency List (MOST IMPORTANT)

```
ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
```

Space: O(V + E)

Best for sparse graphs.

---

# 2️⃣ DEPTH FIRST SEARCH (DFS)

## Definition

DFS explores as far as possible along a branch before backtracking.

Uses:

- Recursion
- Stack (explicit)

---

## Intuition

Think:

> Go deep → then backtrack

---

## DFS Template (Recursive)

```java
void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    visited[node] = true;

    for(int neighbor : adj.get(node)) {
        if(!visited[neighbor]) {
            dfs(neighbor, visited, adj);
        }
    }
}
```

---

## Time Complexity

O(V + E)

---

## Example

Graph:

```
0 — 1
|   |
2 — 3
```

DFS from 0:

```
0 → 1 → 3 → 2
```

---

## When to Use DFS

- Detect cycle
- Connected components
- Topological sort
- Islands problems
- Path existence

---

# 3️⃣ BREADTH FIRST SEARCH (BFS)

## Definition

BFS explores level by level.

Uses:

- Queue

---

## Intuition

Think:

> Explore all neighbors first

---

## BFS Template

```java
void bfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    visited[start] = true;

    while(!q.isEmpty()) {
        int node = q.poll();

        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                visited[neighbor] = true;
                q.add(neighbor);
            }
        }
    }
}
```

---

## Time Complexity

O(V + E)

---

## Example Traversal

Graph:

```
    0
   / \
  1   2
       \
        3
```

BFS:

```
0 → 1 → 2 → 3
```

---

## When to Use BFS

- Shortest path in unweighted graph
- Minimum steps problems
- Level order traversal
- Multi-source problems

---

# 4️⃣ 2D MATRIX AS GRAPH

VERY IMPORTANT FOR INTERVIEWS.

A matrix is treated as a graph where:

Each cell = node
Edges = neighbors (4 or 8 directions)

---

## Direction Arrays

### 4 Direction

```java
int[] dx = {-1, 0, 1, 0};
int[] dy = {0, 1, 0, -1};
```

---

## DFS in Matrix

```java
void dfs(int r, int c, int[][] grid, boolean[][] visited) {

    int n = grid.length;
    int m = grid[0].length;

    visited[r][c] = true;

    for(int i = 0; i < 4; i++) {
        int nr = r + dx[i];
        int nc = c + dy[i];

        if(nr >= 0 && nc >= 0 && nr < n && nc < m
           && !visited[nr][nc] && grid[nr][nc] == 1) {

            dfs(nr, nc, grid, visited);
        }
    }
}
```

---

## Time Complexity

O(N × M)

---

## Classic Problems

- Number of Islands
- Flood Fill
- Rotten Oranges
- Surrounded Regions

---

# 5️⃣ CYCLE DETECTION

---

# A️⃣ Cycle in Undirected Graph

## Method 1: DFS + Parent Tracking

Logic:
If visited neighbor ≠ parent → cycle exists.

---

### Code

```java
boolean dfs(int node, int parent, boolean[] visited,
            ArrayList<ArrayList<Integer>> adj) {

    visited[node] = true;

    for(int neighbor : adj.get(node)) {

        if(!visited[neighbor]) {
            if(dfs(neighbor, node, visited, adj))
                return true;
        }
        else if(neighbor != parent) {
            return true;
        }
    }

    return false;
}
```

---

## Method 2: BFS + Parent

Use pair(node, parent)

---

# B️⃣ Cycle in Directed Graph

## Method: DFS + Recursion Stack

We maintain:

- visited[]
- pathVisited[] (recursion stack)

---

### Code

```java
boolean dfs(int node, boolean[] visited,
            boolean[] pathVisited,
            ArrayList<ArrayList<Integer>> adj) {

    visited[node] = true;
    pathVisited[node] = true;

    for(int neighbor : adj.get(node)) {

        if(!visited[neighbor]) {
            if(dfs(neighbor, visited, pathVisited, adj))
                return true;
        }
        else if(pathVisited[neighbor]) {
            return true;
        }
    }

    pathVisited[node] = false;
    return false;
}
```

## Method: BFS + Parent

```java
import java.util.*;

public class CycleDetectionUndirected {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCheck(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfsCheck(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, -1));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int parent = current.parent;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Pair(neighbor, node));
                }
                else if (neighbor != parent) {
                    return true; // cycle detected
                }
            }
        }
        return false;
    }
}
```

---

## Why This Works?

Back edge → cycle in directed graph.

---

# 6️⃣ IMPORTANT LEETCODE PROBLEMS

---

## DFS / BFS Basic

1. [**Number of Provinces**](https://leetcode.com/problems/number-of-provinces/description/)
2. [**Flood Fill**](https://leetcode.com/problems/flood-fill/description/)
3. [**Find if Path Exists in Graph**](https://leetcode.com/problems/find-if-path-exists-in-graph/description/)

---

## 2D Matrix

4. [**Number of Islands**](https://leetcode.com/problems/number-of-islands/description/)
5. [**Rotting Oranges**](https://leetcode.com/problems/rotting-oranges/)
6. [**Surrounded Regions**](https://leetcode.com/problems/surrounded-regions/description/)

---

## Cycle Detection

7. **Course Schedule**
8. [**Redundant Connection**](https://leetcode.com/problems/redundant-connection/description/)
9. [**Graph Valid Tree**](https://leetcode.ca/2016-08-17-261-Graph-Valid-Tree/)

### solution

#### ✅ Key Properties of a Tree (Undirected Graph)

A graph is a valid tree iff:

1. It has exactly n - 1 edges
2. It is fully connected

For undirected graphs:

- If edges.length == n - 1 and the graph is connected → it must be a tree.

So we only need:

- Edge count check

- One traversal to verify connectivity

#### ✅ BFS Solution (Recommended)

Strategy

1. If edges.length != n - 1 → return false
2. Build adjacency list
3. BFS from node 0
4. Check if all nodes are visited

```java
import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }
}
```

---

## Advanced

10. **Clone Graph**
11. **Pacific Atlantic Water Flow**

---

# 7️⃣ COMMON MISTAKES

1. Forgetting to mark visited before recursion.
2. Not checking bounds in matrix.
3. Confusing parent logic in undirected graph.
4. Using only visited[] for directed cycle detection.
5. Not handling disconnected components.

---

## 🔵 Opening (5 mins)

“Today we are mastering one of the most important topics in DSA — Graph Traversal.
If you understand DFS, BFS, and cycle detection deeply, you unlock 40% of interview graph problems.”

---

## 🔵 Step 1: Graph Basics (15 mins)

Draw on board:

- Nodes
- Edges
- Directed vs Undirected
- Adjacency list

Explain space difference.

Ask:

> Which representation is better for sparse graph?

(Expected answer: Adjacency list)

---

## 🔵 Step 2: DFS (20 mins)

Draw tree.

Explain:

- Recursive nature
- Stack memory
- Backtracking

Walk through code line by line.

Dry run example.

Ask:

> What happens if graph has 2 components?

Then show:

```java
for(int i = 0; i < n; i++) {
   if(!visited[i]) dfs(i);
}
```

---

## 🔵 Step 3: BFS (20 mins)

Draw levels.

Explain:

- Queue
- Level order
- Why shortest path works

Compare DFS vs BFS clearly.

---

## 🔵 Step 4: 2D Matrix (25 mins)

Tell students:

> Matrix problems are hidden graph problems.

Draw grid.

Explain direction arrays.

Dry run Number of Islands.

Stress boundary conditions.

---

## 🔵 Step 5: Cycle Detection (30 mins)

### Undirected:

Explain parent logic with example triangle.

### Directed:

Draw cycle:

```
0 → 1 → 2 → 0
```

Explain recursion stack.

Very important conceptual clarity here.

---

## 🔵 Final 10 Minutes: Pattern Recognition

Ask class:

If problem says:

- “Minimum steps” → BFS
- “Count components” → DFS
- “Detect cycle directed” → DFS + stack
- “Grid traversal” → DFS/BFS + directions

---

# 9️⃣ Homework Structure

Level 1:

- 547
- 733
- 1971

Level 2:

- 200
- 994
- 207

Level 3:

- 133
- 417

---
