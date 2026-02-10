# 2. Longest Subarray

[Check Solution](#solution)

**Problem:**

Given a linked list containing N integers and an integer K.

Your task is to find the length of the longest sub list with sum of the elements equal to the given value k.

---

## Input Format

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains two integers N and K and the second line contains N space separated elements of the list.

---

## Output Format

For each test case, print the required length of the longest sub list in a new line. If no such sub array can be formed, print 0.

---

## Constraints

- $1 \leq N \leq 10^5$ (Number of elements in the array)
- $-10^9 \leq A[i] \leq 10^9$ (Array elements can be positive or negative integers)
- $-10^9 \leq K \leq 10^9$ (Target sum for the subarray)

---

## Example #1

**Input**

```
3
6 15
10 5 2 7 1 9
6 -5
-5 8 -14 2 4 12
3 6
1 2 3

```

**Output**

```
4
5
0

```

**Explanation:**

- In the first case, the subarray `{5, 2, 7, 1}` has a sum of 15 and length 4.
- In the second case, the subarray `{-5, 8, -14, 2, 4}` has a sum of -5 and length 5.
- In the third case, no subarray sums to 6, so 0 is printed.

---

## Solution

Since the array contains negative numbers, we use a Prefix Sum with a Hash Map to find the longest subarray in time.

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println(longestSublist(arr, n, k));
            }
        }
        sc.close();
    }

    public static int longestSublist(int[] arr, int n, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long currentSum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (currentSum == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(currentSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(currentSum - k));
            }

            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }
        return maxLen;
    }
}

```
