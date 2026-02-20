# [1932. Merge BSTs to Create Single BST](https://leetcode.com/problems/merge-bsts-to-create-single-bst/description/)

You are given <code>n</code> **BST (binary search tree) root nodes** for <code>n</code> separate BSTs stored in an array <code>trees</code> (**0-indexed** ). Each BST in <code>trees</code> has **at most 3 nodes** , and no two roots have the same value. In one operation, you can:

- Select two **distinct** indices <code>i</code> and <code>j</code> such that the value stored at one of the **leaves ** of <code>trees[i]</code> is equal to the **root value** of <code>trees[j]</code>.
- Replace the leaf node in <code>trees[i]</code> with <code>trees[j]</code>.
- Remove <code>trees[j]</code> from <code>trees</code>.

Return the **root** of the resulting BST if it is possible to form a valid BST after performing <code>n - 1</code> operations, or <code>null</code> <i>if it is impossible to create a valid BST</i>.

A BST (binary search tree) is a binary tree where each node satisfies the following property:

- Every node in the node's left subtree has a value**strictly less** than the node's value.
- Every node in the node's right subtree has a value**strictly greater** than the node's value.

A leaf is a node that has no children.

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/d1.png" style="width: 450px; height: 163px;">

````
Input: trees = [[2,1],[3,2,5],[5,4]]
Output: [3,2,5,1,null,4]
Explanation:
In the first operation, pick i=1 and j=0, and merge trees[0] into trees[1].
Delete trees[0], so trees = [[3,2,5,1],[5,4]].
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/24/diagram.png" style="width: 450px; height: 181px;">
In the second operation, pick i=0 and j=1, and merge trees[1] into trees[0].
Delete trees[1], so trees = [[3,2,5,1,null,4]].
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/24/diagram-2.png" style="width: 220px; height: 165px;">
The resulting tree, shown above, is a valid BST, so return its root.```

**Example 2:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/d2.png" style="width: 450px; height: 171px;">

````

Input: trees = [[5,3,8],[3,2,6]]
Output: []
Explanation:
Pick i=0 and j=1 and merge trees[1] into trees[0].
Delete trees[1], so trees = [[5,3,8,2,6]].
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/24/diagram-3.png" style="width: 240px; height: 196px;">
The resulting tree is shown above. This is the only valid operation that can be performed, but the resulting tree is not a valid BST, so return null.

```

**Example 3:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/d3.png" style="width: 430px; height: 168px;">

```

Input: trees = [[5,4],[3]]
Output: []
Explanation: It is impossible to perform any operations.

```

**Constraints:**

- <code>n == trees.length</code>
- <code>1 <= n <= 5 * 10^4</code>
- The number of nodes in each tree is in the range <code>[1, 3]</code>.
- Each node in the input may have children but no grandchildren.
- No two roots of <code>trees</code> have the same value.
- All the trees in the input are **valid BSTs** .
- <code>1 <= TreeNode.val <= 5 * 10^4</code>.
```
