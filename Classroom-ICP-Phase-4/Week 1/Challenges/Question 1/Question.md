# Candy Distribution for Healthy Eating

## Problem Statement

Alice is a 10-year-old girl who loves collecting and eating different types of candies. Each candy belongs to a specific type (for example: chocolate, lollipop, gummy bear, hard candy). Her collection is represented as an integer array `candyType`, where each element denotes the type of a candy.

After a health check-up, Alice’s doctor advises her to eat **no more than half of the total candies** she owns. However, Alice wants to enjoy **as many different types of candies as possible** within this restriction.

Your task is to determine the **maximum number of distinct candy types** Alice can eat if she is allowed to eat only `n / 2` candies, where `n` is the total number of candies.

This problem can be efficiently solved using a **HashSet or HashMap**.

---

## Constraints

- `n == candyType.length`
- `2 <= n <= 10^4`
- `n` is even
- `-10^5 <= candyType[i] <= 10^5`

---

## Examples

### Example 1

**Input:**

```
candyType = [1,1,2,2,3,3]
```

**Output:**

```
3
```

**Explanation:**
Alice can eat `6 / 2 = 3` candies.
There are exactly 3 distinct candy types, so she can eat one candy of each type.

---

### Example 2

**Input:**

```
candyType = [1,1,2,3]
```

**Output:**

```
2
```

**Explanation:**
Alice can eat `4 / 2 = 2` candies.
Even though there are 3 types, she can eat only 2 candies, so the maximum distinct types she can eat is 2.

---

### Example 3

**Input:**

```
candyType = [6,6,6,6]
```

**Output:**

```
1
```

**Explanation:**
Alice can eat `4 / 2 = 2` candies.
Since there is only 1 type of candy, she can eat only 1 distinct type.

---

## Additional Test Cases

### Input 0

```
1 1 2 3 5 7 8
```

**Output:**

```
3
```

### Input 1

```
1 2 2 4
```

**Output:**

```
2
```

### Input 2

```
2 6 7 1 10 1 2 4
```

**Output:**

```
4
```

### Input 3

```
2 6 7 1
```

**Output:**

```
2
```

---

## Key Idea

- Count the number of **distinct candy types** using a HashSet.
- Alice can eat at most `n / 2` candies.
- The answer is the **minimum** of:
- Number of distinct candy types
- `n / 2`

---

## Topics

`Array`
`HashSet`
`HashMap`
