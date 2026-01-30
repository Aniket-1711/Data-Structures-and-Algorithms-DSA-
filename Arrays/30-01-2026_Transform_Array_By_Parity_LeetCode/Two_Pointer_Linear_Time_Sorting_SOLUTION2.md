# 🔢 Transform Array by Parity (Approach 2 – Two Pointers)

## 📌 Problem Summary

You are given an integer array `nums`.
You must perform the following steps **in order**:

1. Replace **even numbers with `0`**
2. Replace **odd numbers with `1`**
3. Sort the array in **non-decreasing order**

---

## 💡 Idea Behind This Approach

This approach works in **two clear phases**:

1. **Parity Conversion Phase**

   * Convert all even numbers to `0`
   * Convert all odd numbers to `1`

2. **Sorting Phase using Two Pointers**

   * Use one pointer from the **start** and one from the **end**
   * Push all `0`s to the left and `1`s to the right

This avoids using built-in sorting and keeps everything **in-place**.

---

## 🧠 Step-by-Step Explanation

### Step 1: Convert Numbers to 0 and 1

* Traverse the array once
* If number is even → replace with `0`
* If number is odd → replace with `1`

After this step, the array contains only `0`s and `1`s.

---

### Step 2: Sort Using Two Pointers

* `i` starts from the beginning
* `j` starts from the end

Rules applied:

* If left is `1` and right is `0` → swap
* If right is already `1` → move `j` left
* If left is already `0` → move `i` right

Continue until both pointers meet.

---

## 🧾 Code (Java)

```java
class Solution {
    public int[] transformArray(int[] nums) {
        // Step 1: Convert even → 0, odd → 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }

        // Step 2: Two pointer sorting
        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] == 1 && nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            } else if (nums[j] == 1) {
                j--;
            } else {
                i++;
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

## ✅ Why This Approach Is Useful

* No extra memory required
* No built-in sorting used
* Demonstrates two-pointer technique
* Good for understanding in-place array manipulation

---

✨ This approach is more algorithmic and helps build strong fundamentals in two-pointer logic.
