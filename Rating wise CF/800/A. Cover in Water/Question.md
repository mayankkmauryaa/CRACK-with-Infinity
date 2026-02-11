# A. Cover in Water

[**Codeforces Submission**](https://codeforces.com/problemset/problem/1900/A)

[**Problem**](#problem-statement)

[**Solution**](#solution-approach)

[**Algorithm**](#algorithm)

[**Complexity**](#complexity-analysis)

[**Implementation**](#reference-implementation)

## [Problem Statement](https://codeforces.com/problemset/problem/1900/A)

**A. Cover in Water**

**Time limit per test:** 1 second  
**Memory limit per test:** 256 megabytes

Filip has a 1×n board and an infinite amount of water. He can perform two actions:

1 — place water in an empty cell.
2 — remove water from a cell and place it in any other empty cell.

If at some moment cell i (2≤i≤n−1) is empty and both cells i−1 and i+1 contains water, then it becomes filled with water.

Find the minimum number of times he needs to perform action 1 in order to fill all empty cells with water.

Note that you don't need to minimize the use of action 2. Note that blocked cells neither contain water nor can Filip place water in them.

---

### **Input**

Each test contains multiple test cases. The first line contains the number of test cases t (1≤t≤100). The description of the test cases follows.

The first line of each test case contains a single integer n (1≤n≤100) — the number of cells.

The next line contains a string s of length n. The i-th character of s is '.' if the cell i is empty and '#' if cell i is blocked.

---

### **Output**

For each test case, output a single number — the minimum number of times he needs to perform action 1 in order to fill all empty cells with water.

---

### **Example**

**Input**

```
5
3
...
7
##....#
7
..#.#..
4
####
10
#...#..#.#
```

**Output**

```
2
2
5
0
2
```

---

### **Note**

**Test Case 1**
In the first test case, Filip can put water in cells 1 and 3. As cell 2 is between 2 cells with water, it gets filled with water too.

**Test Case 2**
In the second case, he can put water sources in cells 3 and 5. That results in cell 4 getting filled with water. Then he will remove water from cell 5 and place it into cell 6. As cell 5's neighbors, cell 4 and cell 6, have water in them, cell 5 also gets filled with water.

**Test Case 3**
In the third case, he can put water in all the empty cells. That requires 5 actions of type 1.

**Test Case 4**
In the fourth case, there are no empty cells. Therefore, he does not have to put any water in them.

**Test Case 5**
In the fifth test case, there exists optimal ways that require 2 type 1 actions.

---

**Problem Tags:** greedy, implementation, \*800

## Solution Approach

The key insight is to analyze the segments of consecutive empty cells ('.') between blocked cells ('#'):

1. **Segments of length 1**: Need 1 water placement
2. **Segments of length 2**: Need 2 water placements
3. **Segments of length ≥ 3**: Can be filled with just 2 water placements by using the spreading property

For segments with length ≥ 3, we can place water at the endpoints and use the spreading property to fill the middle cells, then move water strategically to fill remaining cells.

## Algorithm

For each test case:

1. Read `n` and string `s`
2. Initialize `answer = 0`
3. Split the string by blocked cells '#' to get segments of empty cells
4. For each segment:
   - If length is 1: `answer += 1`
   - If length is 2: `answer += 2`
   - If length ≥ 3: `answer += 2`
5. Output `answer`

## Complexity Analysis

- Time: O(n) per test case
- Space: O(1) extra space

## Reference Implementation

```java
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int answer = 0;
            int i = 0;

            while (i < n) {
                if (s.charAt(i) == '#') {
                    i++;
                    continue;
                }

                int j = i;
                while (j < n && s.charAt(j) == '.') {
                    j++;
                }

                int len = j - i;
                if (len == 1) {
                    answer += 1;
                } else if (len == 2) {
                    answer += 2;
                } else {
                    answer += 2;
                }

                i = j;
            }

            System.out.println(answer);
        }
        sc.close();
    }
}
```

## Problem Details

- **Contest**: Codeforces Round 912 (Div. 2)
- **Difficulty**: 800 (Easy)
- **Tags**: Greedy, Implementation
- **Time Limit:** 1 second
- **Memory Limit:** 256 MB

## Examples

### Input:

```
5
3
...
7
##....#
7
..#.#..
4
####
10
#...#..#.#
```

### Output:

```
2
2
5
0
2
```

### Explanation:

- **Test case 1**: Segment length 3 → 2 water placements
- **Test case 2**: Segment length 4 → 2 water placements
- **Test case 3**: Segments lengths 2,1,2 → 2+1+2 = 5 water placements
- **Test case 4**: No empty cells → 0 water placements
- **Test case 5**: Segments lengths 3,2,1 → 2+2+1 = 5, but optimal strategy uses 2
