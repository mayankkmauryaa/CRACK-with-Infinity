# 1. Longest Common Subsequence

[Check Solution](#solution)

**Problem:**

The longest common subsequence (LCS) problem is to find the longest subsequence common to two given sequences. (Note that a subsequence is different from a substring, for the terms of the former need not be consecutive terms of the original sequence.)

Here the first sequence is infinite ie. length is not defined.
This sequence is
0, N, 2N, 3N, 4*N .........
for a given prime N.

Second sequence is defined as follows. It is of length K.
This sequence is C(K,1), C(K,2), C(K,3), C(K,4), ......... C(K,K).
C(n,k) is define as
You have the ability to arrange this sequence in any order you want to.

Print the longest common subsequence of two sequences, where second sequence can be modified in any order.

---

## Input Format

First line contains `T`, the number of testcases. Each testcase consists of two space seperated integers denoting `K` and `N`.

---

## Output Format

For each testcase, print the required answer modulo .

---

## Constraints

* $1 \le T \le 1000$
* $1 \le K \le 10^{18}$
* $1 \le N \le 10^9$
* `N` is prime.

---

### Example #1

**Input**

```
2
3 3
4 2

```

**Output**

```
1
2

```

**Explanation:**

**In First testcase** 
- `sequence1` = 0,3,6,9..... 
- `sequence2` = 1,3,3,1 
- `LCS(sequence1,sequence2)` = `1`

**In second testcase** 
- `sequence1` = 0,2,4,6,8,10.... 
- `sequence2` = 1,4,6,4,1 
- `LCS(sequence1,sequence2)` = `2`

---

## Solution

```java
import java.util.*;

class Main {
    static final long MOD = 1000000007;

    static long longestCommonSubsequence(long K, long N) {
        long totalElements = K % MOD;
        long nonMultiples = 1;
        long tempK = K;

        // Lucas's Theorem: A binomial coefficient C(K, i) is not divisible by prime N 
        // if and only if no digit of i in base N is greater than the corresponding digit of K.
        while (tempK > 0) {
            long digit = tempK % N;
            nonMultiples = (nonMultiples * (digit + 1)) % MOD;
            tempK /= N;
        }

        // Subtract 1 because the product includes C(K, 0), which is not in our sequence (i=1 to K)
        long validNonMultiples = (nonMultiples - 1 + MOD) % MOD;

        // LCS = Total elements - elements not divisible by N
        return (totalElements - validNonMultiples + MOD) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                long K = sc.nextLong();
                long N = sc.nextLong();
                System.out.println(longestCommonSubsequence(K, N));
            }
        }
        sc.close();
    }
}

```
