# 🧮 Intersection of Two Arrays (LeetCode 349)

## ✨ Problem Summary

Given two integer arrays, **nums1** and **nums2**, your task is to return an array containing the **unique elements** that appear in **both** arrays.

👉 The **order** of elements in the result does **not** matter.

---

## 📥 Example

### Example 1

**Input:**

* nums1 = [1,2,2,1]
* nums2 = [2,2]

**Output:**

* [2]

### Example 2

**Input:**

* nums1 = [4,9,5]
* nums2 = [9,4,9,8,4]

**Output:**

* [9,4] or [4,9]

---

## 🧠 Approach Explained

To find the intersection with **unique elements**, we can use **HashSet** because:

* It stores **only unique** items.
* It provides **O(1)** average lookup time.

### ✔️ Steps

1. Store all elements of **nums1** in a set.
2. Loop through **nums2**:

   * If an element exists in the first set and is not already added to the result, add it.
3. Convert the result list into an **int[]**.

This ensures:

* No duplicates
* Efficient lookups
* Clean conversion to array at the end

---

## 💡 Code Implementation

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> setNums1 = new HashSet<>();
        HashSet<Integer> visitedNums2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            setNums1.add(i);
        }

        for (int i : nums2) {
            if (setNums1.contains(i) && !visitedNums2.contains(i)) {
                list.add(i);
                visitedNums2.add(i);
            }
        }

        int ar[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ar[i] = list.get(i);
        }

        return ar;
    }
}
```

---

## 📝 Time & Space Complexity

### ⏱️ Time Complexity: **O(n + m)**

* Adding elements of nums1 → O(n)
* Checking elements of nums2 → O(m)

### 📦 Space Complexity: **O(n + m)**

* HashSets + result list

---

## 🧾 Notes

* The resulting array contains **unique** elements.
* Order does not matter.

---
