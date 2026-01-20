# Sum of Power of All Hero Teams

## Problem Statement

A gaming company is analyzing character performance in its latest strategy game. Each hero has a strength value represented by an integer. To simulate all possible battle scenarios, the game engine considers **all non-empty subsets (teams)** of heroes.

The **power of a team** is calculated using the formula:
`(maximum strength in the team)² × (minimum strength in the team)`
Your task is to compute the **total power of all possible non-empty subsets** of the given array of hero strengths.

Since the number of subsets and the resulting sum can be very large, return the result **modulo 10⁹ + 7**.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`

---

## Examples

### Example 1

**Input:**

```
nums = [2,1,4]
```

**Output:**

```
141
```

**Explanation:**

All non-empty subsets and their power values:

- `[2]` → 2² × 2 = 8
- `[1]` → 1² × 1 = 1
- `[4]` → 4² × 4 = 64
- `[2,1]` → 2² × 1 = 4
- `[2,4]` → 4² × 2 = 32
- `[1,4]` → 4² × 1 = 16
- `[2,1,4]` → 4² × 1 = 16

Sum = 8 + 1 + 64 + 4 + 32 + 16 + 16 = **141**

---

### Example 2

**Input:**

```
nums = [1,1,1]
```

**Output:**

```
7
```

**Explanation:**
There are 7 non-empty subsets.
Each subset has power = 1, so the total sum is 7.

---

## Additional Test Cases

### Input 0

```
1 4 8
```

**Output:**

```
977
```

---

### Input 1

```
3 4 2
```

**Output:**

```
229
```

---

### Input 2

```
3 4 2 1
```

**Output:**

```
316
```

---

### Input 3

```
1 2
```

**Output:**

```
13
```

---

## Key Idea

- Consider **all non-empty subsets**
- For each subset, determine:
- Maximum element
- Minimum element
- Compute power as: `(max² × min)`
- Accumulate the total sum modulo `10^9 + 7`

An optimized approach is required to handle large input sizes efficiently.

---

## Topics

`Array`
`Math`
`Combinatorics`
`Sorting`
