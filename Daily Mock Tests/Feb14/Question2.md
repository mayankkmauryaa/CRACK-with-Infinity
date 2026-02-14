# 2. Maximum Borders

[Check Solution](#solution)

**Problem:**

You are given a table with rows and columns. Each cell is colored with white or black. Considering the shapes created by black cells, what is the maximum border of these shapes? Border of a shape means the maximum number of consecutive black cells in any row or column without any white cell in between.

A shape is a set of connected cells. Two cells are connected if they share an edge. Note that no shape has a hole in it.

---

## Input Format

The first line contains an integer denoting the number of test cases.<br>
The first line of each test case contains integers denoting the number of rows () and columns () of the matrix.<br>
Here, `#` represents a black cell and `.` represents a white cell.<br>
Each of the next lines contains characters.

---

## Output Format

Print the maximum border of the shapes for each test case.

---

## Example #1

**Input**

```
10
2 15
.....####......
.....####......
7 9
.......#.
.......#.
.......#.
.......#.
.......#.
.......#.
.......#.
18 11
.##########.
.##########.
.####.......
.####.......
.####.......
.##########.
.##########.
.......####.
.......####.
.......####.
.##########.
.##########.
.####.......
.####.......
.####.......
.##########.
.##########.
...........
1 15
..........#####
5 11
..#####....
..#####....
..#####....
..#####....
..#####....
8 13
..........###
..........###
..........###
...#########.
...#########.
...#########.
..........###
..........###
1 1
#
1 1
.
14 2
..
#.
#.
..
#.
#.
#.
..
#.
#.
..
#.
#.
..
7 15
...............
.#############.
.#############.
.#############.
.#############.
.#############.
...............
12 6
.####.
.####.
.####.
.####.
..##..
..##..
..##..
..##..
.####.
.####.
.####.
.####.
```

**Output**

```
4
7
10
5
5
9
1
0
3
13
4
```

---

## Explanation

For the first test case, there are 4 consecutive `#` in the rows. Thus, the maximum border is 4.
For the second test case, there are 7 consecutive `#` in a single column. Thus, the maximum border is 7.

---

## Solution

```java
import java.util.*;

class Main {
    static void solve(int n, int m, String[] grid) {
        int maxBorder = 0;

        // Check Rows for consecutive '#'
        for (int i = 0; i < n; i++) {
            int currentCount = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '#') {
                    currentCount++;
                    maxBorder = Math.max(maxBorder, currentCount);
                } else {
                    currentCount = 0;
                }
            }
        }

        // Check Columns for consecutive '#'
        for (int j = 0; j < m; j++) {
            int currentCount = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i].charAt(j) == '#') {
                    currentCount++;
                    maxBorder = Math.max(maxBorder, currentCount);
                } else {
                    currentCount = 0;
                }
            }
        }

        System.out.println(maxBorder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] grid = new String[n];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next();
            }
            solve(n, m, grid);
        }
        sc.close();
    }
}

```
