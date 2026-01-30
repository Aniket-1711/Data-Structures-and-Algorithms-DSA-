# 🔢 Transform Array by Parity (Approach 1)

## 📌 Problem Summary

You are given an integer array `nums`.
You must:

1. Replace **even numbers with `0`**
2. Replace **odd numbers with `1`**
3. **Sort** the array in non-decreasing order

---

## 💡 Idea Behind This Approach

Instead of:

* converting all values first
* and then sorting

We directly **count how many even numbers** are present.

Why?

* Even numbers → `0`
* Odd numbers → `1`
* After sorting, **all `0`s come first**, then `1`s

So if we know how many `0`s we need, we can build the result directly.

---

## 🧠 Step-by-Step Explanation

### Step 1: Count Even Numbers

* Traverse the array
* Count how many numbers are even
* This count tells us how many `0`s should be in the result

### Step 2: Build the Result Array

* For the first `count` positions → put `0`
* For the remaining positions → put `1`

This automatically gives a **sorted array**.

---

## 🧾 Code (Java)

```java
class Solution {
    public int[] transformArray(int[] nums) {
        int count = 0;
        
        // Count even numbers
        for (int i : nums) {
            if (i % 2 == 0) {
                count++;
            }
        }

        // Fill array with 0s and 1s
        for (int i = 0; i < nums.length; i++) {
            if (i < count) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        return nums;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)` (in-place)

---

## ✅ Why This Approach Is Good

* No sorting needed
* Very fast and clean
* Easy to understand
* Best for small constraints

---

✨ This approach is efficient and interview-friendly.
