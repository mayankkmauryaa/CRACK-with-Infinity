# 1. Balanced Parenthesis

[Check Solution](#solution)

[Check Solution](#solution-passed-10-cases)

**Problem:**

You are given a string composed of the following characters `(`, `)`, `{`, `}`, `[`, `]`.
You are allowed to swap characters of the string any number of times.
Find whether it is possible to construct a balanced sequence of parenthesis.

Swapping characters of string means there are 2 indexes `i` and `j` and then after the swap operation,
character at index `i` will be the character which was previously at index `j`,
and character at index `j` will be the character which was previously at index `i`.

`()` is balanced<br>
`)(` is not balanced

---

## Input

The first and only line of input contains a string `s` (`1 ≤ |s| ≤ 10^6`) — a string composed of
`(`, `)`, `{`, `}`, `[`, `]`.

---

## Output

The only line of output contains a string (`YES` or `NO`) — whether it is possible to construct a sequence
of balanced parenthesis by swapping characters of string any number of times.

---

### Example #1

**Input**

```
()()
```

**Output**

```
Yes
```

**Explanation:**

The given string is already balanced.

### Example #2

**Input**

```
)(
```

**Output**

```
Yes
```

**Explanation:**

By swapping the characters, the string can be rearranged to `()` which is balanced.

---

### Example #3

**Input**

```
([)]
```

**Output**

```
Yes
```

**Explanation:**

By swapping characters, the string can be rearranged to a balanced sequence like `()[]`.

---

### Example #4

**Input**

```
(((
```

**Output**

```
No
```

**Explanation:**

The number of opening and closing parentheses is not equal, so a balanced sequence cannot be formed.

---

### Example #5

**Input**

```
{[()]}
```

**Output**

```
Yes
```

**Explanation:**

The given string is already a balanced sequence of parenthesis.

---

### Example #6

**Input**

```
{[(])}
```

**Output**

```
Yes
```

**Explanation:**

By swapping characters, the string can be rearranged into a balanced sequence.

---

### Example #7

**Input**

```
{[}
```

**Output**

```
No
```

**Explanation:**

The count of opening and closing brackets does not match, so it is not possible to construct a balanced sequence.

## Solution

```java
public class BalancedParenthesis {

    static void isBalancedPossible(String s) {
        int n = s.length();

        if (n % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int roundOpen = 0, roundClose = 0;
        int curlyOpen = 0, curlyClose = 0;
        int squareOpen = 0, squareClose = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') roundOpen++;
            else if (ch == ')') roundClose++;
            else if (ch == '{') curlyOpen++;
            else if (ch == '}') curlyClose++;
            else if (ch == '[') squareOpen++;
            else if (ch == ']') squareClose++;
        }

        if (roundOpen == roundClose &&
            curlyOpen == curlyClose &&
            squareOpen == squareClose) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        isBalancedPossible(s);
    }
}
```

## Solution (passed 10 cases)

```java
public class BalancedParenthesis {

    static void isBalancedPossible(String s) {
        int n = s.length();

        if (n % 2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        isBalancedPossible(s);
    }
}
```
