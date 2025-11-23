# 🔢 Concatenate Non-Zero Digits & Multiply I

## 📘 Problem Description

Given an integer **n**, we follow two steps:

1. **Extract and concatenate all non-zero digits** (keeping their original order) → this forms **x**.
2. **Find the sum of digits of x** → this is **sum**.
3. Return **x × sum**.

If n has **no non-zero digits**, then `x = 0`.

---

## 🧠 Intuition

* We remove all zeroes from the number.
* Build a new integer in the same order.
* Sum its digits.
* Multiply both.

---

## 🧩 Java Code (Corrected & Clean)

```java
class Solution {
    public long sumAndMultiply(int n) {
        int temp = n;
        long x = 0;
        long sum = 0;

        // Step 1: Build x by keeping non-zero digits
        while (temp > 0) {
            int d = temp % 10;
            if (d != 0) {
                x = x * 10 + d;  // reversed order
            }
            temp /= 10;
        }

        // Step 2: Reverse x to restore original digit order
        long original = 0;
        while (x > 0) {
            original = original * 10 + (x % 10);
            x /= 10;
        }

        // Step 3: Compute sum of digits of original
        long temp2 = original;
        while (temp2 > 0) {
            sum += (temp2 % 10);
            temp2 /= 10;
        }

        return original * sum;
    }
}
```

---

## 📝 Example Walkthrough

### Example 1

**Input:** `n = 10203004`

* Non-zero digits → `1 2 3 4`
* So, `x = 1234`
* Sum = `1 + 2 + 3 + 4 = 10`
* Result = `1234 × 10 = 12340`

### Example 2

**Input:** `n = 1000`

* Non-zero digit → `1`
* `x = 1`, sum = `1`
* Result = `1 × 1 = 1`

---

## 🚀 Time & Space Complexity

* **Time Complexity:** O(d), where d = number of digits
* **Space Complexity:** O(1)

---
