# 🔢 Minimize Maximum Pair Sum in Array

## 📘 Problem

Given an even-length array of integers, pair the elements such that:

* Each element is used exactly once.
* The **maximum pair sum** among all pairs is minimized.

Return this minimized maximum pair sum.

---

## 💡 Approach

To minimize the largest pair sum:

1. **Sort the array** in ascending order.
2. Use **two pointers**:

   * One at the start (smallest number)
   * One at the end (largest number)
3. Pair them together and calculate their sum.
4. Track the **maximum sum** among all such pairs.

This works because pairing the smallest with the largest balances the sums and avoids very large pair values.

---

## 🧠 Algorithm Steps

* Sort the array.
* Initialize two pointers: `i = 0`, `j = n - 1`.
* While `i < j`:

  * Compute `nums[i] + nums[j]`.
  * Update the maximum pair sum.
  * Move `i++` and `j--`.
* Return the maximum found.

---

## ⏱️ Time & Space Complexity

* **Time:** O(n log n) due to sorting
* **Space:** O(1) extra space (ignoring sorting space)

---

## 🧪 Example

Input: `[3, 5, 2, 3]`

Sorted: `[2, 3, 3, 5]`

Pairs:

* (2, 5) → 7
* (3, 3) → 6

Maximum = **7** ✅

---

## 🧩 Java Solution

```java
class Solution {
    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > max) {
                max = nums[i] + nums[j];
            }
            i++;
            j--;
        }
        return max;
    }
}
```

---

## 🎯 Key Idea

Pair smallest with largest to **balance sums** and keep the **maximum as low as possible**.
