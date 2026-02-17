### **Problem**

You are given the head of a singly linked list **A** of length **N**. You are also given two integers **L** and **R**. You need to reverse the nodes of the list from position **L** to position **R** (1-indexed), while keeping the rest of the list unchanged.

### **Function Description**

You must complete the function **`reverseSegment`**.

* **`head`**: The head pointer of a singly linked list.
* **`L`**: The starting position of the segment to be reversed.
* **`R`**: The ending position of the segment to be reversed.

The linked list contains `N` nodes, and you need to reverse only the nodes from position **L** to **R**, while keeping the rest of the list unchanged.

The function must **return the head** of the linked list after reversing the specified segment.

The input and output formats given below are only if you want to test using custom inputs

### **[Solution](#java-solution)**

### **Constraints**

* $1 \le T \le 100$
* $1 \le N \le 10^5$
* $1 \le L \le R \le N$
* $1 \le A_i \le 10^9$
* The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.

### **Input Format**

* The first line contains , the number of test cases.
* For each test case:
* Three space-separated integers .
*  space-separated integers representing the list values.



### **Output Format**

* For each test case, return the head of the modified list.

---

### **Sample 1:**

**Input**

```text
4
6 2 5
1 2 3 4 5 6
4 1 3
1 2 3 4
5 3 5
10 4 3 6 7
3 1 3
5 6 4

```

**Output**

```text
1 5 4 3 2 6
3 2 1 4
10 4 7 6 3
4 6 5

```

**Explanation:**

* **Case 1:** Reversing positions 2 to 5 in `[1, 2, 3, 4, 5, 6]` results in `[1, 5, 4, 3, 2, 6]`.
* **Case 2:** Reversing positions 1 to 3 in `[1, 2, 3, 4]` results in `[3, 2, 1, 4]`.

---

### **JAVA Solution**

```java
/*
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node reverseSegment(Node head, int L, int R) {
        if (head == null || L == R) {
            return head;
        }

        // Create a dummy node to handle the case where L = 1
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // 1. Reach the node just before the segment to be reversed
        for (int i = 1; i < L; i++) {
            prev = prev.next;
        }

        // 2. Start reversing the segment
        // 'curr' is the first node of the segment to be reversed
        Node curr = prev.next;
        Node nextNode = null;
        Node segmentPrev = null;

        // We reverse (R - L + 1) nodes
        Node tailOfReversed = curr; 
        for (int i = 0; i < (R - L + 1); i++) {
            nextNode = curr.next;
            curr.next = segmentPrev;
            segmentPrev = curr;
            curr = nextNode;
        }

        // 3. Reconnect the reversed segment back to the main list
        // prev.next was the start of the segment, now it should point to the new head (segmentPrev)
        prev.next = segmentPrev;
        // The original start (now tail) points to the node after the segment (curr)
        tailOfReversed.next = curr;

        return dummy.next;
    }
}

```