# Count Elements With at Least K Greater Values 📘✨

## 📌 Problem Overview

Given an integer array and a value **k**, an element is considered **qualified** if there are **at least k elements strictly greater** than it.
The task is to count how many such qualified elements exist.

---

## 🧠 Key Idea

* First, sort the array.
* The element at position `n - k` (0‑indexed) represents the **threshold value**.
* All elements **strictly smaller** than this value are qualified.

If **k = 0**, every element qualifies because we don't need any greater values.

---

## 🧩 Examples

### ✅ Example 1

**Input:** nums = [3,1,2], k = 1
Greater element count needed = 1
Qualified elements → 1, 2
**Output:** 2

---

### ✅ Example 2

**Input:** nums = [5,5,5], k = 2
All values equal → no value has 2 greater values
**Output:** 0

---

## 🚀 Solution Approach

1. Sort the array.
2. Find the value at index `n - k`.
3. Count all elements strictly smaller than this value.
4. If `k = 0`, return the length of array.

---

## 💻 Java Code

```java
class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        if (k == 0) {
            return nums.length;
        }

        int count = 0;
        int num = nums[nums.length - k];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < num) {
                count++;
            }
        }

        return count;
    }
}
```

---

## 🏁 Final Note

* **Time Complexity:** O(n log n) ⏱️
* **Space Complexity:** O(1) 💾
* Works efficiently for large arrays.
