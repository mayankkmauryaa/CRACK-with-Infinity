# 2. Longest Common Prefix

[Check Solution](#solution)

**Problem:**

You are given a list of strings. Your task is to find the longest common prefix shared by all the strings.
If there is no common prefix, return an empty string "".

---

## Input Format

The first line contains a single integer NN, the number of strings.
The next NN lines each contain one string.

---

## Output Format

Print the longest common prefix among all strings.
If no common prefix exists, print an empty string "".

---

## Constraints

- 1 <= N <= 200
- 0 <= strs[i].length <= 200
- Each string contains only lowercase English letters (a-z).

### Example #1

**Input**

```
4
interview
internet
internal
interval

```

**Output**

```
inter

```

**Explanation:**

All strings start with "inter", which is the longest common prefix.

### Example #2

**Input**

```
3
apple
ape
april

```

**Output**

```
ap

```

**Explanation:**

All strings start with "ap" — that's the longest common prefix.

---

## Solution

```java
import java.util.*;

class Main {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        String[] strs = new String[N];
        scanner.nextLine(); // consume newline
        for (int i = 0; i < N; i++) {
            strs[i] = scanner.nextLine();
        }
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }
}
```
