
All Tracks>Data Structures> Stacks> Basics of Stacks> Problem


[Good Indices](https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/good-indices-c7058c9b/)

6035
65%
30
★★★★★3.1
13 votes
Queues, Basics of Queues, Basics of Stacks, C++, Data Structures, Stacks
Share
Details
Submissions
Discussion
Similar Problems
Editorial
Problem
Given an array of integers 
 of size 
. 
You can perform the following operation on the array:

Choose an index 
 and remove the 
 element from 
.
For each, 
 (from 
 to 
), output the minimum number of operations such that the integer 
 becomes greater than BOTH of its neighbours i.e. 
.

If it is not possible to satisfy the mentioned condition output 
 for that index

Input Format :

The first line contains 
, the number of test cases 

The first line of all test cases contains 
, the number of elements in the array 

The second line contains 
 space-separated integers 

Note :  The sum of 
 over all test cases does not exceed 

Output Format :

For every test case, output 
 integers, where the 
 integer represents the minimum number of moves to make the 
 index good

Constraints:


Sample Input
1
5
1 2 3 5 1
Sample Output
-1 2 1 0 -1
Time Limit: 2
Memory Limit: 256
Source Limit:
Explanation
For the given sample, T = 1, N = 5
A = [1, 2, 3, 5, 1]
For i = 1
Since there is no left neighbor, output -1
For i = 2
We can perform two operations and remove 3 and 5.
A becomes [1, 2, 1]
Hence, 2 is greater than both of its neighbors
So, answer is 2.
For i = 3
Remove 5, A = [1, 2, 3, 1]. 
So, answer is 1
For i = 4
5 is already greater than both of its neighbors.
So, answer is 0
For i = 5
Since there is no right neighbor, answer is -1

Contributers:
avatar
Pawankumar Nandagiri
avtar
Geetartha Kaustav
Enter your code or Upload your code as file.
Save

Java 8 (openjdk 1.8.0_241)


1234567

class TestClass {
    public static void main(String args[] ) throws Exception {
        
    }
}

4:9 vscode


Test against custom input
?

## Using 2 Pointer 



## Using Stack 

```java
import java.util.*;

class Main {

    static void processTestCase(int n, int[] a) {

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // nearest smaller on left
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && a[st.peek()] >= a[i])
                st.pop();

            if(st.isEmpty()) left[i] = -1;
            else left[i] = st.peek();

            st.push(i);
        }

        st.clear();

        // nearest smaller on right
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && a[st.peek()] >= a[i])
                st.pop();

            if(st.isEmpty()) right[i] = -1;
            else right[i] = st.peek();

            st.push(i);
        }

        for(int i = 0; i < n; i++){

            if(i == 0 || i == n-1 || left[i] == -1 || right[i] == -1){
                System.out.print("-1 ");
            }
            else{
                int ops = (i - left[i] - 1) + (right[i] - i - 1);
                System.out.print(ops + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0){

            int N = sc.nextInt();
            int[] A = new int[N];

            for(int i = 0; i < N; i++)
                A[i] = sc.nextInt();

            processTestCase(N, A);
        }

        sc.close();
    }
}
```