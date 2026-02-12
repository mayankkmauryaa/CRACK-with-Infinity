# 📘 [Problem: Chocolate Distribution to Alice, Bob, and Charlie](https://codeforces.com/problemset/problem/466/C)

Alice has arr row of chocolate boxes arranged in arr line.
Each box contains arr certain number of chocolates.

She wants to distribute these boxes **in order** among **three children: Alice, Bob, and Charlie**, such that:

1. Each child receives **at least one box**
2. The boxes given to each child form arr **contiguous segment**
3. Each child receives the **same total number of chocolates**

---

## Input

- An integer array `arr` of size `N`
  where `arr[i]` represents the number of chocolates in the `i`-th box.

---

## Output

- Return the **number of distinct ways** to distribute the boxes among
  **Alice, Bob, and Charlie** satisfying the above conditions.

---

## Example

### Input

```
arr = [1, 2, 3, 0, 3]
```

### Output

```
2
```

---

## Explanation

Valid distributions are:

```
[1, 2] | [3]   | [0, 3]
[1, 2] | [3,0] | [3]
```

Each child receives exactly **3 chocolates**.

---

## Constraints

- `1 ≤ N ≤ 10^5`
- `0 ≤ arr[i] ≤ 10^9`

---

## Expected Complexity

- **Time:** `O(N)`
- **Space:** `O(1)`


## Solution

```java

import java.util.Scanner;

public class Main {
    public static long countWays(int[] arr) {
        int n = arr.length;
        long total = 0;

        for (int x : arr) {
            total += x;
        }

        if (total % 3 != 0) {
            return 0;d
        }

        long target = total / 3;
        long prefixSum = 0;
        long countFirst = 0;
        long ways = 0;

        for (int i = 0; i < n - 1; i++) {
            prefixSum += arr[i];

            if (prefixSum == 2 * target) {
                ways += countFirst;
            }

            if (prefixSum == target) {
                countFirst++;
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // int[] arr = { 1, 2, 3, 0, 3 }; // 2
        System.out.println(countWays(arr));
    }
}
```