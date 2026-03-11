All Tracks>Data Structures> Trees> Heaps/Priority Queues> Problem

[AND choice](https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/and-choice-0e5db566/)

5058
93%
30
★★★★★2.9
14 votes
Algorithms, Bit Manipulation, Data Structures, Math, Priority queue, Trees
Share
Details
Submissions
Discussion
Editorial
Problem
M is alone and he has an array
. M wants to choose two integers
such that
and the value
(bitwise AND) is maximum.

What is the maximum value M can get?

Input

First line contains only
, legnth of array.

Second line contains the array elements
separated by space.

Output

The only line of output contains an integer, maximum value value that M can get.

Time Limit: 2.5
Memory Limit: 256
Source Limit:
Explanation
M can choose
and
with bitwise AND
which is maximum.

?

## brute

```java
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextLong();
        }

        long ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i!=j){
                    ans = Math.max(ans, arr[i] & arr[j]);
                }
            }
        }

        System.out.println(ans);
    }
}


```

## optimised

```java
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextLong();
        }

        long ans = 0;
        for(int bit = 31 ; bit>=0; bit--){
            long temp = ans | (1L << bit);
            int count = 0;
            for(int i=0; i<n; i++){
                if((arr[i] & temp) == temp) count++;
                if(count >= 2) break;
            }
            if(count >=2) ans = temp;
        }

        System.out.println(ans);
    }
}

```
