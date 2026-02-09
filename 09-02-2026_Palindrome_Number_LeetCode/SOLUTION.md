# 🔁 Palindrome Number (LeetCode #9)

## 📌 Problem Statement

Given an integer `x`, return **true** if `x` is a **palindrome**, otherwise return **false**.

A palindrome number reads the same **from left to right and right to left**.

---

## 🧠 Approach Used

* ❌ Negative numbers are **not** palindromes
* 🔄 Reverse the number digit by digit
* 🔍 Compare the reversed number with the original number

---

## ⚙️ Algorithm Steps

1. If the number is negative → return `false`
2. Store the original number in a temporary variable
3. Reverse the number using modulo (`%`) and division (`/`)
4. Compare reversed number with original
5. Return result

---

## 💡 Example

| Input  | Output  | Reason                  |
| ------ | ------- | ----------------------- |
| `121`  | `true`  | Same forward & backward |
| `-121` | `false` | `-` sign mismatch       |
| `10`   | `false` | Reverse is `01`         |

---

## 🧩 Java Solution

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int rem, newNum = 0;
        int temp = x;

        while (x != 0) {
            rem = x % 10;
            newNum = newNum * 10 + rem;
            x /= 10;
        }

        return temp == newNum;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)` where `n` is number of digits
* **Space Complexity:** `O(1)` (no extra space used)

---

## ✅ Key Notes

* No string conversion used 🚫
* Works within given integer limits
* Simple and beginner-friendly logic 😊

---
