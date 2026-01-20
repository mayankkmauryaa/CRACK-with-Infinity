# Cookie Distribution for Maximum Content Children

## Problem Statement

You are a caregiver at a community center organizing a cookie distribution event for children.
Each child has a **greed factor**, which represents the minimum cookie size required for that child to be content.

You also have a collection of cookies, each with a specific size. The distribution must follow these rules:

- Each child can receive **at most one cookie**
- Each cookie can be given to **only one child**
- A child is content only if the cookie size is **greater than or equal to** their greed factor

Your goal is to **maximize the number of content children** using an efficient **greedy approach**.

---

## Input

- `g`: an array representing the greed factors of the children
- `s`: an array representing the sizes of available cookies

---

## Output

- Return the **maximum number of children** that can be made content.

---

## Examples

### Example 1

**Input:**

```
g = [1,2,3]
s = [1,1]
```

**Output:**

```
1
```

**Explanation:**
There are 3 children and 2 cookies, both of size 1.
Only the child with greed factor 1 can be satisfied.

---

### Example 2

**Input:**

```
g = [1,2]
s = [1,2,3]
```

**Output:**

```
2
```

**Explanation:**
There are enough cookies with sufficient sizes to satisfy both children.

---

## Additional Test Cases

### Input 0

```
g = [1,2,4,5]
s = [1,2,3]
```

**Output:**

```
2
```

---

### Input 1

```
g = [1,2,4,5]
s = [1,2,4]
```

**Output:**

```
3
```

---

### Input 2

```
g = [2,5,7]
s = [2,3,5,7]
```

**Output:**

```
3
```

---

### Input 3

```
g = [2,5,7,8,1]
s = [2,3]
```

**Output:**

```
2
```

---

### Input 4

```
g = [1,1,1,2]
s = [1,2]
```

**Output:**

```
2
```

---

## Constraints

- `1 <= g.length <= 3 * 10^4`
- `0 <= s.length <= 3 * 10^4`
- `1 <= g[i], s[j] <= 2^31 - 1`

---

## Greedy Strategy

- Sort both `g` (greed factors) and `s` (cookie sizes)
- Assign the smallest available cookie that can satisfy the least greedy child
- Move forward greedily to maximize the number of satisfied children

---

## Topics

`Greedy`
`Sorting`
`Two Pointers`
