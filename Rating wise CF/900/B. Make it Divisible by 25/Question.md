# B. Make it Divisible by 25


[**Codeforces Submission**](https://codeforces.com/contest/1593/submission/362250732)

[**Problem**](#problem-statement)

[**Brute Force**](#brute-force-approach)

[**Brute Force Solution**](#java-implementation-brute-force)

[**Optimal**](#optimal-approach-greedy-strategy)

[**Optimal Solution (Easy One)**](#java-implementation-optimal)

## [Problem Statement](https://codeforces.com/problemset/problem/1903/A)

It is given a positive integer `n`. In **1 move**, one can select any single digit and remove it (i.e. one selects some position in the number and removes the digit located at this position). The operation cannot be performed if only one digit remains. If the resulting number contains leading zeroes, they are automatically removed.

**For example:**

- If one removes from the number `32925` the 3rd digit, the resulting number will be `3225`.
- If one removes from the number `20099050` the first digit, the resulting number will be `99050` (the 2 zeroes going next to the first digit are automatically removed).

**Question:** What is the minimum number of steps to get a number such that it is **divisible by 25** and **positive**?

> It is guaranteed that, for each `n` occurring in the input, the answer exists. It is guaranteed that the number `n` has no leading zeros.

---

## Time & Memory Limits

- **Time limit per test:** `1 second`
- **Memory limit per test:** `256 megabytes`

---

## Input Format

The first line contains one integer `t` (`1 ≤ t ≤ 10⁴`) — the number of test cases. Then `t` test cases follow.

Each test case consists of one line containing one integer `n` (`25 ≤ n ≤ 10¹⁸`). It is guaranteed that, for each `n` occurring in the input, the answer exists. It is guaranteed that the number `n` has no leading zeros.

---

## Output Format

For each test case output on a separate line an integer `k` (`k ≥ 0`) — the minimum number of steps to get a number such that it is divisible by `25` and positive.

---

## Examples

### **Input:**

```
5
100
71345
3259
50555
2050047
```

### **Output:**

```
0
3
1
3
2
```

---

## Explanation

- **Test case 1:** The number `100` is already divisible by 25. **0 steps** needed.
- **Test case 2:** Remove digits `1`, `3`, and `4` to get the number `75`. **3 steps** needed.
- **Test case 3:** Remove the last digit to get the number `325`. **1 step** needed.
- **Test case 4:** Remove the three last digits to get the number `50`. **3 steps** needed.
- **Test case 5:** Remove digits `4` and `7` to get a number divisible by 25. **2 steps** needed.

---

## Problem Tags

- **Math** - Divisibility rules and number theory
- **Greedy** - Finding optimal solution by making locally optimal choices
- **String Manipulation** - Working with digit sequences
- **Implementation** - Direct algorithmic approach

---

## Key Insight

A number is **divisible by 25** if and only if it ends with one of these **two-digit combinations**:

- `00`
- `25`
- `50`
- `75`

The problem reduces to finding the **minimum number of digit removals** needed to make the number end with any of these valid combinations.

---

## Approach Overview

### Brute Force Approach

**The Simple Idea:** Let's just try everything! We'll remove digits in every possible way until we find a number that's divisible by 25.

**How would a human do this:**

1. Start with the original number - is it divisible by 25? If yes, we're done!
2. Try removing 1 digit at each position and check each result
3. Try removing 2 digits in all possible combinations and check each result
4. Keep going until we find something that works

**The Algorithm:**

```
For each number:
  If it's already divisible by 25 → answer is 0

  Try removing 1 digit:
    For each position, remove that digit and check if result is divisible by 25

  Try removing 2 digits:
    For each pair of positions, remove both digits and check

  Continue until we find the answer
```

**The Problem with this approach:**

- For a 19-digit number, there are 2^19 = 524,288 different combinations!
- That's way too many possibilities to check in just 1 second

**Complexity:**

- Time: `O(2^n × n)` - exponential growth (really bad!)
- Space: `O(n)` - not too bad, just need to store the current number

**Bottom Line:** This works but is too slow for the actual problem constraints. It's great for understanding the problem though!

---

## Complexity Analysis

**Our Brute Force Approach:**

- **Time Complexity:** `O(2^n × n)` - exponential because we try every possible combination
- **Space Complexity:** `O(n)` - just need to store the current number we're working with

**Why this won't work for the actual problem:**

- `n` can be up to 19 digits
- `2^19 = 524,288` combinations to check
- With `t = 10,000` test cases, that's way too many operations for 1 second!

**But it's perfect for:**

- Understanding the problem
- Testing with small inputs
- Learning how the problem works before optimizing

---

## Java Implementation (Brute Force)

Here's how we'd implement the brute force approach in Java. It's simple and easy to understand, even though it's not the fastest:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            String n = scanner.next();
            System.out.println(minimumRemovalsBruteForce(n));
        }

        scanner.close();
    }


    public static int minimumRemovalsBruteForce(String n) {

        if (isDivisibleBy25(n)) {
            return 0;
        }


        for (int k = 1; k < n.length(); k++) {

            java.util.List<String> combinations = removeKDigits(n, k);


            for (String candidate : combinations) {
                if (isDivisibleBy25(candidate)) {
                    return k;
                }
            }
        }


        return n.length() - 1;
    }


    public static boolean isDivisibleBy25(String num) {
        if (num.isEmpty()) return false;


        int i = 0;
        while (i < num.length() && num.charAt(i) == '0') {
            i++;
        }

        if (i == num.length()) return false;

        String cleanNum = num.substring(i);


        try {
            long value = Long.parseLong(cleanNum);
            return value > 0 && value % 25 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static java.util.List<String> removeKDigits(String num, int k) {
        java.util.List<String> result = new java.util.ArrayList<>();
        removeKDigitsHelper(num, k, 0, new StringBuilder(), result);
        return result;
    }

    private static void removeKDigitsHelper(String num, int k, int index,
                                          StringBuilder current, java.util.List<String> result) {

        if (k == 0) {

            while (index < num.length()) {
                current.append(num.charAt(index));
                index++;
            }
            result.add(current.toString());
            return;
        }


        if (index >= num.length()) {
            return;
        }


        removeKDigitsHelper(num, k - 1, index + 1, current, result);


        current.append(num.charAt(index));
        removeKDigitsHelper(num, k, index + 1, current, result);

        current.deleteCharAt(current.length() - 1);
    }
}
```

### How this code works:

1. **`main` method**: Reads input and calls our brute force function for each test case
2. **`minimumRemovalsBruteForce`**: Tries removing 1 digit, then 2 digits, etc., until success
3. **`isDivisibleBy25`**: Checks if a number is divisible by 25 (handles leading zeros)
4. **`removeKDigits`**: Generates all possible combinations by removing exactly k digits using recursion

### What makes this "human-friendly":

- Clear method names that explain what they do
- Lots of comments explaining each step
- Breaks the problem into small, understandable pieces
- Handles edge cases like leading zeros properly

### Why this won't pass the actual test:

- For `n = 19`, it tries up to `C(19,9) = 92378` combinations just for k=9!
- With 10,000 test cases, this would take way too long

But it's perfect for learning and understanding the problem! 🎯

---

## Conclusion

The brute force approach is straightforward to implement and understand, making it great for learning how the problem works. However, its exponential time complexity makes it impractical for the actual problem constraints. This implementation serves as a foundation before moving on to more efficient approaches.

---

## Optimal Approach (Greedy Strategy)

**Key Insight:** A number is divisible by 25 if and only if it ends with: `00`, `25`, `50`, or `75`.

**Algorithm:**

1. Try all four possible endings: `00`, `25`, `50`, `75`
2. For each ending:
   - Find the rightmost occurrence of the second digit
   - Find the rightmost occurrence of the first digit before the second digit
   - Calculate removals needed: `(digits after second digit) + (digits between the two digits)`
3. Return the minimum removals across all valid endings

**Complexity:**

- Time: `O(n)` - linear scan for each of the 4 targets
- Space: `O(1)` - constant extra space

---

## Java Implementation (Optimal)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            String n = scanner.next();

            String[] targets = {"00", "25", "50", "75"};
            int minRemovals = Integer.MAX_VALUE;

            for (String target : targets) {
                int pos2 = -1;
                for (int i = n.length() - 1; i >= 0; i--) {
                    if (n.charAt(i) == target.charAt(1)) {
                        pos2 = i;
                        break;
                    }
                }

                if (pos2 == -1) continue;

                int pos1 = -1;
                for (int i = pos2 - 1; i >= 0; i--) {
                    if (n.charAt(i) == target.charAt(0)) {
                        pos1 = i;
                        break;
                    }
                }

                if (pos1 == -1) continue;

                int removals = (n.length() - pos2 - 1) + (pos2 - pos1 - 1);
                minRemovals = Math.min(minRemovals, removals);
            }

            System.out.println(minRemovals);
        }

        scanner.close();
    }
}
```
