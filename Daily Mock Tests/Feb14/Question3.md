# 3. Monk and the Magical Candy Bags

[Check Solution](#solution)

**Problem:**

Our Monk loves candy!
While taking a stroll in the park, he stumbled upon Bags with candies. The -th of these bags contains candies.
He picks up a bag, eats all the candies in it and drops it on the ground. But as soon as he drops the bag, the number of candies in the bag increases magically! Say the bag that used to contain candies (before eating), now contains candies, where is the greatest integer less than (Greatest Integer Function).

Amazed by the magical spell, Monk can now have a lot more candies! But he has to return home in minutes. In a single minute, Monk can consume all the candies in a single bag, regardless of the number of candies in it.
Find the maximum number of candies that Monk can consume.

---

## Input Format

- The first line contains an integer . test cases follow.
- The first line of each test case contains two space-separated integers and .
- The second line of each test case contains space-separated integers, the number of candies in the bags.

---

## Output Format

- Print the answer to each test case in a new line.

---

## Constraints

- $1 \le T \le 10$
- $1 \le N \le 10^5$
- $0 \le K \le 10^5$
- $0 \le A_i \le 10^{10}$

### Example #1

**Input**

```text
1
5 3
2 1 7 4 2
```

**Output**

```text
14
```

**Explanation:**

The state of bags is: `2 1 7 4 2`

1. Monk eats all candies from the Third bag (`7`). The state of bags becomes: `2 1 3 4 2`
2. Monk eats all candies from the Fourth bag (`4`). The state of bags becomes: `2 1 3 2 2`
3. Monk eats all candies from the Third bag (`3`). The state of bags becomes: `2 1 1 2 2`

Hence, the Monk eats `7 + 4 + 3 = 14`candies.

---

## Solution

To solve this efficiently, we use a **Max-Priority Queue (Max-Heap)** to ensure we always pick the bag with the most candies at every step.

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // Using a Max-Priority Queue to keep the largest bags at the top
            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                pq.add(sc.nextLong());
            }

            long totalCandies = 0;
            for (int i = 0; i < K; i++) {
                if (pq.isEmpty()) break;

                // Pick the bag with maximum candies
                long currentMax = pq.poll();
                totalCandies += currentMax;

                // Put the bag back with half the candies
                pq.add(currentMax / 2);
            }

            System.out.println(totalCandies);
        }
        sc.close();
    }
}

```