# [3510. Minimum Pair Removal to Sort Array II](https://leetcode.com/problems/minimum-pair-removal-to-sort-array-ii/description/)

Given an array <code>nums</code>, you can perform the following operation any number of times:

- Select the **adjacent** pair with the **minimum** sum in <code>nums</code>. If multiple such pairs exist, choose the leftmost one.
- Replace the pair with their sum.

Return the **minimum number of operations** needed to make the array **non-decreasing** .

An array is said to be **non-decreasing** if each element is greater than or equal to its previous element (if it exists).

**Example 1:**

<div class="example-block">
Input: nums = [5,2,3,1]

Output: 2

Explanation:

- The pair <code>(3,1)</code> has the minimum sum of 4. After replacement, <code>nums = [5,2,4]</code>.
- The pair <code>(2,4)</code> has the minimum sum of 6. After replacement, <code>nums = [5,6]</code>.

The array <code>nums</code> became non-decreasing in two operations.

**Example 2:**

<div class="example-block">
Input: nums = [1,2,2]

Output: 0

Explanation:

The array <code>nums</code> is already sorted.

**Constraints:**

- <code>1 <= nums.length <= 10^5</code>
- <code>-10^9 <= nums[i] <= 10^9</code>
