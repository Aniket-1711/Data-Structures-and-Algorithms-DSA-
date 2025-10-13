
# 🧩 Longest Balanced Substring I

## 📝 Problem Statement

You are given a string `s` consisting of lowercase English letters.

A **substring** of `s` is called **balanced** if all **distinct characters** in the substring appear the **same number of times**.

You need to **return the length of the longest balanced substring** of `s`.

---

## 🔍 Example 1
**Input:**
```text
s = "abbac"
```

**Output:**
```text
4
```

**Explanation:**
The longest balanced substring is `"abba"` because both distinct characters `'a'` and `'b'` appear exactly **2 times**.

---

## 🔍 Example 2
**Input:**
```text
s = "zzabccy"
```

**Output:**
```text
4
```

**Explanation:**
The longest balanced substring is `"zabc"` because the distinct characters `'z'`, `'a'`, `'b'`, and `'c'` each appear **1 time**.

---

## 🔍 Example 3
**Input:**
```text
s = "aba"
```

**Output:**
```text
2
```

**Explanation:**
One of the longest balanced substrings is `"ab"` because both `'a'` and `'b'` appear **1 time**.  
Another valid substring is `"ba"`.

---

## ⚙️ Constraints
- `1 <= s.length <= 1000`
- `s` consists of lowercase English letters only.

---

## 💡 Approach

1. Iterate through all possible substrings of `s` using two nested loops.  
   - Outer loop for the **start index**.
   - Inner loop for the **end index**.

2. Maintain a **frequency array** `count[26]` to store how many times each character appears in the current substring.

3. For each substring, check if it is **balanced** using the helper method `isBalanced()`:
   - All non-zero frequencies should be **equal**.
   - If yes, update the `ans` (maximum balanced substring length).

4. Return the maximum length found.

> 🧠 This is a brute-force approach with time complexity **O(n² × 26)**, which is fine for `n ≤ 1000`.

---

## 🧠 Intuition

A substring is balanced when:
- Each distinct character has **equal frequency**.
- Example: `"aabbcc"` → balanced (2 each)  
  `"aabbc"` → not balanced (2, 2, 1)

We can expand substrings gradually and use a helper to check this condition efficiently.

---

## 🧩 Code Implementation (Java)
```java
class Solution {
    public int longestBalanced(String s) {
        int ans = 1;
        for (int i = 0; i < s.length(); i++) {
            int count[] = new int[26];

            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;

                if (isBalanced(count)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public boolean isBalanced(int ar[]) {
        int ele = 0;
        for (int i : ar) {
            if (i != 0) {
                if (ele == 0) ele = i;
                else if (ele != i) return false;
            }
        }
        return true;
    }
}
```
