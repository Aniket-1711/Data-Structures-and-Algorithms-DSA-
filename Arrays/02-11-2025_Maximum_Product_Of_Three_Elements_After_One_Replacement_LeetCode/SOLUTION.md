# ⚙️ Maximum Product of Three Elements After One Replacement

### 🧩 Problem Statement

You are given an integer array `nums`. You must replace **exactly one element** in the array with **any integer value** in the range `[-10⁵, 10⁵]` (inclusive). After this replacement, determine the **maximum possible product** of any **three distinct elements** in the modified array.

Return the **maximum achievable product**.

---

### 📘 Example 1

```text
Input: nums = [-5, 7, 0]
Output: 3500000

Explanation: Replace 0 with -105 → [-5, 7, -105]
Product = (-5) * 7 * (-105) = 3500000.
```

### 📘 Example 2

```text
Input: nums = [-4, -2, -1, -3]
Output: 1200000

Explanation: Replace -2 or -1 with 105 → (-4) * 105 * (-3) = 1200000.
```

### 📘 Example 3

```text
Input: nums = [0, 10, 0]
Output: 0

Explanation: No matter what you replace, one zero remains → product = 0.
```

---

### 🧠 Intuition Behind Your Approach

* The key observation is that the **largest possible product** after replacement will occur when you introduce the **largest absolute value (100000)** into the array.
* Replacing any number with ±100000 gives the same magnitude effect because we can consider the absolute values of numbers for the product.
* After replacing one element, the maximum product will involve the **two largest numbers** in the array multiplied by **100000**.
* Hence, sorting and using the top two largest absolute values gives the maximum product.

---

### 💻 Your Java Implementation

```java
class Solution {
    public long maxProduct(int[] nums) {
        // Convert all elements to their absolute values
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        // Sort the array to get the largest values easily
        Arrays.sort(nums);

        // Multiply the two largest numbers with 100000 (max replacement value)
        return 100000L * nums[nums.length - 1] * nums[nums.length - 2];
    }
}
```

---

### ⚙️ Explanation of Code Steps

1. **Convert all numbers to positive** using `Math.abs()`, since replacing one number with ±100000 will always yield a positive maximum magnitude.
2. **Sort the array** to bring the largest numbers at the end.
3. **Take the top two elements** after sorting — `nums[n-1]` and `nums[n-2]`.
4. Multiply them by `100000` (the replacement value) to get the **maximum possible product**.

---

### ⏱️ Complexity Analysis

* **Time Complexity:** `O(n log n)` (for sorting)
* **Space Complexity:** `O(1)` (no extra space used)

---

### 🧪 Edge Cases Considered

* If the array contains **negative numbers**, converting them to absolute ensures the largest magnitude is considered.
* Arrays with **zeros** will still be handled properly, since the replacement introduces the large value `100000`.
* Minimum length is 3, so always enough numbers to form a product.

---

### 🏁 Summary

| Aspect               | Description                                                             |
| :------------------- | :---------------------------------------------------------------------- |
| **Goal**             | Find the maximum product of any 3 numbers after one allowed replacement |
| **Logic Used**       | Replace one element with ±100000 and use top 2 max absolute numbers     |
| **Method**           | Convert to absolute values → Sort → Compute max product                 |
| **Time Complexity**  | O(n log n)                                                              |
| **Space Complexity** | O(1)                                                                    |

---


