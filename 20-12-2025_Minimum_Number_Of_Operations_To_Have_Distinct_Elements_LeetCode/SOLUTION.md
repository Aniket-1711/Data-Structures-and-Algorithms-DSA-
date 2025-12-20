# 🧮 Minimum Number of Operations to Have Distinct Elements

## 📌 Problem Summary

You are given an integer array `nums`.

In **one operation**:

* Remove the **first 3 elements** of the array
* If fewer than 3 elements remain, remove **all remaining elements**

Repeat operations until:

* The array becomes **empty**, or
* The array contains **only distinct elements** (no duplicates)

Return the **minimum number of operations** required.

---

## 🧠 Key Idea

* If the array already has **all unique elements**, answer is `0`
* Otherwise, find the **earliest index from the left** that causes a duplicate
* Remove elements in chunks of **3 from the front** until that duplicate is gone

---

## 🚀 Approach (Optimized)

1. Traverse the array **from right to left**
2. Use a **HashSet** to track seen elements
3. When a duplicate is found:

   * Calculate how many elements must be removed
   * Each operation removes `3` elements

📐 Formula used:

```
operations = (index + 1 + 2) / 3
```

---

## 🧪 Examples

### Example 1

**Input:** `[3, 8, 3, 6, 5, 8]`

* Duplicate `3` found
* Remove first 3 elements
* Remaining array is distinct

✅ Output: `1`

---

### Example 2

**Input:** `[2, 2]`

* Fewer than 3 elements
* One operation clears the array

✅ Output: `1`

---

### Example 3

**Input:** `[4, 3, 5, 1, 2]`

* Already all distinct

✅ Output: `0`

---

## 💻 Java Solution

```java
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                int elementsToRemove = i + 1;
                return (elementsToRemove + 2) / 3;
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time:** `O(n)`
* **Space:** `O(n)` (HashSet)

---

## ✅ Final Notes

* Clean greedy logic
* No simulation needed
* Efficient for large inputs (up to `10^5`)

