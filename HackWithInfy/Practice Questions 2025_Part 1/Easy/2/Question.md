# 2. EASY

You are given an array **A** of length **N** and an  
integer **k**.

A subarray from index **l** to **r** is considered **good** if the number of distinct elements in that subarray does not exceed **k**.  
Additionally, an empty subarray is also considered a good subarray, and its sum is defined as **0**.

Your task is to find the **maximum sum** of any good subarray.

---

## Sample Input 1

```

11
2
1
2
2
3
2
3
5
1
2
1
1

```

## Sample Output 1

```

12

```

### Explanation

- **N = 11**, **k = 2**
- **A = [1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1]**
- A valid good subarray is **[2, 2, 3, 2, 3]**
- It contains at most **k** distinct elements
- Sum = `2 + 2 + 3 + 2 + 3 = 12`

---

## Sample Input 2

```

3
1
-1
-2
-3

```

## Sample Output 2

```

0

```

### Explanation

- **N = 3**, **k = 1**
- **A = [-1, -2, -3]**
- The optimal choice is the empty subarray
- Sum = `0`

---

## Sample Input 3

```

5
5
-1
1
3
2
-1

```

## Sample Output 3

```

6

```

### Explanation

- **N = 5**, **k = 5**
- **A = [-1, 1, 3, 2, -1]**
- Optimal subarray is **[1, 3, 2]**
- Sum = `1 + 3 + 2 = 6`

---

## Input Format

- The first line contains an integer **N**, denoting the number of elements in array **A**.
- The next line contains an integer **k**, denoting the maximum allowed distinct elements.
- Each of the next **N** lines contains one integer representing **A[i]**.

---

## Constraints

- `1 <= N <= 10^5`
- `1 <= k <= N`
- `-10^5 <= A[i] <= 10^5`

---

## Sample Test Case

### Case 1

**Input:**

```

11
2
1
2
2
3
2
3
5
1
2
1
1

```

**Output:**

```

12

```

### Explanation

Here, **N = 11**, **k = 2**  
**A = [1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1]**

We can select the subarray **[2, 2, 3, 2, 3]**.  
It is a good subarray because it contains at most **k** distinct elements.  
Its sum = `2 + 2 + 3 + 2 + 3 = 12`

So, our answer is **12**.

---

## Case 2

### Input

```

3
1
-1
-2
-3

```

### Output

```

0

```

### Explanation

Here, **N = 3**, **k = 1**  
**A = [-1, -2, -3]**

It is optimal to choose the empty subarray.  
So, our answer is **0**.

---

## Case 3

### Input

```

5
5
-1
1
3
2
-1

```

### Output

```

6

```

### Explanation

Here, **N = 5**, **k = 5**  
**A = [-1, 1, 3, 2, -1]**

It is optimal to choose the subarray **[1, 3, 2]**.  
Its sum = `1 + 3 + 2 = 6`.

Hence, our answer is **6**.

