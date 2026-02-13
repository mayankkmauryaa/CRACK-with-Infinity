# Problem: Subset Sum (Print All Subsets)

[Check Solution](#solution)

## Problem Statement

You are given an array of **N integers** and an integer **K**.
Your task is to **print all subsets** of the given array whose **sum is equal to K**.

Each subset should be printed in **increasing order**, and the subsets should be printed in **lexicographical order**.

Duplicate subsets should **not** be printed.

---

## Input Format

- The first line contains an integer **N**.
- The second line contains an integer **K**.
- The third line contains **N space-separated integers**.

---

## Output Format

- Print all subsets whose sum is equal to **K**.
- Each subset should be printed on a **new line**.
- Elements of a subset should be separated by a **single space**.

---

## Constraints

`1 ≤ N ≤ 100`

`1 ≤ arr[i] ≤ 1000`

`1 ≤ K ≤ 10^5`

---

## Sample Test Cases

### Test Case 1

**Input**

```
5 4
1 1 2 3 4
```

**Output**

```
1 1 2
1 3
4
```

---

### Test Case 2

**Input**

```
3 5
2 3 5
```

**Output**

```
2 3
5
```

---

### Test Case 3

**Input**

```
3 7
1 2 3
```

**Output**

```
No subset found
```

---

## Expected Time Complexity

- **O(2^N)** in the worst case

---

## Solution

```java
import java.util.*;

class Main {

    static void findSubsets(int[] arr, int n, int k) {
        Arrays.sort(arr);
        backtrack(arr, n, k, 0, 0, new ArrayList<>());
    }

    static void backtrack(int[] arr, int n, int k, int idx, int sum, ArrayList<Integer> curr) {
        if (sum == k) {
            for (int x : curr) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        if (sum > k)
            return;

        for (int i = idx; i < n; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;

            curr.add(arr[i]);
            backtrack(arr, n, k, i + 1, sum + arr[i], curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findSubsets(arr, n, k);
        sc.close();
    }
}
```
