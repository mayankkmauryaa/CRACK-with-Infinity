# [2673. Make Costs of Paths Equal in a Binary Tree](https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/description/)

You are given an integer <code>n</code> representing the number of nodes in a **perfect binary tree** consisting of nodes numbered from <code>1</code> to <code>n</code>. The root of the tree is node <code>1</code> and each node <code>i</code> in the tree has two children where the left child is the node <code>2 _ i</code> and the right child is <code>2 _ i + 1</code>.

Each node in the tree also has a **cost** represented by a given **0-indexed** integer array <code>cost</code> of size <code>n</code> where <code>cost[i]</code> is the cost of node <code>i + 1</code>. You are allowed to **increment** the cost of **any** node by <code>1</code> **any** number of times.

Return the **minimum** number of increments you need to make the cost of paths from the root to each **leaf** node equal.

**Note** :

- A **perfect binary tree ** is a tree where each node, except the leaf nodes, has exactly 2 children.
- The **cost of a path** is the sum of costs of nodes in the path.

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2023/04/04/binaryytreeedrawio-4.png">

```
Input: n = 7, cost = [1,5,2,2,3,3,1]
Output: 6
Explanation: We can do the following increments:
- Increase the cost of node 4 one time.
- Increase the cost of node 3 three times.
- Increase the cost of node 7 two times.
Each path from the root to a leaf will have a total cost of 9.
The total increments we did is 1 + 3 + 2 = 6.
It can be shown that this is the minimum answer we can achieve.
```

**Example 2:**
<img alt="" src="https://assets.leetcode.com/uploads/2023/04/04/binaryytreee2drawio.png" style="width: 205px; height: 151px;">

```
Input: n = 3, cost = [5,3,3]
Output: 0
Explanation: The two paths already have equal total costs, so no increments are needed.
```

**Constraints:**

- <code>3 <= n <= 10^5</code>
- <code>n + 1</code> is a power of <code>2</code>
- <code>cost.length == n</code>
- <code>1 <= cost[i] <= 10^4</code>
