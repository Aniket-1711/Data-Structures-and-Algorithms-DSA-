# 🧮 Minimum Removals to Balance Array

## 📌 Problem Summary

You are given an integer array `nums` and an integer `k`.

An array is **balanced** if:

```
max_element ≤ min_element × k
```

You can remove **any number of elements**, but the array **must not be empty**.

🎯 **Goal:** Return the **minimum number of removals** required to make the array balanced.

---

## 🧠 Key Insight

* The condition depends **only on minimum and maximum values**.
* Order does not matter → **sorting helps**.
* Instead of deciding what to remove, we decide **what to keep**.
* Keeping the **largest valid subarray** gives **minimum removals**.

---

## 🛠️ Approach (Sliding Window)

1. Sort the array
2. Use two pointers:

   * `i` → minimum element index
   * `j` → maximum element index
3. Expand `j` while the balance condition holds
4. If condition breaks, move `i`
5. Track the **maximum valid window size**
6. Answer = `total elements − max window size`

---

## ✨ Algorithm Steps

* Sort `nums`
* Initialize `i = 0`
* Loop `j` from `0` to `n-1`
* While `nums[j] > nums[i] × k`, increment `i`
* Update maximum window length

---

## 💻 Java Implementation

```java
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;

        Arrays.sort(nums);

        int i = 0;
        int maxLen = 1;

        for (int j = 0; j < n; j++) {
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return n - maxLen;
    }
}
```

---

## 🧪 Example Walkthrough

### Example: `nums = [1, 6, 2, 9], k = 3`

Sorted array:

```
[1, 2, 6, 9]
```

Valid balanced subarray:

```
[2, 6] → 6 ≤ 2 × 3 ✅
```

* Elements kept = 2
* Total elements = 4
* Removals = `4 − 2 = 2`

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n log n)` (sorting)
* **Space Complexity:** `O(1)` (extra space)

---

## 🧩 Key Takeaway

✅ When removals are allowed freely:

> **Maximize what you keep, not what you delete.**

This pattern appears often in **sliding window** problems.

---

