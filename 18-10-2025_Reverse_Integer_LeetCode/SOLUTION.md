# 🚀 Reverse Integer — Java Solution

## 🧩 Problem Statement

Given a **signed 32-bit integer** `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2³¹, 2³¹ - 1]`, then return `0`.

Assume the environment **does not allow use of 64-bit integers**.

---

## 💡 Examples

| Input      | Output | Explanation             |
| :--------- | :----- | :---------------------- |
| `x = 123`  | `321`  | Reverse of 123 is 321   |
| `x = -123` | `-321` | Reverse of -123 is -321 |
| `x = 120`  | `21`   | Leading zero is removed |

---

## ⚙️ Approach (Step-by-Step)

1. **Extract digits one by one** using modulo (`% 10`).
2. **Build the reversed number** by multiplying `ans` by 10 and adding the extracted digit.
3. **Check for overflow** before every multiplication:

   * If `ans > Integer.MAX_VALUE / 10` or `ans < Integer.MIN_VALUE / 10`, return `0`.
4. Continue until all digits are processed.
5. Return the final reversed integer.

---

## 🧠 Key Insight

Using only `int` ensures compliance with the 32-bit restriction. Overflow must be detected **before** performing the operation.

---

## ✅ Java Implementation

```java
class Solution {
    public int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check overflow before updating ans
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }

            ans = ans * 10 + digit;
            x /= 10;
        }

        return ans;
    }
}
```

---

## 🧾 Time and Space Complexity

* **Time Complexity:** `O(log₁₀(n))` → because we process each digit once.
* **Space Complexity:** `O(1)` → only constant variables are used.

---

## 🔍 Summary

* Handles negative numbers ✅
* Avoids 64-bit integers ✅
* Prevents overflow ✅

This is the **optimal and safe approach** for reversing integers in Java.
