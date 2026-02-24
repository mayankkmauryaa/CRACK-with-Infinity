# [1022. Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/?envType=daily-question&envId=2026-02-24)

You are given the <code>root</code> of a binary tree where each node has a value <code>0</code> or <code>1</code>. Each root-to-leaf path represents a binary number starting with the most significant bit.

- For example, if the path is <code>0 -> 1 -> 1 -> 0 -> 1</code>, then this could represent <code>01101</code> in binary, which is <code>13</code>.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a **32-bits**  integer.

**Example 1:** 
<img alt="" src="https://assets.leetcode.com/uploads/2019/04/04/sum-of-root-to-leaf-binary-numbers.png" style="width: 400px; height: 263px;">

```
Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

**Example 2:** 

```
Input: root = [0]
Output: 0
```

**Constraints:** 

- The number of nodes in the tree is in the range <code>[1, 1000]</code>.
- <code>Node.val</code> is <code>0</code> or <code>1</code>.