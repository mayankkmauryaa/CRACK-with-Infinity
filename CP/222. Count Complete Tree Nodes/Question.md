# [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/description/)

Given the <code>root</code> of a **complete** binary tree, return the number of the nodes in the tree.

According to **<a href="http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees" target="_blank">Wikipedia</a>** , every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between <code>1</code> and <code>2^h</code> nodes inclusive at the last level <code>h</code>.

Design an algorithm that runs in less than<code data-stringify-type="code">O(n)</code>time complexity.

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/complete.jpg" style="width: 372px; height: 302px;">

```
Input: root = [1,2,3,4,5,6]
Output: 6
```

**Example 2:**

```
Input: root = []
Output: 0
```

**Example 3:**

```
Input: root = [1]
Output: 1
```

**Constraints:**

- The number of nodes in the tree is in the range <code>[0, 5 * 10^4]</code>.
- <code>0 <= Node.val <= 5 \* 10^4</code>
- The tree is guaranteed to be **complete** .
