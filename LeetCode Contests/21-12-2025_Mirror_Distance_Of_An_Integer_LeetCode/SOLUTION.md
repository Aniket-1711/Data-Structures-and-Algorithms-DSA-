# 🪞 Mirror Distance of an Integer

## 📌 Problem Statement

You are given an integer **n**.

The **mirror distance** of a number is defined as:

```
abs(n - reverse(n))
```

Where:

* `reverse(n)` is the number formed by reversing the digits of `n`
* `abs(x)` means absolute value

Your task is to return the **mirror distance** of the given integer.

---

## 🧠 Approach

1. Store the original number in a temporary variable.
2. Reverse the number digit by digit using a loop.
3. Subtract the reversed number from the original number.
4. Take the absolute value of the result.

This approach works because:

* Reversing digits can be done using modulo (`%`) and division (`/`).
* Absolute value handles both positive and negative results safely.

---

## 💻 Java Solution

```java
class Solution {
    public int mirrorDistance(int n) {
        int temp = n;
        long rev = 0;
        
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        
        return (int) Math.abs(temp - rev);
    }
}
```

---

## 📊 Example Walkthrough

**Input:** `n = 25`

* reverse(25) = 52
* abs(25 - 52) = **27**

**Output:** `27`

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(d)`

  * Where `d` is the number of digits in `n`

* **Space Complexity:** `O(1)`

  * Only constant extra space is used

---

## ✅ Key Notes

* Handles single-digit numbers correctly
* Works for numbers with trailing zeros (like `10` → `01` → `1`)
* Uses `long` for safety during reversal

---

