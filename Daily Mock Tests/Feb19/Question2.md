# 2. Maximum Subarray

[Check Solution](#solution)

**Problem:**

Given two arrays `AA` and `BB` of sizes `NN` and `MM` respectively. You can apply the following operation until the array `BB` is non-empty:

* Choose either the first or the last element of array `BB`.
* Insert the chosen element to either the front or the back of array `AA`.
* Delete the chosen element from array `BB`.

For example, let `A=[9,7]` and `B=[1,3,2]`. In one operation, we can choose either `X=1` or `X=2` (first or last element of array `BB`). We can insert `XX` in array `AA` and make it either `A=[X,9,7]` or `A=[9,7,X]`. The chosen `XX` is deleted from array `BB`. Thus, it will become either `B=[3,2]` (when chosen `XX` is `1`) or `B=[1,3]` (when chosen `XX` is 2).

Find the maximum sum of any subarray of the array `AA` that you can achieve after performing exactly `MM` operations.

**Note:** A subarray of an array is formed by deleting some (possibly zero) elements from the beginning of the array and some (possibly zero) elements from the end of the array. A subarray can be empty as well.

---

## Input Format

The first line of input will contain a single integer `TT`, denoting the number of test cases.
Each test case consists of 4 lines of input:

* The first line of each test case contains a single integer `NN`, the size of array `AA`.
* The next line contains `NN` space-separated integers, denoting elements of array `AA`.
* The third line of each test case contains a single integer `MM`, the size of array `BB`.
* The next line contains `MM` space-separated integers, denoting elements of array `BB`.

---

## Output Format

For each test case, output on a new line the maximum sum of any subarray of the array `AA` that you can achieve after performing exactly `MM` operations.

---

## Constraints

* $1 \le TT \le 10$
* $1 \le NN \le 10^5$
* $1 \le MM \le 10^5$
* $-10^8 \le AA_i, BB_i \le 10^8$

---

### Example #1

**Input**

```
3
5
3 26 -79 72 23
2
66 44
1
81
1
-97
5
10 -5 14 -20 4
3
-10 5 -2

```

**Output**

```
205
81
24

```

**Explanation:**

* **Test case 1:** After operations, array `AA` becomes `[3, 26, -79, 72, 23, 66, 44]` and the maximum sum subarray is `[72, 23, 66, 44]` having sum `72+23+66+44=205`.
* **Test case 2:** After operations, array `AA` becomes `[-97, 81]` and the maximum sum subarray is `[81]` having sum `81`.
* **Test case 3:** After operations, array `AA` becomes `[-10, 5, 10, -5, 14, -20, 4, -2]` and the maximum sum subarray is `[5, 10, -5, 14]` having sum `5+10-5+14=24`.

---

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int n = sc.nextInt();
                long[] a = new long[n];
                for (int i = 0; i < n; i++) a[i] = sc.nextLong();

                int m = sc.nextInt();
                long sumPositiveB = 0;
                for (int i = 0; i < m; i++) {
                    long val = sc.nextLong();
                    if (val > 0) sumPositiveB += val;
                }

                // Kadane's Algorithm to find Max Subarray Sum of AA
                long maxSoFar = Long.MIN_VALUE;
                long maxEndingHere = 0;
                long maxElementA = Long.MIN_VALUE;
                boolean hasPositive = false;

                for (int i = 0; i < n; i++) {
                    maxElementA = Math.max(maxElementA, a[i]);
                    if (a[i] >= 0) hasPositive = true;
                    
                    maxEndingHere += a[i];
                    if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
                    if (maxEndingHere < 0) maxEndingHere = 0;
                }

                if (!hasPositive) {
                    // If all elements in A are negative, we can either take 
                    // the best single element from A + positive B's, or just positive B's
                    System.out.println(Math.max(maxElementA + sumPositiveB, sumPositiveB));
                } else {
                    // Add all positive elements from B to the best subarray of A
                    System.out.println(maxSoFar + sumPositiveB);
                }
            }
        }
        sc.close();
    }
}

```