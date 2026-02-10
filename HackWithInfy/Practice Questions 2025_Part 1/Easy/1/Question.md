# 1. EASY

You’re given an array **A** of **n** integers and **q** queries.
Each query can be one of the following two types:

- **Type 1 Query:** `(1, l, r)`
  Replace `A[i]` with
  `(i-l+1)*A[l]` for each index `i`, where `l <= i <= r`.

- **Type 2 Query:** `(2, l, r)`
  Calculate the sum of the elements in `A` from index `l` to index `r`.

Find the sum of answers to all type 2 queries. Since answer can be large, return it modulo `10^9+7`.

---

[Solution](#solution)

---

## Sample Input 1

```

7
1
4
5
1
6
7
8
5
1 1 6
1 1 5
2 5 5
2 3 4
2 3 3
```

## Sample Output 1

```

60
```

## Sample Output Description 1

Here, `n = 7`
`A = [1, 4, 5, 1, 6, 7, 8]`
`q = 5`
`queries = [[1, 1, 6], [1, 1, 5], [2, 5, 5], [2, 3, 4], [2, 3, 3]]`

- for query 1 -> `(1, 1, 6)`
  Applying the operation on subarray from index 1 to 6,
  `A` becomes, `A = [1, 4, 8, 12, 16, 20, 24]`

- for query 2 -> `(1, 1, 5)`
  Applying the operation on subarray from index 1 to 5,
  `A` becomes, `A = [1, 4, 8, 12, 16, 20, 24]`

- for query 3 -> `(2, 5, 5)`
  calculate sum of array from index 5 to 5 -> sum =
  `A[5] = 20`

- for query 4 -> `(2, 3, 4)`
  calculate sum of array from index 3 to 4 -> sum =
  `A[3]+A[4] = 28`

- for query 5 -> `(2, 3, 3)`
  calculate sum of array from index 3 to 3 -> sum =
  `A[3] = 12`

Hence, answer is `20+28+12 = 60`

---

## Sample Input 2

```

7
3
7
4
2
5
3
7
5
1 0 4
2 0 1
1 3 6
2 3 3
2 0 5
```

## Sample Output 2

```

111
```

## Sample Output Description 2

Here, `n = 7`
`A = [3, 7, 4, 2, 5, 3, 7]`
`q = 5`
`queries = [[1, 0, 4], [2, 0, 1], [1, 3, 6], [2, 3, 3], [2, 0, 5]]`

- for query 1 -> `(1, 0, 4)`
  Applying the operation on subarray from index 0 to 4,
  `A` becomes, `A = [3, 6, 9, 12, 15, 3, 7]`

- for query 2 -> `(2, 0, 1)`
  calculate sum of array from index 0 to 1 -> sum =
  `A[0]+A[1] = 9`

- for query 3 -> `(1, 3, 6)`
  Applying the operation on subarray from index 3 to 6,
  `A` becomes, `A = [3, 6, 9, 12, 24, 36, 48]`

External Document © 2025 Infosys Limited

- for query 4 -> `(2, 3, 3)`
  calculate sum of array from index 3 to 3 -> sum =
  `A[3] = 12`

- for query 5 -> `(2, 0, 5)`
  calculate sum of array from index 0 to 5 -> sum =
  `A[0]+A[1]+A[2]+A[3]+A[4]+A[5] = 90`

Hence, answer is `9+12+90 = 111`

---

## Sample Input 3

```
7
1
8
6
10
5
6
9
5
2 0 3
1 2 3
1 0 6
2 1 4
2 6 6
```

## Sample Output 3

```

46
```

## Sample Output Description 3

Here, `n = 7`
`A = [1, 8, 6, 10, 5, 6, 9]`
`q = 5`
`queries = [[2, 0, 3], [1, 2, 3], [1, 0, 6], [2, 1, 4], [2, 6, 6]]`

- for query 1 -> `(2, 0, 3)`
  calculate sum of array from index 0 to 3 -> sum =
  `A[0]+A[1]+A[2]+A[3] = 25`

- for query 2 -> `(1, 2, 3)`
  Applying the operation on subarray from index 2 to 3,
  `A` becomes, `A = [1, 8, 6, 12, 5, 6, 9]`

- for query 3 -> `(1, 0, 6)`
  Applying the operation on subarray from index 0 to 6,
  `A` becomes, `A = [1, 2, 3, 4, 5, 6, 7]`

- for query 4 -> `(2, 1, 4)`
  calculate sum of array from index 1 to 4 -> sum = `14`

- for query 5 -> `(2, 6, 6)`
  calculate sum of array from index 6 to 6 -> sum = `7`

Hence, answer is `25+14+7 = 46`

---

## Input Format

- The first line contains an integer, `n`, denoting the number of elements in `A`.
- Each line `i` of the `n` subsequent lines (where `0 ≤ i < n`) contains an integer describing `A[i]`.
- The next line contains an integer, `q`, denoting the number of rows in queries.
- Each line `i` of the `q` subsequent lines (where `0 ≤ i < q`) contains 3 space separated integers each describing the row `queries[i]`.
- The 3 space separated integers denote the value of either `(1,l,r)` or `(2,l,r)` for the `i`-th query.

---

## Constraints

- `1 <= n <= 10^5`
- `1 <= A[i] <= 10^5`
- `1 <= q <= 10^5`
- `0 <= queries[i][j] <= 10^5`

---

## Sample Test Cases

### Case 1

**Input:**

```

7
1
4
5
1
6
7
8
5
1 1 6
1 1 5
2 5 5
2 3 4
2 3 3
```

**Output:**

```F

60
```

**Explanation:**

Here, `n = 7`

External Document © 2025 Infosys Limited

`A = [1, 4, 5, 1, 6, 7, 8]`
`q = 5`
`queries = [[1, 1, 6], [1, 1, 5], [2, 5, 5], [2, 3, 4], [2, 3, 3]]`

- for query 1 -> `(1, 1, 6)`
  Applying the operation on subarray from index 1 to 6,
  `A` becomes, `A = [1, 4, 8, 12, 16, 20, 24]`

- for query 2 -> `(1, 1, 5)`
  Applying the operation on subarray from index 1 to 5,
  `A` becomes, `A = [1, 4, 8, 12, 16, 20, 24]`

- for query 3 -> `(2, 5, 5)`
  calculate sum of array from index 5 to 5 -> sum =
  `A[5] = 20`

- for query 4 -> `(2, 3, 4)`
  calculate sum of array from index 3 to 4 -> sum =
  `A[3]+A[4] = 28`

- for query 5 -> `(2, 3, 3)`
  calculate sum of array from index 3 to 3 -> sum =
  `A[3] = 12`

Hence, answer is `20+28+12 = 60`

---

### Case 2

**Input:**

```

7
3
7
4
2
5
3
7
5
1 0 4
2 0 1
1 3 6
2 3 3
2 0 5
```

**Output:**

```

111
```

**Explanation:**

Here, `n = 7`
`A = [3, 7, 4, 2, 5, 3, 7]`
`q = 5`
`queries = [[1, 0, 4], [2, 0, 1], [1, 3, 6], [2, 3, 3], [2, 0, 5]]`

- for query 1 -> `(1, 0, 4)`
  Applying the operation on subarray from index 0 to 4,
  `A` becomes, `A = [3, 6, 9, 12, 15, 3, 7]`

- for query 2 -> `(2, 0, 1)`
  calculate sum of array from index 0 to 1 -> sum =
  `A[0]+A[1] = 9`

- for query 3 -> `(1, 3, 6)`
  Applying the operation on subarray from index 3 to 6,
  `A` becomes, `A = [3, 6, 9, 12, 24, 36, 48]`

- for query 4 -> `(2, 3, 3)`
  calculate sum of array from index 3 to 3 -> sum =
  `A[3] = 12`

- for query 5 -> `(2, 0, 5)`
  calculate sum of array from index 0 to 5 -> sum =
  `A[0]+A[1]+A[2]+A[3]+A[4]+A[5] = 90`

Hence, answer is `9+12+90 = 111`

---

### Case 3

**Input:**

```

7
1
8
6
10
5
6
9
5
2 0 3
1 2 3
1 0 6
2 1 4
2 6 6
```

**Output:**

```

46
```

**Explanation:**
Here, `n = 7`
`A = [1, 8, 6, 10, 5, 6, 9]`
`q = 5`
`queries = [[2, 0, 3], [1, 2, 3], [1, 0, 6], [2, 1, 4], [2, 6, 6]]`

- for query 1 -> `(2, 0, 3)`
  calculate sum of array from index 0 to 3 -> sum =
  `A[0]+A[1]+A[2]+A[3] = 1+8+6+10 = 25`

- for query 2 -> `(1, 2, 3)`
  Applying the operation on subarray from index 2 to 3,
  `A` becomes, `A = [1, 8, 6, 12, 5, 6, 9]`

- for query 3 -> `(1, 0, 6)`
  Applying the operation on subarray from index 0 to 6,
  `A` becomes, `A = [1, 2, 3, 4, 5, 6, 7]`

- for query 4 -> `(2, 1, 4)`
  calculate sum of array from index 1 to 4 -> sum =
  `A[1]+A[2]+A[3]+A[4] = 2+3+4+5 = 14`

- for query 5 -> `(2, 6, 6)`
  calculate sum of array from index 6 to 6 -> sum =
  `A[6] = 7`

Hence, answer is `25+14+7 = 46`

## Solution

```java
import java.util.Scanner;

public class Solution {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        long total = 0;

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            if (type == 1) {
                long base = arr[left];
                for (int j = left; j <= right; j++) {
                    arr[j] = (j - left + 1) * base;
                }
            } else {
                long sum = 0;
                for (int j = left; j <= right; j++) {
                    sum = (sum + arr[j]) % MOD;
                }
                total = (total + sum) % MOD;
            }
        }

        System.out.println(total);
    }
}
```
