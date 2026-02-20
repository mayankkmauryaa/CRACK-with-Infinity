# 3. N-Queens Problem

[Check Solution](#solution)

**Problem:**

Given a chess board having  cells, you need to place  queens on the board in such a way that no queen attacks any other queen.

---

## Input Format

The only line of input consists of a single integer denoting .

---

## Output Format

If it is possible to place all the  queens in such a way that no queen attacks another queen, then print  lines having  integers. The integer in line and column will denote the cell  of the board and should be  if a queen is placed at  otherwise . If there are more than one way of placing queens print any of them. If it is not possible to place all  queens in the desired way, then print "Not possible" (without quotes).

---

## Constraints

* $1 \le N \le 10$

---

### Example #1

**Input**

```
4
```

**Output**

```
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0

```

**Explanation:**

In the given output for , no two queens are in the same row, column, or diagonal, satisfying the condition that no queen attacks another.

---

## Solution

```java
import java.util.Scanner;

public class Main {
    public static void placeQueens(int n) {
        int[][] board = new int[n][n];
        if (solve(board, 0, n)) {
            printBoard(board, n);
        } else {
            System.out.println("Not possible");
        }
    }

    private static boolean solve(int[][] board, int row, int n) {
        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solve(board, row + 1, n)) return true;

                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            placeQueens(n);
        }
        scanner.close();
    }
}

```