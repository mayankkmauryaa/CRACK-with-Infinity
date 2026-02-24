# A. Line Trip

[**Codeforces Submission**](https://codeforces.com/contest/1901/submission/362382345)

[**Problem**](#problem-statement)

[**Solution**](#solution-approach)

[**Algorithm**](#algorithm)

[**Complexity**](#complexity-analysis)

[**Implementation**](#reference-implementation)

## [Problem Statement](https://codeforces.com/problemset/problem/1901/A)

**A. Line Trip**

**Time limit per test:** 2 seconds  
**Memory limit per test:** 256 megabytes

There is a road, which can be represented as a number line. You are located in the point 0 of the number line, and you want to travel from the point 0 to the point x, and back to the point 0.

You travel by car, which spends 1 liter of gasoline per 1 unit of distance travelled. When you start at the point 0, your car is fully fueled (its gas tank contains the maximum possible amount of fuel).

There are n gas stations, located in points a₁,a₂,…,aₙ. When you arrive at a gas station, you fully refuel your car. Note that you can refuel only at gas stations, and there are no gas stations in points 0 and x.

You have to calculate the minimum possible volume of the gas tank in your car (in liters) that will allow you to travel from the point 0 to the point x and back to the point 0.

---

### **Input**

The first line contains one integer t (1≤t≤1000) — the number of test cases.

Each test case consists of two lines:

the first line contains two integers n and x (1≤n≤50; 2≤x≤100);
the second line contains n integers a₁,a₂,…,aₙ (0<a₁<a₂<⋯<aₙ<x).

---

### **Output**

For each test case, print one integer — the minimum possible volume of the gas tank in your car that will allow you to travel from the point 0 to the point x and back.

---

### **Example**

**Input**

```
3
3 7
1 2 5
3 6
1 2 5
1 10
7
```

**Output**

```
4
3
7
```

---

### **Note**

In the first test case of the example, if the car has a gas tank of 4 liters, you can travel to x and back as follows:

travel to the point 1, then your car's gas tank contains 3 liters of fuel;
refuel at the point 1, then your car's gas tank contains 4 liters of fuel;
travel to the point 2, then your car's gas tank contains 3 liters of fuel;
refuel at the point 2, then your car's gas tank contains 4 liters of fuel;
travel to the point 5, then your car's gas tank contains 1 liter of fuel;
refuel at the point 5, then your car's gas tank contains 4 liters of fuel;
travel to the point 7, then your car's gas tank contains 2 liters of fuel;
travel to the point 5, then your car's gas tank contains 0 liters of fuel;
refuel at the point 5, then your car's gas tank contains 4 liters of fuel;
travel to the point 2, then your car's gas tank contains 1 liter of fuel;
refuel at the point 2, then your car's gas tank contains 4 liters of fuel;
travel to the point 1, then your car's gas tank contains 3 liters of fuel;
refuel at the point 1, then your car's gas tank contains 4 liters of fuel;
travel to the point 0, then your car's gas tank contains 3 liters of fuel.

---

**Problem Tags:** greedy, math, \*800

## Solution Approach

The key insight is to find the maximum distance that needs to be traveled without refueling. This will determine the minimum tank size required.

For the round trip from 0 to x and back to 0, we need to consider:

1. **Forward journey segments**: distances between consecutive stations
2. **First segment**: from 0 to first gas station
3. **Last segment**: from last gas station to x
4. **Return journey**: the critical segment is from x back to the last gas station

Since we refuel at every gas station, the tank must be large enough to cover the longest distance between any two consecutive refueling points, including the return from x to the last station.

## Algorithm

For each test case:

1. Read `n`, `x`, and the array of gas station positions `a`
2. Calculate the maximum of:
   - Distance from 0 to first station: `a[0]`
   - Distances between consecutive stations: `a[i] - a[i-1]` for `i = 1 to n-1`
   - Distance from last station to x (and back): `2 * (x - a[n-1])`
3. Return this maximum value as the minimum tank size

## Complexity Analysis

- Time: O(n) per test case
- Space: O(1) extra space

## Reference Implementation

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int maxDistance = a[0];

            for (int i = 1; i < n; i++) {
                maxDistance = Math.max(maxDistance, a[i] - a[i - 1]);
            }

            maxDistance = Math.max(maxDistance, 2 * (x - a[n - 1]));

            System.out.println(maxDistance);
        }
    }
}
```

## Problem Details

- **Contest**: Educational Codeforces Round 158 (Rated for Div. 2)
- **Difficulty**: 800 (Easy)
- **Tags**: Greedy, Math
- **Time Limit**: 2 seconds
- **Memory Limit**: 256 MB

## Examples

### Input:

```
3
3 7
1 2 5
3 6
1 2 5
1 10
7
```

### Output:

```
4
3
7
```

### Explanation:

- **Test case 1**: Maximum distance is between station 2 and 5 (distance 3), but the critical segment is from 5 to 7 and back to 5 (distance 4).
- **Test case 2**: The critical segment is from 5 to 6 and back to 5 (distance 2), but from 0 to 1 requires 3.
- **Test case 3**: Only one station at 7, so we need to cover from 0 to 7 (distance 7) and from 7 to 10 and back to 7 (distance 6). Maximum is 7.
