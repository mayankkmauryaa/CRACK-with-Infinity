# [2030. Smallest K-Length Subsequence With Occurrences of a Letter](https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/description/)

## Problem Statement

You are given a string `s`, an integer `k`, a letter `letter`, and an integer `repetition`.

Return the **lexicographically smallest subsequence** of `s` of length `k` such that the letter `letter` appears **at least `repetition` times**.

The test cases are generated so that `letter` appears in `s` **at least `repetition` times**.

A **subsequence** is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

A string `a` is **lexicographically smaller** than a string `b` if, in the first position where they differ, `a` has a character that appears earlier in the alphabet than the corresponding character in `b`.

---

## Example 1

**Input**

```
s = "leet", k = 3, letter = "e", repetition = 1
```

**Output**

```
"eet"
```

**Explanation**

There are four subsequences of length `3` that have the letter `'e'` appear at least once:

- `"lee"` (from `lee`t)
- `"let"` (from `le`e`t`)
- `"let"` (from `l`e`et`)
- `"eet"` (from `l`eet`)

The lexicographically smallest subsequence among them is `"eet"`.

---

## Example 2

**Input**

```
s = "leetcode", k = 4, letter = "e", repetition = 2
```

**Output**

```
"ecde"
```

**Explanation**

`"ecde"` is the lexicographically smallest subsequence of length `4` that has the letter `"e"` appear at least `2` times.

---

## Example 3

**Input**

```
s = "bb", k = 2, letter = "b", repetition = 2
```

**Output**

```
"bb"
```

**Explanation**

`"bb"` is the only subsequence of length `2` that has the letter `"b"` appear at least `2` times.

---

## Constraints

- `1 <= repetition <= k <= s.length <= 5 * 10^4`
- `s` consists of lowercase English letters
- `letter` is a lowercase English letter and appears in `s` at least `repetition` times

---

## Topics

`String`
`Stack`
`Greedy`
`Monotonic Stack`

---

## Contest

- **Weekly Contest 261**

---

## Companies

- Google
- Amazon
- Meta

---

## Hints

**Hint 1**  
Use a stack. For every character to be appended, decide how many characters from the stack need to be popped based on the current stack length and the remaining count of the required character.

**Hint 2**  
Pop the extra characters out from the stack and return the characters remaining in the stack (in order).

---

## Similar Questions

- **Remove Duplicate Letters** — Medium
- **Subarray With Elements Greater Than Varying Threshold** — Hard
- **Find the Lexicographically Smallest Valid Sequence** — Medium

---
