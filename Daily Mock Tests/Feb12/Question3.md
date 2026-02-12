# 3. Monk and Nice Strings

[Check Solution](#solution)

**Problem:**

Monk's best friend Micro's birthday is coming up. Micro likes Nice Strings very much, so Monk decided to gift him one. Monk is having nice strings, so he'll choose one from those. But before he selects one, he need to know the Niceness value of all of those.

Strings are arranged in an array , and the Niceness value of string at position is defined as the number of strings having position less than which are lexicographically smaller than .

Note: Array's index starts from 1.

---

## Input Format

- The first line consists of a single integer denoting .
- lines follow each containing a string made of lower case English alphabets.

---

## Output Format

Print lines, each containing an integer, where the integer in -th line denotes Niceness value of string .

---

## Constraints

- (Number of strings Monk has).
- (Length of each string is at most 10 characters).

---

## Example #1

**Input**

```
4
a
c
d
b

```

**Output**

```
0
1
2
1

```

**Explanation:**

- Number of strings having index less than 1 which are less than "a" = 0.
- Number of strings having index less than 2 which are less than "c": ("a") = 1.
- Number of strings having index less than 3 which are less than "d": ("a", "c") = 2.
- Number of strings having index less than 4 which are less than "b": ("a") = 1.

---

## Solution

Since is small (), we can use a nested loop approach () to compare each string with all previous strings in the array using the `compareTo` method.

```java
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            String[] arr = new String[n];

            // Read all strings into an array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }

            // Calculate Niceness value for each string
            for (int i = 0; i < n; i++) {
                int nicenessCount = 0;

                // Compare current string i with all strings at indices j < i
                for (int j = 0; j < i; j++) {
                    // compareTo returns < 0 if arr[j] is lexicographically smaller than arr[i]
                    if (arr[j].compareTo(arr[i]) < 0) {
                        nicenessCount++;
                    }
                }
                System.out.println(nicenessCount);
            }
        }
        sc.close();
    }
}

```
