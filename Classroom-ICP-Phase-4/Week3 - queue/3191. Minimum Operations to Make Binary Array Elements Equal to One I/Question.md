# [3191. Minimum Operations to Make Binary Array Elements Equal to One I](https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/)

You are given a <button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-:r1k:" data-state="closed" class="">binary array</button> <code>nums</code>.

You can do the following operation on the array **any** number of times (possibly zero):

- Choose **any** 3 **consecutive** elements from the array and **flip** **all** of them.

**Flipping** an element means changing its value from 0 to 1, and from 1 to 0.

Return the **minimum** number of operations required to make all elements in <code>nums</code> equal to 1. If it is impossible, return -1.

**Example 1:**

<div class="example-block">
Input: nums = [0,1,1,1,0,0]

Output: 3

Explanation:<br>
We can do the following operations:

- Choose the elements at indices 0, 1 and 2. The resulting array is <code>nums = [**1** ,**0** ,**0** ,1,0,0]</code>.
- Choose the elements at indices 1, 2 and 3. The resulting array is <code>nums = [1,**1** ,**1** ,**0** ,0,0]</code>.
- Choose the elements at indices 3, 4 and 5. The resulting array is <code>nums = [1,1,1,**1** ,**1** ,**1** ]</code>.

**Example 2:**

<div class="example-block">
Input: nums = [0,1,1,1]

Output: -1

Explanation:<br>
It is impossible to make all elements equal to 1.

**Constraints:**

- <code>3 <= nums.length <= 10^5</code>
- <code>0 <= nums[i] <= 1</code>
