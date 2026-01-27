# Sliding Window Beauty of Stock Price Changes

## Problem Statement

You are working as a software engineer for a financial analytics company that analyzes stock
price movements to detect unusual market behavior. Each day’s stock price change is
represented as an integer in an array:

- Positive values indicate gains
- Negative values indicate losses

For analytical purposes, the company defines the **“beauty”** of a sliding window of size `k`
as the **x-th smallest negative number** within that window.

Rules:

- Only **negative numbers** are considered
- If a window contains **fewer than `x` negative numbers**, the beauty is `0`

Your task is to compute the beauty for **every contiguous subarray of size `k`**.

---

## Constraints

- `n == nums.length`
- `1 <= n <= 10^5`
- `1 <= k <= n`
- `1 <= x <= k`
- `-50 <= nums[i] <= 50`

---

## Examples

### Example 1

**Input:**

```
nums = [1,-1,-3,-2,3], k = 3, x = 2
```

**Output:**

```
[-1, -2, -2]
```

**Explanation:**

- Window `[1, -1, -3]` → negatives = `[-3, -1]` → 2nd smallest = `-1`
- Window `[-1, -3, -2]` → negatives = `[-3, -2, -1]` → 2nd smallest = `-2`
- Window `[-3, -2, 3]` → negatives = `[-3, -2]` → 2nd smallest = `-2`

---

### Example 2

**Input:**

```
nums = [-1,-2,-3,-4,-5], k = 2, x = 2
```

**Output:**

```
[-1, -2, -3, -4]
```

**Explanation:**
Each window has exactly 2 negative numbers, so the 2nd smallest is returned.

---

### Example 3

**Input:**

```
nums = [-3,1,2,-3,0,-3], k = 2, x = 1
```

**Output:**

```
[-3, 0, -3, -3, -3]
```

**Explanation:**

- If a window has no negative numbers, the beauty is `0`
- Otherwise, return the 1st smallest negative number

---

## Additional Test Cases

### Input 0

```
nums = [1, -1, -3, -2, 3, 4]
k = 3
x = 2
```

**Output:**

```
-1 -2 -2 0
```

---

### Input 1

```
nums = [1, -1, -3, -2, 3, -4]
k = 3
x = 2
```

**Output:**

```
-1 -2 -2 -2
```

---

### Input 2

```
nums = [-1, -3, -2, 3, -4]
k = 3
x = 3
```

**Output:**

```
-1 0 0
```

---

### Input 3

```
nums = [-1, -3, -2, 3, -4]
k = 2
x = 2
```

**Output:**

```
-1 -2 0 0
```

---

## Key Idea

- Use a **sliding window of size `k`**
- Track frequencies of negative numbers
- Since `nums[i]` is limited to `[-50, 50]`, use a **frequency array** for optimization
- For each window:
- Collect negative numbers in sorted order implicitly
- Find the **x-th smallest negative**
- If it doesn’t exist, return `0`

This approach efficiently handles large inputs.

---

## Topics

`Sliding Window`
`Counting / Frequency Array`
`Order Statistics`
`Array`
