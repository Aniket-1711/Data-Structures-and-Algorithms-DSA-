# 📏 Minimum Size Subarray Sum (LeetCode 209)

## 🧠 Problem Statement

You are given:

* An array of positive integers `nums`
* A positive integer `target`

Your task is to find the **minimum length** of a contiguous subarray whose sum is **greater than or equal to `target`**.

If no such subarray exists, return `0`.

---

## ✨ Examples

### Example 1

**Input:** `target = 7, nums = [2,3,1,2,4,3]`
**Output:** `2`
**Explanation:** The subarray `[4,3]` has sum `7` and length `2`.

### Example 2

**Input:** `target = 4, nums = [1,4,4]`
**Output:** `1`
**Explanation:** The subarray `[4]` is enough.

### Example 3

**Input:** `target = 11, nums = [1,1,1,1,1,1,1,1]`
**Output:** `0`
**Explanation:** No subarray has sum ≥ 11.

---

## 🚀 Approach (Sliding Window)

We use two pointers and a running sum.

### Steps:

1. Start with two pointers `i` (left) and `j` (right).
2. Add `nums[j]` to `sum`.
3. While `sum >= target`, update the minimum length.
4. Move the left pointer `i` to reduce the window.
5. Continue until the end of the array.

This gives an **O(n)** time complexity.

---

## 💻 Java Code

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
```

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(1)

---

## 📌 Key Concept

This problem is a classic example of the **Sliding Window Technique** used when dealing with subarrays and sums.

