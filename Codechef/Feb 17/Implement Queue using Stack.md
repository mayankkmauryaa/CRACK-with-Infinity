### **Problem**

Chef wants to implement a queue that follows the **First-In-First-Out (FIFO)** principle using only **two stacks**.
Stacks support operations such as **push**, **pop**, **peek**, **size**, and **isEmpty**.

Chef needs to design a queue using only stack operations such that it behaves exactly like a normal queue and each operation runs in **amortized time**.

### **Class Description**

Chef will implement a class named **`QueueUsingStacks`**. The class supports the following operations:

- **`pushElement(x)`**
  Inserts the element at the back of the queue.
- **`popElement()`**
  Removes and returns the front element of the queue.
- **`peekElement()`**
  Returns the front element of the queue without removing it.
- **`isEmptyResult()`**
  Returns **true** if the queue is empty, otherwise returns **false**.

### [**Solution**](#java-solution)

### **Constraints**

- $1 \le T \le 10^5$
- $1 \le N \le 2 \times 10^5$
- $1 \le x \le 10^9$
- The total number of operations across all test cases will not exceed
- All `popElement()` and `peekElement()` operations are guaranteed to be valid

### **Input Format**

- The first line contains an integer — the number of test cases.
- For each test case:
- The first line contains an integer — the number of operations.
- The next lines contain one of the following operations:
- `push x`
- `pop`
- `peek`
- `empty`

### **Output Format**

- For each test case, print the result of each operation on a new line.
- For `popElement()` and `peekElement()`, print the integer value.
- For `isEmptyResult()`, print **true** if the queue is empty, otherwise print **false**.
- For `pushElement(x)`, print **None**.

---

### **Sample 1:**

**Input**

```text
1
6
push 10
push 20
peek
pop
empty
pop

```

**Output**

```text
None
None
10
10
false
20

```

**Explanation:**

- `push 10`: Added 10 to the queue, output None as push returns nothing.
- `push 20`: Added 20 to the queue, output None again.
- `peek`: Front element is 10, so output is 10.
- `pop`: Removed and returned front element 10.
- `empty`: Queue still has 20, so output is false.
- `pop`: Removed and returned 20, queue is now empty.

---

### **Sample 2:**

**Input**

```text
1
8
push 5
push 3
push 7
pop
peek
pop
pop
empty

```

**Output**

```text
None
None
None
5
3
3
7
true

```

**Explanation:**

- `push 5`: Queue = [5], output None.
- `push 3`: Queue = [5, 3], output None.
- `push 7`: Queue = [5, 3, 7], output None.
- `pop`: Removes front 5, output 5.
- `peek`: Front is 3, output 3.
- `pop`: Removes front 3, output 3.
- `pop`: Removes front 7, output 7.
- `empty`: Queue is empty, output true.

---

### **JAVA Solution**

```java
import java.util.Stack;

class QueueUsingStacks {
    private Stack<Long> st1 = new Stack<>();
    private Stack<Long> st2 = new Stack<>();

    public void pushElement(long x) {
        st1.push(x);
    }

    private void transfer() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
    }

    public long popElement() {
        transfer();
        return st2.pop();
    }

    public long peekElement() {
        transfer();
        return st2.peek();
    }

    public boolean isEmptyResult() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

```
