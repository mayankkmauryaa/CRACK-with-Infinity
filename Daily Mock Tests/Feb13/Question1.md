# 1. Little Monk and Williamson

[Check Solution](#solution)

**Problem:**

Little Monk is a huge cricket fan, so he decides that he'll meet his five favorite cricketers in this problem-set of heaps. And he'll try to impress them. The first cricketer he wants to impress is: Kane Williamson. He asked Kane to answer some queries in a press interview. Kane is irritated by Little Monk's constant interruption during his interview, so he decides to give Monk a run for his money by asking him the answer to various queries.

Williamson will give a query of the types mentioned below, to the Monk and will expect him to answer those.

* **PUSH X** — Insert Williamson's score in an array. - Query type 1.
* **Diff** — Find out the difference between Williamson's current highest and current lowest score, currently present in the array. And then remove a singular instance of those values from the array. - Query type 2.
* **Note:** In case, the current lowest and current highest score are same, then only one instance of that score will be removed from the array.
* **CountHigh** — Find out the number of times Williamson has scored his current highest score, currently present in array. - Query type 3.
* **CountLow** — Find out the number of times Williamson has scored his current lowest score, currently present in array. - Query type 4.

---

## Input Format

The first line contains an integer Q, which denotes the number of queries which have to be dealt by The Monk. The next Q lines will contain a query like the ones mentioned above.

---

## Output Format

For the query type 2, 3, and 4, print the answer in a new line. If there is no record of any innings, that is, the array of Williamson's score is empty for query type 2, 3 and 4, then print -1.

---

## Constraints

 (Number of queries)

---

## Example #1

**Input**

```
10
CountHigh
Push 442
CountHigh
Push 7555
Diff
Push 2799
Diff
Push 8543
Diff
Diff

```

**Output**

```
-1
1
7113
0
0
-1

```

**Explanation:**

Since there's no score currently, the answer to the first query is -1. Then we insert 442 runs as Williamson's score. Since there's only one instance of 442 and that is the highest number in the array, CountHigh would be 1. Then we insert 7555 as Williamson's next score. Then, the difference is 7113 and that means 442 and 7555 are also removed from the array. After pushing 2799, and finding out the difference would be 0 since the highest and the lowest score is same. For the last Diff query, since there is no number in the array, the answer would be -1.

---

## Solution

To efficiently find the maximum, minimum, and their frequencies in  time, we use a `TreeMap` to store the scores as keys and their occurrences as values.

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (q-- > 0) {
            String type = sc.next();

            if (type.equals("Push")) {
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            } 
            else if (map.isEmpty()) {
                System.out.println("-1");
            } 
            else if (type.equals("Diff")) {
                int high = map.lastKey();
                int low = map.firstKey();
                System.out.println(high - low);

                // Handle removal
                if (high == low) {
                    if (map.get(high) == 1) map.remove(high);
                    else map.put(high, map.get(high) - 1);
                } else {
                    // Remove one instance of high
                    if (map.get(high) == 1) map.remove(high);
                    else map.put(high, map.get(high) - 1);

                    // Remove one instance of low
                    if (map.get(low) == 1) map.remove(low);
                    else map.put(low, map.get(low) - 1);
                }
            } 
            else if (type.equals("CountHigh")) {
                System.out.println(map.get(map.lastKey()));
            } 
            else if (type.equals("CountLow")) {
                System.out.println(map.get(map.firstKey()));
            }
        }
        sc.close();
    }
}

```