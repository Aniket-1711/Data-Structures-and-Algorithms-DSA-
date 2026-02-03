# 🌊 Trionic Array I

## 📌 Problem Statement

An array is called **trionic** if it can be divided into **three continuous parts**:

1. 📈 First part is **strictly increasing**
2. 📉 Second part is **strictly decreasing**
3. 📈 Third part is **strictly increasing again**

There must exist indices `0 < p < q < n-1` that satisfy this pattern.

---

## ✅ Conditions to Check

* Array length must be at least **3**
* All comparisons must be **strict** (`<` or `>` only)
* Each part must have **at least one element**

---

## 🧠 Approach (Simple Logic)

1. Start from index `0`
2. Move forward while numbers are increasing 📈
3. Then move forward while numbers are decreasing 📉
4. Finally move forward while numbers are increasing again 📈
5. If we reach the last index correctly → array is **trionic**

If any part is missing or invalid → return `false`

---

## 💻 Java Solution

```java
class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 0;
        int n = nums.length;

        // First increasing part
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) return false;

        int p = i;

        // Decreasing part
        while (i < n - 1 && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == p || i == n - 1) return false;

        // Final increasing part
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
```

---

## 🧪 Example

### Input

```
[1, 3, 5, 4, 2, 6]
```

### Explanation

* `[1, 3, 5]` → 📈 increasing
* `[5, 4, 2]` → 📉 decreasing
* `[2, 6]` → 📈 increasing

✔️ Valid trionic array

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(1)

---

## 🎯 Final Note

This solution works by **one pass scanning** and carefully checking boundaries. Simple, clean, and efficient 🚀
