# [3645. Maximum Total from Optimal Activation Order](https://leetcode.com/problems/maximum-total-from-optimal-activation-order/description/)

## Problem Statement

You are given two integer arrays `value` and `limit`, both of length `n`.

Initially, all elements are **inactive**. You may activate them in any order.

Rules for activation:

- To activate an inactive element at index `i`, the number of **currently active** elements must be **strictly less than** `limit[i]`.
- When you activate the element at index `i`, it adds `value[i]` to the **total activation value**.
- After each activation, if the number of **currently active** elements becomes `x`, then **all** elements `j` with `limit[j] <= x` become **permanently inactive**, even if they are already active.

Return the **maximum total value** that can be obtained by choosing the activation order optimally.

---

## Example 1

**Input**

```
value = [3, 5, 8]
limit = [2, 1, 3]
```

**Output**

```
16
```

**Explanation**

One optimal activation order:

| Step | Activated `i` | `value[i]` | Active Before | Active After | Becomes Inactive `j`   | Inactive Elements | Total |
| ---- | ------------- | ---------- | ------------- | ------------ | ---------------------- | ----------------- | ----- |
| 1    | 1             | 5          | 0             | 1            | `j = 1` (limit[1] = 1) | [1]               | 5     |
| 2    | 0             | 3          | 0             | 1            | -                      | [1]               | 8     |
| 3    | 2             | 8          | 1             | 2            | `j = 0` (limit[0] = 2) | [0, 1]            | 16    |

Thus, the maximum possible total is **16**.

---

## Example 2

**Input**

```
value = [4, 2, 6]
limit = [1, 1, 1]
```

**Output**

```
6
```

**Explanation**

One optimal activation order:

| Step | Activated `i` | `value[i]` | Active Before | Active After | Becomes Inactive `j`         | Inactive Elements | Total |
| ---- | ------------- | ---------- | ------------- | ------------ | ---------------------------- | ----------------- | ----- |
| 1    | 2             | 6          | 0             | 1            | `j = 0, 1, 2` (limit[j] = 1) | [0, 1, 2]         | 6     |

Thus, the maximum possible total is **6**.

---

## Example 3

**Input**

```
value = [4, 1, 5, 2]
limit = [3, 3, 2, 3]
```

**Output**

```
12
```

**Explanation**

One optimal activation order:

| Step | Activated `i` | `value[i]` | Active Before | Active After | Becomes Inactive `j`         | Inactive Elements | Total |
| ---- | ------------- | ---------- | ------------- | ------------ | ---------------------------- | ----------------- | ----- |
| 1    | 2             | 5          | 0             | 1            | -                            | []                | 5     |
| 2    | 0             | 4          | 1             | 2            | `j = 2` (limit[2] = 2)       | [2]               | 9     |
| 3    | 1             | 1          | 1             | 2            | -                            | [2]               | 10    |
| 4    | 3             | 2          | 2             | 3            | `j = 0, 1, 3` (limit[j] = 3) | [0, 1, 2, 3]      | 12    |

Thus, the maximum possible total is **12**.

---

## Constraints

- `1 <= n == value.length == limit.length <= 10^5`
- `1 <= value[i] <= 10^5`
- `1 <= limit[i] <= n`

---

## Topics

`Array`
`Two Pointers`
`Greedy`
`Sorting`
`Heap (Priority Queue)`

---

## Contest

- **Weekly Contest 462**

---

## Companies

- Google
- Amazon
- Meta

---

## Hints

**Hint 1**  
Group the items by their `limit` values, as decisions for each limit are independent.

**Hint 2**  
For a group with `limit = j` and `m` items, its contribution is the sum of the top `min(j, m)` values.

**Hint 3**  
To extract each group's top values, use a **min-heap** of capacity `j`:  
push each `value[i]`, and whenever the heap size exceeds `j`, pop the smallest.

**Hint 4**  
After processing a group's heap, sum its elements and add to the overall total;  
repeat for all groups in any order.

---
