# Maximum Substrings With Distinct Start ✨📘

## 📌 Problem Overview

Given a string containing lowercase letters, the task is to split it into the **maximum number of substrings** such that **each substring starts with a different character**.

---

## 🧠 Key Insight

A substring starts with a specific character. To make each substring start with a different character, you simply need to count **how many distinct characters** are present in the string.

More unique characters → more substrings possible.

---

## 🧩 Examples

### ✅ Example 1

**Input:** "abab"
Distinct characters → {a, b}
**Output:** 2

---

### ✅ Example 2

**Input:** "abcd"
Distinct characters → {a, b, c, d}
**Output:** 4

---

### ✅ Example 3

**Input:** "aaaa"
Distinct characters → {a}
**Output:** 1

---

## 🚀 Solution Approach

* Use a set to store characters.
* Sets store only unique values.
* The size of the set gives the required result.

---

## 💻 Java Code

```java
class Solution {
    public int maxDistinct(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
```

---

## 🏁 Final Note

This is an efficient and optimal approach with:

* **Time Complexity:** O(n) ⏱️
* **Space Complexity:** O(1) (max 26 characters) 💾
