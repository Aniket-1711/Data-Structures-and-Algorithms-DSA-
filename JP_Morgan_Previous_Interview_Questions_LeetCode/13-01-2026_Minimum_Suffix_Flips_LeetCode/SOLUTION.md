# 🔁 Minimum Suffix Flips (LeetCode 1529)

## 📘 Problem Statement

You are given a binary string `target`. Initially, you have another binary string `s` of the same length filled with all `'0'`s.

In one operation, you can choose an index `i` and flip all bits from `i` to the end of the string.

Your task is to find the **minimum number of such operations** needed to convert `s` into `target`.

---

## 💡 Key Idea

Instead of really flipping the string again and again, we just track:

* What is the **current bit state** (0 or 1)
* Whenever the current state is different from `target[i]`, we **must flip**

Each flip changes the state for all future positions.

---

## ⚙️ Algorithm

1. Start with current state = `'0'`
2. Traverse the string from left to right
3. If current state ≠ `target[i]`:

   * Increment answer
   * Toggle current state

---

## 🧠 Example

For `target = "10111"`

| Index | Target Bit | Current State | Flip? | Flips Count |
| ----- | ---------- | ------------- | ----- | ----------- |
| 0     | 1          | 0             | Yes   | 1           |
| 1     | 0          | 1             | Yes   | 2           |
| 2     | 1          | 0             | Yes   | 3           |
| 3     | 1          | 1             | No    | 3           |
| 4     | 1          | 1             | No    | 3           |

Answer = **3**

---

## 🧪 Java Implementation

```java
class Solution {
    public int minFlips(String target) {
        boolean flag = false; // false means current bit is '0'
        int count = 0;

        for (int i = 0; i < target.length(); i++) {
            if ((target.charAt(i) == '1' && !flag) ||
                (target.charAt(i) == '0' && flag)) {
                count++;
                flag = !flag; // flip the current state
            }
        }
        return count;
    }
}
```

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(1)

---

## ✅ Final Note

This is a greedy solution that counts how many times the desired bit changes compared to the current flipped state. It is optimal and very efficient 🚀
