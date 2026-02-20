# [2476. Closest Nodes Queries in a Binary Search Tree](https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/description/)

You are given the <code>root</code> of a **binary search tree ** and an array <code>queries</code> of size <code>n</code> consisting of positive integers.

Find a **2D** array <code>answer</code> of size <code>n</code> where <code>answer[i] = [min<sub>i</sub>, max<sub>i</sub>]</code>:

- <code>min<sub>i</sub></code> is the **largest** value in the tree that is smaller than or equal to <code>queries[i]</code>. If a such value does not exist, add <code>-1</code> instead.
- <code>max<sub>i</sub></code> is the **smallest** value in the tree that is greater than or equal to <code>queries[i]</code>. If a such value does not exist, add <code>-1</code> instead.

Return the array <code>answer</code>.

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2022/09/28/bstreeedrawioo.png" style="width: 261px; height: 281px;">

```
Input: root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
Output: [[2,2],[4,6],[15,-1]]
Explanation: We answer the queries in the following way:
- The largest number that is smaller or equal than 2 in the tree is 2, and the smallest number that is greater or equal than 2 is still 2. So the answer for the first query is [2,2].
- The largest number that is smaller or equal than 5 in the tree is 4, and the smallest number that is greater or equal than 5 is 6. So the answer for the second query is [4,6].
- The largest number that is smaller or equal than 16 in the tree is 15, and the smallest number that is greater or equal than 16 does not exist. So the answer for the third query is [15,-1].
```

**Example 2:**
<img alt="" src="https://assets.leetcode.com/uploads/2022/09/28/bstttreee.png" style="width: 101px; height: 121px;">

```
Input: root = [4,null,9], queries = [3]
Output: [[-1,4]]
Explanation: The largest number that is smaller or equal to 3 in the tree does not exist, and the smallest number that is greater or equal to 3 is 4. So the answer for the query is [-1,4].
```

**Constraints:**

- The number of nodes in the tree is in the range <code>[2, 10^5]</code>.
- <code>1 <= Node.val <= 10^6</code>
- <code>n == queries.length</code>
- <code>1 <= n <= 10^5</code>
- <code>1 <= queries[i] <= 10^6</code>
