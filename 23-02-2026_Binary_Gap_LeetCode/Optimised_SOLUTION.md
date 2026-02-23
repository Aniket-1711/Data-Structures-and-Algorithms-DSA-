# 🔢 868. Binary Gap

## 📌 Problem Statement

Given a positive integer `n`, return the **longest distance between any two adjacent 1's** in its binary representation.

If there are no two adjacent 1’s, return `0`.

---

## 🧠 Understanding the Concept

* Convert the number to binary (or process using bit manipulation).
* Find positions of `1`s.
* Calculate distance between **consecutive 1’s only**.
* Return the maximum distance.

👉 Adjacent means there are only `0`s between them.
👉 If another `1` exists in between, that pair is invalid.

---

## 🧾 Example

### Example 1

Input: `n = 22`
Binary: `10110`

Distances:

* Between first and second `1` → 2
* Between second and third `1` → 1

✅ Output: `2`

---

### Example 2

Input: `n = 8`
Binary: `1000`

No two `1`s exist.

✅ Output: `0`

---

### Example 3

Input: `n = 5`
Binary: `101`

Distance between `1`s → 2

✅ Output: `2`

---

## ⚙️ Approach Used (Bit Manipulation)

1. Traverse the number bit by bit using `n & 1`.
2. Maintain:

   * `count` → current bit position
   * `index` → last seen position of `1`
   * `ans` → maximum distance
3. When a `1` is found:

   * If it's the first `1`, store position.
   * Else calculate distance and update maximum.
4. Right shift number (`n >> 1`) each iteration.

⏱ Time Complexity: **O(log n)**
💾 Space Complexity: **O(1)**

---

## 💻 Java Implementation

```java
class Solution {
    public int binaryGap(int n) {
        int index = -1;
        int count = 0;
        int ans = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (index == -1) {
                    index = count;
                } else {
                    ans = Math.max(ans, count - index);
                    index = count;
                }
            }
            count++;
            n = n >> 1;
        }
        return ans;
    }
}
```

---

## 🎯 Key Takeaway

✔ Only compare consecutive `1`s
✔ Use bitwise operations for better efficiency
✔ Works in logarithmic time

---
