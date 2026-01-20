# Subarrays with Exactly K Distinct Products

## Problem Statement

A retail analytics company wants to analyze customer shopping behavior based on the **variety of products purchased in a continuous shopping session**. Each session is represented as an array of product IDs in the order they were added to the cart.

The company is interested in finding how many **contiguous subarrays** (sub-segments of the session) contain **exactly `k` distinct products**.

Your task is to design an efficient algorithm that, given:

- an array `nums` representing product IDs
- an integer `k`

returns the **number of subarrays with exactly `k` distinct elements**.

This is a **medium-level Sliding Window** problem.

---

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `1 <= nums[i] <= nums.length`
- `1 <= k <= nums.length`

---

## Examples

### Example 1

**Input:**

```
nums = [1,2,1,2,3], k = 2
```

**Output:**

```
7
```

**Explanation:**
Subarrays with exactly 2 distinct integers are:

```
[1,2], [2,1], [1,2], [2,3],
[1,2,1], [2,1,2], [1,2,1,2]
```

---

### Example 2

**Input:**

```
nums = [1,2,1,3,4], k = 3
```

**Output:**

```
3
```

**Explanation:**
Subarrays with exactly 3 distinct integers are:

```
[1,2,1,3], [2,1,3], [1,3,4]
```

---

## Additional Test Cases

### Input 0

```
nums = [1,2,1,3,4,5]
k = 3
```

**Output:**

```
4
```

---

### Input 1

```
nums = [1,2,1]
k = 3
```

**Output:**

```
0
```

---

### Input 2

```
nums = [1,2,1,4,8,9,10]
k = 2
```

**Output:**

```
7
```

---

### Input 3

```
nums = [4,5,4,4,5]
k = 2
```

**Output:**

```
9
```

---

## Key Idea (Sliding Window)

- Count subarrays with **at most `k` distinct elements**
- Count subarrays with **at most `k - 1` distinct elements**
- The answer is:

```

exactlyK = atMostK(k) - atMostK(k - 1)

```

This approach ensures an **O(n)** time complexity using a HashMap and sliding window technique.

---

## Topics

`Sliding Window`
`HashMap`
`Two Pointers`
`Array`
