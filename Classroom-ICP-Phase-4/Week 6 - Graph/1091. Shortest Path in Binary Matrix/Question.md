# [1091. Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/description/)

Given an <code>n x n</code> binary matrix <code>grid</code>, return the length of the shortest **clear path** in the matrix. If there is no clear path, return <code>-1</code>.

A **clear path** in a binary matrix is a path from the **top-left** cell (i.e., <code>(0, 0)</code>) to the **bottom-right** cell (i.e., <code>(n - 1, n - 1)</code>) such that:

- All the visited cells of the path are <code>0</code>.
- All the adjacent cells of the path are **8-directionally** connected (i.e., they are different and they share an edge or a corner).

The **length of a clear path** is the number of visited cells of this path.

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/example1_1.png" style="width: 500px; height: 234px;">

```
Input: grid = [[0,1],[1,0]]
Output: 2
```

**Example 2:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/example2_1.png" style="height: 216px; width: 500px;">

```
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
```

**Example 3:**

```
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
```

**Constraints:**

- <code>n == grid.length</code>
- <code>n == grid[i].length</code>
- <code>1 <= n <= 100</code>
- <code>grid[i][j] is 0 or 1</code>
