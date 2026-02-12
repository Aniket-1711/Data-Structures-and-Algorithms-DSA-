# 🧩 Longest Balanced Substring I

## 📌 Problem Summary

You are given a string made of **lowercase English letters**.

A substring is called **balanced** if **all distinct characters appear the same number of times**.

Your task is to find the **length of the longest balanced substring**.

---

## ✅ Key Observations

* A substring can have **any number of distinct characters**.
* All characters present must have **equal frequency**.
* Single-character substrings are always balanced.

---

## 🧠 Approach Used (Brute Force)

1. Fix a **starting index `i`**.
2. Extend the substring to the right using index `j`.
3. Maintain a **frequency array of size 26** for characters.
4. After adding each character:

   * Check if all non-zero frequencies are equal.
   * If yes, update the maximum length.

---

## 🧪 Balance Check Logic

A substring is balanced if:

* All characters that appear have the **same count**.
* Characters with count `0` are ignored.

---

## 💻 Java Solution

```java
class Solution {
    public int longestBalanced(String s) {
        int ans = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];

            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;

                if (isBalanced(count)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public boolean isBalanced(int[] ar) {
        int freq = 0;
        for (int x : ar) {
            if (x != 0) {
                if (freq == 0) freq = x;
                else if (freq != x) return false;
            }
        }
        return true;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n³)`

  * `O(n²)` substrings
  * `O(26)` balance check for each
* **Space Complexity:** `O(26)` → constant

---

## 📘 Examples

### Example 1

**Input:** `"abbac"`

Balanced substring: `"abba"`

**Output:** `4`

---

### Example 2

**Input:** `"zzabccy"`

Balanced substring: `"zabc"`

**Output:** `4`

---

### Example 3

**Input:** `"aba"`

Balanced substrings: `"ab"`, `"ba"`

**Output:** `2`

---

## 🎯 Final Notes

* This solution is **easy to understand** and works well for `n ≤ 1000`.
* Can be optimized further using prefix techniques for advanced versions.

