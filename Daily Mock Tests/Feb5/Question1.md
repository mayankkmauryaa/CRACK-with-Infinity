# 1. Fibonacci Series

[Check Solution](#solution)

**Problem:**

Alice and Bob are playing a number game.

Alice writes down the number 0.<br>
Bob writes down the number 1.<br>
After that, they take turns writing numbers.

Each new number written in the game is the sum of the previous two numbers written.<br>
This process continues until a total of N numbers are written.

Your task is to help Alice and Bob find the N-th number written in the game.

---

## Input Format

A single integer N, representing the position of the number to be found.

---

## Output Format

Print the N-th number in Alice and Bob's number game.

---

## Constraints

### Example #1

**Input**

```
13

```

**Output**

```
144

```

**Explanation:**

The numbers written by Alice and Bob are:<br>
0 1 1 2 3 5 8 13 21 34 55 89 144<br>
The 13th number is 144, which is printed as the output.

---

## Solution

To handle without integer overflow or time limits, we use `BigInteger` with a tail-recursive approach.

```java
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static BigInteger find(int n) {
        return helper(n, BigInteger.ZERO, BigInteger.ONE);
    }

    private static BigInteger helper(int n, BigInteger a, BigInteger b) {
        if (n == 1) {
            return a;
        }
        return helper(n - 1, b, a.add(b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(find(n));
        }
        sc.close();
    }
}

```
