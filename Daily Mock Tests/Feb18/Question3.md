# 3. Pair with Given Sum

[Check Solution](#solution)

**Problem:**

You have been given an integer array A and a number K.
Now, you need to find out whether any two different elements of the array A sum to the number K.
Two elements are considered to be different if they lie at different positions in the array.
If there exists such a pair of numbers, print "YES" (without quotes), else print "NO" (without quotes).

---

## Input Format

The first line consists of two integers N, denoting the size of array A and K. The next line consists of N space separated integers denoting the elements of the array A.

---

## Output Format

Print the required answer on a single line.

---

## Constraints

* 1 <= n <= 10^5
* 1 <= a[i] <= 10^6
* 1 <= k <= 10^6

### Example #1

**Input**

```
5 9
1 2 3 4 5

```

**Output**

```
YES

```

**Explanation:**

Here, A[4] + A[5] = 4 + 5 = 9. So, the answer is YES.

### Example #2

**Input**

```
4 9
1 2 3 4

```

**Output**

```
NO

```

**Explanation:**

There is no pair of distinct elements in the array whose sum equals 9
1+2=3
1+3=4
1+4=5
2+3=5
2+4=6
3+4=7

---

## Solution

```java
import java.util.*;

class Main {
    static void checkSum(int n, int k, int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : a) {
            int find = k - num;
            if (set.contains(find)) {
                System.out.println("YES");
                return;
            }
            set.add(num);
        }
        System.out.println("NO");
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = target - nums[i];
            if (map.containsKey(val))
                return new int[] { i, map.get(val) };
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        checkSum(n, k, a);
        scanner.close();
    }
}
```
