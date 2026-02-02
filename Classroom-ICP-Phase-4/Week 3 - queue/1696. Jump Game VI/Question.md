# [1696. Jump Game VI](https://leetcode.com/problems/jump-game-vi/description/)

You are given a **0-indexed** integer array <code>nums</code> and an integer <code>k</code>.

You are initially standing at index <code>0</code>. In one move, you can jump at most <code>k</code> steps forward without going outside the boundaries of the array. That is, you can jump from index <code>i</code> to any index in the range <code>[i + 1, min(n - 1, i + k)]</code> **inclusive** .

You want to reach the last index of the array (index <code>n - 1</code>). Your **score** is the **sum** of all <code>nums[j]</code> for each index <code>j</code> you visited in the array.

Return the **maximum score** you can get.

**Example 1:**

```
Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
```

**Example 2:**

```
Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
```

**Example 3:**

```
Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0
```

**Constraints:**

- <code>1 <= nums.length, k <= 10^5</code>
- <code>-10^4 <= nums[i] <= 10^4</code>
