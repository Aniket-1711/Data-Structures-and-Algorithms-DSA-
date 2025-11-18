# 1-bit and 2-bit Characters ✨

## 📌 Problem Description

You are given a binary array called **bits**. Each character in this array can be decoded in one of two ways:

* `0` → represents a **one-bit character**
* `10` or `11` → represents a **two-bit character**

The array always ends with **0**.

🎯 **Goal:** Determine if the last character in the array is a **one-bit character**.

---

## 🧠 How to Decode?

We start from the beginning:

* If we see **1**, we must take **two bits** → jump by 2 steps
* If we see **0**, we take **one bit** → jump by 1 step

At the end, if we stop **exactly one step before** the last element, then the last element is a **one-bit character**.

---

## 📝 Example

### Example 1

Input: `[1,0,0]`

* Decode: `10` (two-bit) + `0` (one-bit)
* Ends correctly → **Output: `true`** ✓

### Example 2

Input: `[1,1,1,0]`

* Decode: `11` (two-bit) + `10` (two-bit)
* No single bit left → **Output: `false`** ✗

---

## 💡 Java Solution

```java
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2; // Two-bit character
            } else {
                i++;    // One-bit character
            }
        }
        return i == bits.length - 1;
    }
}
```

---

## 🧩 Key Idea

We keep jumping through the bits based on the rules.
If the pointer **lands exactly** on the second last index, then the last bit (`0`) is a valid **one-bit character** 👍

---

## ⏱️ Constraints

* `1 ≤ bits.length ≤ 1000`
* `bits[i]` is `0` or `1`

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** O(n) — We scan through the array once.
* **Space Complexity:** O(1) — No extra space used.

---

## 🏁 Final Thoughts

A simple and greedy approach solves the problem efficiently! 🚀

