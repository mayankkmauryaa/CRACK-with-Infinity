# Maximum Frequency Difference with Parity Constraint

## Problem Statement

A cybersecurity company analyzes network traffic logs represented as a string of characters.  
Each character (from `'0'` to `'4'`) denotes a type of signal or request.

For **any contiguous substring** of length **at least `k`**, analysts want to identify **two different characters** such that:

- One character appears an **odd** number of times in the substring
- The other character appears an **even** number of times in the substring

The goal is to compute the **maximum possible difference**:

(odd frequency) − (even frequency)

Return the maximum difference across all valid substrings.

This metric helps detect irregular traffic patterns or anomalies.

---

## Constraints

- `3 <= s.length <= 3 * 10^4`
- `s` consists only of characters `'0'` to `'4'`
- `1 <= k <= s.length`
- It is guaranteed that at least one valid substring exists

---

## Examples

### Example 1

**Input:**

```
s = "12233", k = 4
```

**Output:**

```
-1
```

**Explanation:**  
Substring `"12233"`:

- `'1'` occurs 1 time (odd)
- `'3'` occurs 2 times (even)

Difference = 1 − 2 = **-1**

---

### Example 2

**Input:**

```
s = "1122211", k = 3
```

**Output:**

```
1
```

**Explanation:**  
Substring `"11222"`:

- `'2'` occurs 3 times (odd)
- `'1'` occurs 2 times (even)

Difference = 3 − 2 = **1**

---

### Example 3

**Input:**

```
s = "110", k = 3
```

**Output:**

```
-1
```

---

## Additional Test Cases

### Input 0

```
s = "1223"
k = 4
```

**Output:**

```
-1
```

---

### Input 1

```
s = "1122211"
k = 4
```

**Output:**

```
1
```

---

### Input 2

```
s = "33222"
k = 4
```

**Output:**

```
1
```

---

### Input 3

```
s = "1112"
k = 2
```

**Output:**

```
-1
```

---

## Key Idea (Parity Optimization)

- Use a **sliding window** of size ≥ `k`
- Maintain frequency counts of characters (`0` to `4`)
- Track:
  - Maximum frequency among characters with **odd counts**
  - Minimum frequency among characters with **even counts**
- Compute and update the difference `(odd − even)`

This problem introduces **parity-based frequency optimization**, combining:

- Sliding Window
- Frequency Counting
- Parity (Odd / Even) Analysis

---

## Topics

`Sliding Window`  
`Frequency Array`  
`Parity Logic`  
`Optimization`
