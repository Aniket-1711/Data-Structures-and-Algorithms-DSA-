# 🧩 Valid Anagram (LeetCode 242)

## 📌 Problem Statement

You are given two strings `s` and `t`.

* Return **true** if `t` is an **anagram** of `s`
* Return **false** otherwise

An **anagram** means both strings contain the **same characters with the same frequency**, just possibly in a different order.

---

## 🧠 Approach: Frequency Count (Array)

Since both strings contain **only lowercase English letters**, we can use an integer array of size `26`.

### Why this works?

* Each index represents a character from `'a'` to `'z'`
* We **increment** count for string `s`
* We **decrement** count for string `t`
* If all values become `0`, both strings are anagrams

---

## 🔍 Step-by-Step Logic

1. Create an integer array `ar[26]`
2. Traverse string `s` and increment frequency
3. Traverse string `t` and decrement frequency
4. Check the array

   * If any value is not `0` → not an anagram
   * Else → valid anagram

---

## ✨ Example Walkthrough

### Example 1

```
s = "anagram"
t = "nagaram"
```

* Both strings increase and decrease the same characters
* Frequency array becomes all zeros → **true**

### Example 2

```
s = "rat"
t = "car"
```

* Frequencies do not match
* Some values are not zero → **false**

---

## 💻 Java Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int ar[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            ar[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)` (fixed array of size 26)

---

## 🌍 Follow-Up: Unicode Characters

If strings contain **Unicode characters**:

* The 26-size array will not work
* Use a **HashMap<Character, Integer>** instead

This allows counting any character safely.

---

## ✅ Key Takeaway

For lowercase English letters, **frequency array** is the **fastest and cleanest solution** 🚀
