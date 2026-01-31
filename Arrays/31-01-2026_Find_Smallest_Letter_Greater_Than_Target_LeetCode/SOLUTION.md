# 🔤 Find Smallest Letter Greater Than Target (LeetCode 744)

## 📌 Problem Statement

You are given:

* A sorted array of characters `letters`
* A character `target`

Your task is to find the **smallest character** in `letters` that is **lexicographically greater** than `target`.

👉 If no such character exists, return the **first character** of the array.

---

## 🧠 Key Points

* The array is already **sorted**
* Letters are **lowercase English characters**
* The array contains **at least two different characters**
* Wrap-around is allowed (if target is greater than all letters)

---

## 🧪 Examples

| Letters      | Target | Output |
| ------------ | ------ | ------ |
| [c, f, j]    | a      | c      |
| [c, f, j]    | c      | f      |
| [x, x, y, y] | z      | x      |

---

## 💡 Approach Used

1. Convert characters into numbers (`'a' → 0`, `'b' → 1`, ...)
2. Loop through each character in the array
3. Check if the character is **greater than target**
4. Keep track of the **smallest valid character** found
5. If nothing is found, return the **first character** (wrap-around case)

---

## 💻 Java Code

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int minVal = 26;
        char ans = letters[0];

        for (char ch : letters) {
            if (ch > target) {
                int num = ch - 'a';
                if (num < minVal) {
                    minVal = num;
                    ans = ch;
                }
            }
        }
        return ans;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## ✅ Summary

* Simple linear scan solution
* Works well within constraints
* Handles wrap-around case cleanly
