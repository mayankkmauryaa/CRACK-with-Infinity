# Flipkart OA Question 🔥🔥 Hard

## 📦 Problem Statement

A warehouse management system handles customer orders that must be packed and shipped daily. The packing team receives a large list of available inventory items (**arr1**), each represented by a unique product ID.

On any given day, high-priority customer orders specify a subset of these products that must be packed first and in a **specific order based on delivery urgency**. These high-priority product IDs are provided in a separate list (**arr2**), where the **order of IDs reflects the priority sequence**.

All items listed in **arr2** are guaranteed to be present in the full inventory list **arr1**, and the items in **arr2** are **unique**. However, **arr1 may contain other lower-priority items** not present in **arr2**, which should still be included in the final packing list but **only after all high-priority items**, and they should be **sorted in ascending order by product ID**.

As part of the warehouse automation system, you are tasked with writing a function that takes in the full list of available items (**arr1**) and the high-priority ordered list (**arr2**) and returns a **sorted packing list**.

The result must:

- Preserve the **order of items from arr2**
- Append any remaining items from **arr1** in **ascending order**

This problem tests your ability to:

- Manage **custom sorting**
- Maintain **order relationships**
- Efficiently process **large lists of data** for real-world logistics operations

---

## 📏 Constraints

- `1 <= arr1.length, arr2.length <= 1000`
- `0 <= arr1[i], arr2[i] <= 1000`
- All the elements of **arr2** are **distinct**
- Each `arr2[i]` is present in **arr1**

---

## 🧪 Examples

### Example 1

**Input**

```
arr1 = [2,3,1,3,2,4,6,7,9,2,19]
arr2 = [2,1,4,3,9,6]
```

**Output**

```
[2,2,2,1,4,3,3,9,6,7,19]
```

---

### Example 2

**Input**

```
arr1 = [28,6,22,8,44,17]
arr2 = [22,28,8,6]
```

**Output**

```
[22,28,8,6,17,44]
```

---

## 🧾 Test Inputs & Outputs

### Input0

```
2 1 3 1 2 1 4
1 2 3 4
```

**Output0**

```
1 1 1 2 2 3 4
```

---

### Input1

```
23 2 4 6 10 2
2 4 6
```

**Output1**

```
2 2 4 6 10 23
```

---

### Input2

```
1 3 5 7 2 3 4 3
1 3 2 7 5
```

**Output2**

```
1 3 3 3 2 7 5 4
```

---

### Input3

```
10 11 12 11 10
11 12
```

**Output3**

```
11 11 12 10 10
```

---

### Input4

```
1 2 4 6 2 4
1 4 2 6
```

**Output4**

```
1 4 4 2 2 6
```

---

### Input5

```
1 2 1 2 1 2 1 3
2 3 1
```

**Output5**

```
2 2 2 3 1 1 1 1
```
