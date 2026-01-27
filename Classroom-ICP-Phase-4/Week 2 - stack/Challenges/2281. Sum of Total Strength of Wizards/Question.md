# [2281. Sum of Total Strength of Wizards](https://leetcode.com/problems/sum-of-total-strength-of-wizards/)

## Problem Statement

As the ruler of a kingdom, you have an army of wizards at your command.

You are given a **0-indexed integer array** `strength`, where `strength[i]` denotes the strength of the `i`-th wizard.

For a **contiguous group** of wizards (i.e., a **subarray** of `strength`), the **total strength** is defined as the **product** of:

1. The strength of the **weakest** wizard in the group.
2. The **sum** of all strengths of the wizards in the group.

Return the **sum of the total strengths of all contiguous groups** of wizards.

Since the answer may be very large, return it **modulo** `10^9 + 7`.

---

## Definitions

- A **subarray** is a contiguous, non-empty sequence of elements within an array.
- The **weakest wizard** in a group is the minimum value in that subarray.

---

## Examples

### Example 1

**Input**

```
strength = [1, 3, 1, 2]
```

**Output**

```
44
```

**Explanation**

All contiguous groups of wizards:

| Subarray     | Minimum | Sum | Total Strength |
| ------------ | ------- | --- | -------------- |
| [1]          | 1       | 1   | 1 × 1 = 1      |
| [3]          | 3       | 3   | 3 × 3 = 9      |
| [1]          | 1       | 1   | 1 × 1 = 1      |
| [2]          | 2       | 2   | 2 × 2 = 4      |
| [1, 3]       | 1       | 4   | 1 × 4 = 4      |
| [3, 1]       | 1       | 4   | 1 × 4 = 4      |
| [1, 2]       | 1       | 3   | 1 × 3 = 3      |
| [1, 3, 1]    | 1       | 5   | 1 × 5 = 5      |
| [3, 1, 2]    | 1       | 6   | 1 × 6 = 6      |
| [1, 3, 1, 2] | 1       | 7   | 1 × 7 = 7      |

**Total Sum**

```
1 + 9 + 1 + 4 + 4 + 4 + 3 + 5 + 6 + 7 = 44
```

---

### Example 2

**Input**

```
strength = [5, 4, 6]
```

**Output**

```
213
```

**Explanation**

All contiguous groups of wizards:

| Subarray  | Minimum | Sum | Total Strength |
| --------- | ------- | --- | -------------- |
| [5]       | 5       | 5   | 5 × 5 = 25     |
| [4]       | 4       | 4   | 4 × 4 = 16     |
| [6]       | 6       | 6   | 6 × 6 = 36     |
| [5, 4]    | 4       | 9   | 4 × 9 = 36     |
| [4, 6]    | 4       | 10  | 4 × 10 = 40    |
| [5, 4, 6] | 4       | 15  | 4 × 15 = 60    |

**Total Sum**

```
25 + 16 + 36 + 36 + 40 + 60 = 213
```

---

## Constraints

- `1 <= strength.length <= 10^5`
- `1 <= strength[i] <= 10^9`

---

## Notes

- The solution must be optimized for large input sizes.
- A brute-force approach will not pass due to time constraints.
- Typical solutions use:
  - Monotonic stacks
  - Prefix sums
  - Prefix-of-prefix sums

---

## Topics

`Array`
`Stack`
`Monotonic Stack`
`Prefix Sum`

---

## Contest

- **Weekly Contest 294**

---

## Companies

> _This problem is frequently asked by top-tier technology companies._

---

## Hints

### Hint 1

Consider the **contribution of each wizard** to the final answer rather than evaluating every subarray independently.

### Hint 2

Can you **efficiently compute the total contribution** of all subarrays that **end at a given index**?

### Hint 3

Let `solve[i]` denote the **total contribution of all subarrays ending at index `i`**.  
Can you express `solve[i]` in terms of `solve[m]` for some `m < i`?

---

## Similar Questions

| Problem                             | Difficulty |
| ----------------------------------- | ---------- |
| Next Greater Element I              | Easy       |
| Sum of Subarray Minimums            | Medium     |
| Sum of Subarray Ranges              | Medium     |
| Number of Visible People in a Queue | Hard       |

---
