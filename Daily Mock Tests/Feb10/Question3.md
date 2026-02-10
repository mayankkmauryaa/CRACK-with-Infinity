# 2. Prime Numbers Again

[Check Solution](#solution)

## **Problem:**

Panda can do any problem anytime and anywhere. Panda is doing an extensive research on prime numbers.

Milind has got a question for Panda. The only way for Panda to impress Milind is by solving this question.

Given a number `N`, find the minimum number of primatic numbers which sum upto `N`.

A primatic number refers to a number which is either a prime number or can be expressed as power of prime number to itself (i.e. prime^prime, e.g. 4, 27, etc).

**Note:** 8, 32, etc are not primatic numbers.

Panda is very sad since he is unable to solve the problem. Please help Panda in solving this problem.

---

## Input Format

The first line will contain two integers: `T`, the number of test cases.
Each test case consists of a single integer `N`.

---

## Output Format

For each query output the minimum number of primatic numbers which can sum upto `N`.

---

## Constraints

`1 ≤ T ≤ 10^5`
`2 ≤ N ≤ 10^4`

---

## Input

```

2
6
3

```

---

## Output

```

2
1

```

## Explaination

```

```

## Solution

```java

import java.util.*;

class Main {

    static final int MAX = 10000;
    static boolean[] isPrime = new boolean[MAX + 1];
    static Set<Integer> primatic = new HashSet<>();

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static void buildPrimatic() {
        // all primes
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primatic.add(i);

                // prime^prime
                long val = 1;
                for (int p = 0; p < i; p++) {
                    val *= i;
                    if (val > MAX)
                        break;
                }
                if (val <= MAX) {
                    primatic.add((int) val);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sieve();
        buildPrimatic();

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();

            if (primatic.contains(N)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}
```