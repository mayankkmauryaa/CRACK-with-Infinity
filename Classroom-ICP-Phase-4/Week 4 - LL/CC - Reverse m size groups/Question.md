# Reverse m size groups

You are given a linked list with **N** nodes. You have to perform following commands -

- Make groups of size **M** from the head node to the last node.
- Assuming **x** groups are created, you have to reverse the order of nodes in each group.
- Relative order of the groups in the final linked list must remain the same i.e after reversing, all the elements of group **1** should appear before group **2** and so on.

In order to solve this problem, you just have to complete the function:

`Node* reverseMSizeGroups(Node* head, int M)` by returning the head node of the linked list.

It is guaranteed that **N** is divisible by **M** for all test cases.

---

## Input Format

- First line will contain **T**, the number of testcases. Then the testcases follow.
- The first line of each test case contains 2 integers
**N** - length of linked list and **M** - group size
- Second line of each test case contains **N** space separated integers

`val_1, val_2, .... val_i, ... val_n`

where `val_i` is the value stored at ith node starting from the head node.

### Note

For C++ language, you need to complete the function in the submit solution tab:

`Node* reverseMSizeGroups(Node* head, int M)`

---

## Output Format

Using the function you complete, for each testcase linked list generated must be the required linked list.

- For each test case **N** space separated integers

`nval_1, nval_2, .., nval_i , ... nval_N`

will be outputted, where `nval_i` is the new value stored at ith node starting from the head node.

---

## Constraints

- `1 ≤ T ≤ 10^3`
- `1 ≤ N ≤ 10^5`
- `1 ≤ M ≤ 10^5`, **N** is divisible by **M**
- `1 ≤ val_i ≤ 10^5`
- Sum of **N** over all test cases will not exceed `10^5`

---

## Sample Input

```

2
9 3
1 2 3 4 5 6 7 8 9
10 2
100 102 99 98 10 232 12 45 123 43

```

## Sample Output

```

3 2 1 6 5 4 9 8 7
102 100 98 99 232 10 45 12 43 123

```

---

## Explanation

### Testcase 1

Given Linked List:

```

1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9

```

We need to make groups of 3 and reverse them.
Final linked list:

```

3 → 2 → 1 → 6 → 5 → 4 → 9 → 8 → 7

```

### Testcase 2

Given Linked List:

```

100 → 102 → 99 → 98 → 10 → 232 → 12 → 45 → 123 → 43

```

We need to make groups of 2 and reverse them.
Final linked list:

```

102 → 100 → 98 → 99 → 232 → 10 → 45 → 12 → 43 → 123

```
