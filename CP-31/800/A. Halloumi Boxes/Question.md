# A. Halloumi Boxes

[**Codeforces Submission**](https://codeforces.com/contest/1903/submission/362382964)

[**Problem**](#problem-statement)

[**Solution**](#solution-approach)

[**Algorithm**](#algorithm)

[**Complexity**](#complexity-analysis)

[**Implementation**](#reference-implementation)

## [Problem Statement](https://codeforces.com/problemset/problem/1903/A)

**A. Halloumi Boxes**

**Time limit per test:** 1 second  
**Memory limit per test:** 256 megabytes

Theofanis is busy after his last contest, as now, he has to deliver many halloumis all over the world. He stored them inside `n` boxes and each of which has some number `aᵢ` written on it.

He wants to sort them in non-decreasing order based on their number, however, his machine works in a strange way. It can only reverse any subarray† of boxes with length at most `k`.

Find if it's possible to sort the boxes using any number of reverses.

† Reversing a subarray means choosing two indices `i` and `j` (where `1 ≤ i ≤ j ≤ n`) and changing the array `a₁,a₂,…,aₙ` to `a₁,a₂,…,aᵢ₋₁,aⱼ,aⱼ₋₁,…,aᵢ,aⱼ₊₁,…,aₙ₋₁,aₙ`. The length of the subarray is then `j−i+1`.

---

### **Input**

The first line contains a single integer `t` (`1 ≤ t ≤ 100`) — the number of test cases.

Each test case consists of two lines.

The first line of each test case contains two integers `n` and `k` (`1 ≤ k ≤ n ≤ 100`) — the number of boxes and the length of the maximum reverse that Theofanis can make.

The second line contains `n` integers `a₁,a₂,…,aₙ` (`1 ≤ aᵢ ≤ 10⁹`) — the number written on each box.

---

### **Output**

For each test case, print `YES` (case-insensitive), if the array can be sorted in non-decreasing order, or `NO` (case-insensitive) otherwise.

---

### **Example**

**Input**

```
5
3 2
1 2 3
3 1
9 9 9
4 4
6 4 2 1
4 3
10 3 830 14
2 1
3 1
```

**Output**

```
YES
YES
YES
YES
NO
```

---

### **Note**

In the first two test cases, the boxes are already sorted in non-decreasing order.

In the third test case, we can reverse the whole array.

In the fourth test case, we can reverse the first two boxes and the last two boxes.

In the fifth test case, it can be shown that it's impossible to sort the boxes.

---

**Problem Tags:** brute force, greedy, sorting, \*800

## Solution Approach

The key observation is:

- **If `k = 1`**: We can't change anything (reversing a single element does nothing), so the array must already be sorted.
- **If `k ≥ 2`**: We can always sort the array. With `k = 2`, we can reverse any adjacent pair, which allows us to perform adjacent swaps (bubble sort operations). Since any permutation can be sorted using adjacent swaps, we can always achieve the sorted order.

## Algorithm

For each test case:

1. Read `n` and `k`, and the array `a`
2. If `k == 1`:
   - Check if the array is already sorted
   - Return "YES" if sorted, "NO" otherwise
3. If `k >= 2`:
   - Always return "YES"

## Complexity Analysis

- Time: O(n) per test case (only for checking if array is sorted when k=1)
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
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            if (k == 1) {
                for (int i = 1; i < n; i++) {
                    if (a[i] < a[i - 1]) {
                        System.out.println("NO");
                        return;
                    }
                }
                System.out.println("YES");
            } else {
                System.out.println("YES");
            }
        }
        sc.close();
    }
}
```

## Problem Details

- **Contest**: Codeforces Round 912 (Div. 2)
- **Difficulty**: 800 (Easy)
- **Tags**: Brute Force, Greedy, Sorting
- **Time Limit**: 1 second
- **Memory Limit**: 256 MB

## Examples

### Input:

```
5
3 2
1 2 3
3 1
9 9 9
4 4
6 4 2 1
4 3
10 3 830 14
2 1
3 1
```

### Output:

```
YES
YES
YES
YES
NO
```

### Explanation:

- **Test cases 1 & 2**: Already sorted, so "YES"
- **Test case 3**: Can reverse the entire array (k = 4 ≥ n), so "YES"
- **Test case 4**: Can reverse adjacent pairs to sort, so "YES"
- **Test case 5**: k = 1 and array is not sorted, so "NO"
