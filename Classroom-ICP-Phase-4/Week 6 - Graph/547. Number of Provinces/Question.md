# [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/description/)

There are <code>n</code> cities. Some of them are connected, while some are not. If city <code>a</code> is connected directly with city <code>b</code>, and city <code>b</code> is connected directly with city <code>c</code>, then city <code>a</code> is connected indirectly with city <code>c</code>.

A **province** is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an <code>n x n</code> matrix <code>isConnected</code> where <code>isConnected[i][j] = 1</code> if the <code>i^th</code> city and the <code>j^th</code> city are directly connected, and <code>isConnected[i][j] = 0</code> otherwise.

Return the total number of **provinces** .

**Example 1:**
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph1.jpg" style="width: 222px; height: 142px;">

```
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
```

**Example 2:**
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph2.jpg" style="width: 222px; height: 142px;">

```
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
```

**Constraints:**

- <code>1 <= n <= 200</code>
- <code>n == isConnected.length</code>
- <code>n == isConnected[i].length</code>
- <code>isConnected[i][j]</code> is <code>1</code> or <code>0</code>.
- <code>isConnected[i][i] == 1</code>
- <code>isConnected[i][j] == isConnected[j][i]</code>
