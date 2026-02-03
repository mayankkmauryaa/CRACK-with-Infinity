# [2816. Double a Number Represented as a Linked List](https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/)

You are given the <code>head</code> of a **non-empty** linked list representing a non-negative integer without leading zeroes.

Return the <code>head</code> of the linked list after **doubling** it.

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2023/05/28/example.png" style="width: 401px; height: 81px;">

```
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
```

**Example 2:**
<img alt="" src="https://assets.leetcode.com/uploads/2023/05/28/example2.png" style="width: 401px; height: 81px;">

```
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.
```

**Constraints:**

- The number of nodes in the list is in the range <code>[1, 10^4]</code>
- <code>0 <= Node.val <= 9</code>
- The input is generated such that the list represents a number that does not have leading zeros, except the number <code>0</code> itself.
