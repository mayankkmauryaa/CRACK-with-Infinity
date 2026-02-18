# 1. Delete Duplicate-value Nodes from a Sorted Linked List

[Check Solution](#solution)

**Problem:**

You're given the pointer to the head node of a `sorted linked list`, where the data in the nodes is in `ascending order`. Delete as few nodes as possible so that the list does not contain any value more than once. The given head pointer may be null indicating that the list is empty.

---

## Input Format

You have to complete the SinglyLinkedListNode\* `removeDuplicates`(SinglyLinkedListNode* head) method which takes one argument the head of the sorted linked list. You should NOT read any input from stdin/console.
The input is handled by the code in the editor and the format is as follows:
The first line contains an integer `t`, denoting the number of test cases. The format for each test case is as follows:
The first line contains an integer `n`, denoting the number of elements in the linked list.
The next `n` lines contain an integer each, denoting the elements of the linked list.

---

## Output Format

Delete as few nodes as possible to ensure that no two nodes have the same data. Adjust the next pointers to ensure that the remaining nodes form a single sorted linked list. Then return the head of the sorted updated linked list. Do NOT print anything to stdout/console.
The output is handled by the code in the editor and the format is as follows: For each test case, print in a new line, the data of the linked list after removing the duplicates separated by space.

---

## Constraints

* 1 <= t <= 10
* 1 <= n <= 1000
* 1 <= list(i) <= 1000

### Example #1

**Input**

```
1
5
1
2
2
3
4

```

**Output**

```
1 2 3 4

```

**Explanation:**

The initial linked list is: 1 -> 2 -> 2 -> 3 -> 4 -> NULL
The final linked list is: 1 -> 2 -> 3 -> 4 -> NULL

---

## Solution

```java
import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Main {
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            SinglyLinkedListNode head = null;
            SinglyLinkedListNode current = null;
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                if (head == null) {
                    head = new SinglyLinkedListNode(value);
                    current = head;
                } else {
                    current.next = new SinglyLinkedListNode(value);
                    current = current.next;
                }
            }
            head = removeDuplicates(head);
            current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
        scanner.close();
    }
}
```
