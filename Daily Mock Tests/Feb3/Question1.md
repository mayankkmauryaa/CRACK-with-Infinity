# Problem 1: Count Divisible Numbers in a Range

[Check Solution](#solution)

## Problem Statement

You are given three integers **L**, **R**, and **K**.
Your task is to determine how many integers in the range **[L, R]** (both inclusive) are **divisible by K**.

---

## Input Format

- A single line containing **three space-separated integers**:

  ```
  L R K
  ```

---

## Output Format

- Print a **single integer** — the count of numbers between **L** and **R** (inclusive) that are divisible by **K**.

---

## Constraints

`1
≤
𝐿
≤
𝑅
≤
10^18`

`1
≤
𝐾
≤
10^9`

---

## Notes

- Your solution should be optimized for large values of **L** and **R**.
- Iterating through all numbers in the range may lead to **Time Limit Exceeded (TLE)**.

---

## Sample Test Cases

### Test Case 1

**Input**

```
1 10 2
```

**Output**

```
5
```

**Explanation**
Numbers divisible by 2 are: `2, 4, 6, 8, 10`.

---

### Test Case 2

**Input**

```
5 25 5
```

**Output**

```
5
```

**Explanation**
Numbers divisible by 5 are: `5, 10, 15, 20, 25`.

---

### Test Case 3

**Input**

```
10 10 3
```

**Output**

```
0
```

**Explanation**
No number in the range is divisible by 3.

---

### Test Case 4

**Input**

```
1 1000000000000 1
```

**Output**

```
1000000000000
```

**Explanation**
Every number is divisible by 1.

---

### Test Case 5 (Edge Case)

**Input**

```
7 7 7
```

**Output**

```
1
```

---

## Expected Time Complexity

- **O(1)** per test case

---

## Hint (Optional)

The number of integers divisible by **K** in range **[L, R]** can be computed using integer division.

---

## Solution

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (i % k == 0)
                count++;
        }
        System.out.println(count);
        sc.close();
    }
}
```
