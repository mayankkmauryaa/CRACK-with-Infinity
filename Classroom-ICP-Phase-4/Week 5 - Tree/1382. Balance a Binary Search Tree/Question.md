# [1382. Balance a Binary Search Tree](https://leetcode.com/problems/balance-a-binary-search-tree/description/)

Given the <code>root</code> of a binary search tree, return a **balanced** binary search tree with the same node values. If there is more than one answer, return **any of them** .

A binary search tree is **balanced** if the depth of the two subtrees of every node never differs by more than <code>1</code>.

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/balance1-tree.jpg" style="width: 500px; height: 319px;">

```
Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
<b>Explanation:</b> This is not the only correct answer, [3,1,4,null,2] is also correct.
```

**Example 2:**
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/balanced2-tree.jpg" style="width: 224px; height: 145px;">

```
Input: root = [2,1,3]
Output: [2,1,3]
```

**Constraints:**

- The number of nodes in the tree is in the range <code>[1, 10^4]</code>.
- <code>1 <= Node.val <= 10^5</code>
