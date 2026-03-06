# 🔄 Next Permutation

## 📌 Problem

Given an integer array `nums`, rearrange the numbers into the **next lexicographically greater permutation**.

If such a permutation is not possible (the array is in descending order), rearrange it to the **lowest possible order (ascending order)**.

The modification must be done:

* **In-place**
* Using **constant extra space**

---

## 💡 Idea Behind the Algorithm

To generate the **next permutation**, we must make the **smallest possible change** that produces a larger permutation.

This is done in **three main steps**:

1. Find the **pivot** where the increasing order breaks.
2. Swap it with the **next greater element** from the right.
3. Reverse the remaining suffix to make it **smallest possible**.

---

## 🧠 Step-by-Step Algorithm

### 1️⃣ Find the Pivot

Traverse the array **from right to left** and find the first index where:

```
nums[i] > nums[i-1]
```

The index `i-1` becomes the **pivot**.

Example:

```
nums = [1,2,3]
           ↑
pivot = 2
```

If no such pivot exists, the array is in **descending order**.

Example:

```
[3,2,1]
```

In this case, reverse the entire array.

---

### 2️⃣ Find Next Greater Element

From the right side, find the **first element greater than the pivot**.

Example:

```
nums = [1,2,3]
pivot = 2
```

Swap with `3`.

```
[1,3,2]
```

---

### 3️⃣ Reverse the Suffix

After swapping, the part **after the pivot** may not be in the smallest order.

Reverse it to make the permutation **just larger than the original**.

Example:

```
[1,3,2]
```

The suffix becomes the smallest possible order.

---

## 📊 Example

### Example 1

Input

```
[1,2,3]
```

Steps

```
pivot = 2
swap with 3
reverse suffix
```

Output

```
[1,3,2]
```

---

### Example 2

Input

```
[3,2,1]
```

No pivot found → reverse entire array

Output

```
[1,2,3]
```

---

### Example 3

Input

```
[1,1,5]
```

Steps

```
pivot = 1
swap with 5
reverse suffix
```

Output

```
[1,5,1]
```

---

## ⏱ Time Complexity

```
O(N)
```

* One pass to find pivot
* One pass to find swap element
* One pass to reverse suffix

---

## 💾 Space Complexity

```
O(1)
```

The algorithm modifies the array **in-place**.

---

## 🚀 Key Concepts

* Lexicographical ordering
* Greedy approach
* Array reversal
* In-place modification

---

✔ Efficient algorithm used to generate the **next lexicographical permutation** of an array.
