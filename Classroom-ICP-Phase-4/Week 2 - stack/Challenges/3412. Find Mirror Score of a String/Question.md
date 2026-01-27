# [3412. Find Mirror Score of a String](https://leetcode.com/problems/find-mirror-score-of-a-string/)

## Problem Statement

You are given a string `s`.

We define the **mirror** of a letter in the English alphabet as its corresponding letter when the alphabet is reversed.

- The mirror of `'a'` is `'z'`
- The mirror of `'b'` is `'y'`
- The mirror of `'y'` is `'b'`

Initially, all characters in the string `s` are **unmarked**.

You start with a score of `0` and perform the following process:

1. Iterate through the string from **left to right**.
2. At each index `i`, find the **closest unmarked index** `j` such that:
   - `j < i`
   - `s[j]` is the **mirror** of `s[i]`
3. If such an index `j` exists:
   - Mark both indices `i` and `j`
   - Add `(i - j)` to the score
4. If no such index exists, continue to the next index.

Return the **final score** after processing the entire string.

---

## Examples

### Example 1

**Input**

```
s = "aczzx"
```

**Output**

```
5
```

**Explanation**

Step-by-step process:

- `i = 0`: No valid `j`, skip
- `i = 1`: No valid `j`, skip
- `i = 2`: Closest valid `j = 0`
  - Mark indices `0` and `2`
  - Add `2 - 0 = 2` to score
- `i = 3`: No valid `j`, skip
- `i = 4`: Closest valid `j = 1`
  - Mark indices `1` and `4`
  - Add `4 - 1 = 3` to score

**Final Score**

```
2 + 3 = 5
```

---

### Example 2

**Input**

```
s = "abcdef"
```

**Output**

```
0
```

**Explanation**

For every index `i`, there is no index `j < i` such that `s[j]` is the mirror of `s[i]`.  
Therefore, no pairs are formed and the score remains `0`.

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists only of lowercase English letters

---

## Topics

`Hash Table`
`String`
`Stack`
`Simulation`

---

## Contest

- **Weekly Contest 431**

---

## Companies

> _This problem has appeared in interviews at major technology companies._

---

## Hints

### Hint 1

Create a **stack for each character** in the alphabet.

### Hint 2

For each index, check if the stack for mirror of the letter at that index is empty.

---

## Notes

- The problem is optimized using **stacks or hash maps of stacks**.
- Each character participates in at most one match.
- The algorithm runs in **O(n)** time with **O(n)** space.

---
