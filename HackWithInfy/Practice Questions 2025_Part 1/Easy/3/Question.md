# 3. EASY

You have an oil tank with a capacity of **C** litres that
can be bought and sold by **N** people. The people
are standing in a queue are served sequentially in the
order of array **A**.

Some of them want to sell a litre of oil and some of
them want to buy a litre of oil and **A** describes this.
Here, **A[i] = 1** denotes that the person wants to sell
a litre of oil and **A[i] = -1** denotes that the person
wants to buy a litre of oil.

When a person wants to sell a litre of oil but the
tank is full, they cannot sell it and become upset.
Similarly, when a person wants to buy a litre of
oil but the tank is empty, they cannot buy it and
become upset. Both these cases cause disturbances.

You can minimize the disturbance by filling the tank
initially with a certain **X** litres of oil.

Find the minimum initial amount of oil **X** that results
in the least number of disturbances.

---

## Input Format

- The first line contains an integer, **N**, denoting the number of elements in **A**.
- The next line contains an integer, **C**, denoting the capacity of the tank.
- Each line **i** of the **N** subsequent lines (where 0 ≤ i < N) contains an integer describing **A[i]**.

---

## Constraints

- `1 <= N <= 10^5`
- `1 <= C <= 10^5`
- `-1 <= A[i] <= 1`

---

## Sample Test Cases

### Case 1

**Input:**

```
3
3
-1
1
1
```

**Output:**

```
1
```

**Explanation:**

Given **N = 3, C = 3, A = [-1, 1, 1]**.
- To avoid disturbance for Person 1, we need at least 1 liter in the tank initially.
- After Person 1 buys 1 liter, the tank will be empty.
- Person 2 sells 1 liter, so the tank will have 1 liter.
- Person 3 sells another liter, so the tank will have 2 liters.
- The minimum initial amount **X** needed to achieve the least number of disturbances is 1 liter.

---

### Case 2

**Input:**

```
3
2
-1
-1
1
```

**Output:**

```
2
```

**Explanation:**

Given **N = 3, C = 2, A = [-1, -1, 1]**.

To ensure that there are no disturbances:
- We need at least 1 liter for Person 1.
- We need an additional 1 liter for Person 2, making
- the total initial amount of oil **X = 2**.
- Thus, the minimum initial amount of oil **X** required
to achieve the least number of disturbances is 2.

---

### Case 3

**Input:**

```
4
3
1
1
1
1
```

**Output:**

```
0
```

**Explanation:**

Given **N = 4, C = 3, A = [1, 1, 1, 1]**.

1. Person 1 wants to sell 1 litre of oil (**A[1] = 1**).
   Initially, the tank is empty, so Person 1 can sell 1
   litre. The tank now has 1 litre of oil.
2. Person 2 wants to sell 1 litre of oil (**A[2] = 1**).
   The tank now has 1 litre, so Person 2 can sell 1 litre.
   The tank now has 2 litres of oil.
3. Person 3 wants to sell 1 litre of oil (**A[3] = 1**).
   The tank now has 2 litres, so Person 3 can sell 1 litre.
   The tank now has 3 litres of oil, which is its full capacity.
4. Person 4 wants to sell 1 litre of oil (**A[4] = 1**).
   The tank is now full (3 litres), so Person 4 cannot sell
   1 litre and will be upset.

Given that the tank capacity **C** is 3 litres and all
actions are selling oil, the only disturbance occurs when
Person 4 tries to sell oil to a full tank.

Therefore, no initial amount of oil **X** will change the
disturbance for Person 4, as the tank’s capacity is already
limiting.

Hence, the minimum initial amount of oil **X**
required to achieve the least number of disturbances
remains 0.
