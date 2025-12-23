# 🧮 Minimum Operations to Equalize Array

## 📌 Problem Overview

You are given an integer array `nums` of length `n`.

In **one operation**, you can:

* Choose any **non-empty subarray** `nums[l…r]`
* Replace **all elements** in that subarray with the **bitwise AND** of all its elements

Your task is to find the **minimum number of operations** needed to make **all elements in the array equal**.

---

## 🔍 Key Observations

* If **all elements are already equal**, no operation is needed.
* If **at least one element is different**, you can always make the entire array equal in **one operation** by taking the AND of the whole array.

Why this works:

* Bitwise AND over multiple numbers never increases values.
* Applying AND on the full array makes all elements the same.

---

## 🧠 Approach

1. Take the first element as reference.
2. Check if all other elements are equal to it.
3. If yes → return `0`
4. If not → return `1`

---

## 💡 Example Walkthrough

### Example 1

**Input:** `[1, 2]`

* Elements are not equal
* AND of `[1, 2]` → `0`
* Array becomes `[0, 0]`

**Output:** `1`

### Example 2

**Input:** `[5, 5, 5]`

* All elements already equal

**Output:** `0`

---

## 🧑‍💻 Java Solution

```java
class Solution {
    public int minOperations(int[] nums) {
        int first = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != first) {
                return 1;
            }
        }
        
        return 0;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

---

## ✅ Final Notes

* Simple check is enough due to the nature of **bitwise AND**.
* No need for complex simulation.
* Clean and optimal solution for given constraints.
