# Problem: Tower of HANOI ; Maximum Height Tower

You are given **N cylindrical discs**.
Each disc is described by two integers:

- **R** — radius of the disc
- **H** — height of the disc

You want to build a vertical tower by stacking some of these discs under the following conditions:

1. A disc can be placed on top of another disc **only if both its radius and its height are strictly smaller** than the disc below it.
2. Each disc can be used **at most once**.
3. The height of a tower is the **sum of the heights** of all discs used.

Your task is to determine the **maximum possible height** of the tower.

---

## Input Format

- The first line contains an integer **N** — the number of discs.
- The next **N** lines each contain two integers **R** and **H** representing the radius and height of a disc.

---

## Output Format

- Print a single integer — the **maximum achievable height** of the tower.

---

## Constraints

- `1 ≤ N ≤ 10³`
- `1 ≤ R, H ≤ 10⁴`

---

## Example 1

### Input

```
3
4 3
1 4
3 2
```

### Output

```
5
```

### Explanation

The optimal tower is:

```
(4,3) → (3,2)
```

Total height = `3 + 2 = 5`

---

## Example 2

### Input

```
5
5 6
4 3
1 2
7 5
3 4
```

### Output

```
12
```

### Explanation

The optimal tower is:

```
(5,6) → (3,4) → (1,2)
```

Total height = `6 + 4 + 2 = 12`

---

## Time and Space Complexity

- **Time Complexity:** `O(N²)`
- **Space Complexity:** `O(N)`

---

## Notes

- Discs must be stacked such that **both radius and height strictly decrease** from bottom to top.
- The discs do **not need to be used in the given order**.
- This problem can be solved using **Dynamic Programming** after sorting the discs.
