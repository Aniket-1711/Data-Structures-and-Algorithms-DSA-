# 🧮 Counting Bits (LeetCode 338)

## 📌 Problem Statement

Given an integer **n**, return an array **ans** of length **n + 1** where:

* `ans[i]` = number of **1's** in the binary representation of `i`
* `0 ≤ i ≤ n`

---

## 🔍 Examples

### Example 1

**Input:** `n = 2`
**Output:** `[0, 1, 1]`

Binary:

* `0 → 0`
* `1 → 1`
* `2 → 10`

### Example 2

**Input:** `n = 5`
**Output:** `[0, 1, 1, 2, 1, 2]`

Binary:

* `0 → 0`
* `1 → 1`
* `2 → 10`
* `3 → 11`
* `4 → 100`
* `5 → 101`

---

## 🧠 Approach Used

* Loop from `0` to `n`
* For each number:

  * Use **bitwise AND (`&`)** to check last bit
  * Right shift (`>>>`) the number until it becomes `0`
  * Count how many times bit `1` appears
* Store the count in the result array

✔ No built-in bit count functions used

---

## 💻 Java Solution

```java
class Solution {
    public int[] countBits(int n) {
        int count;
        int a[] = new int[n + 1];
        int k;

        for (int i = 0; i <= n; i++) {
            count = 0;
            k = i;

            while (k != 0) {
                count += (k & 1);
                k >>>= 1;
            }
            a[i] = count;
        }
        return a;
    }
}
```

---

## ⏱ Time & Space Complexity

* **Time Complexity:** `O(n log n)`
* **Space Complexity:** `O(n)`

---

## 🚀 Follow-up Note

This solution works well and is beginner-friendly.
For **O(n)** time, dynamic programming can be used (based on `i >> 1`).

---

