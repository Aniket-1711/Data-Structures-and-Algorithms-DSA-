# 🧩 First Matching Character From Both Ends

## 🚀 Problem Summary

You are given a string `s`.

👉 Find the **smallest index `i`** such that:

```
s[i] == s[n - i - 1]
```

If no such index exists, return **-1**.

---

## 💡 Key Idea

Compare characters from **both ends** (mirror positions).

---

## 🧠 Approach (Two Pointers)

* Start `i = 0`, `j = n - 1`
* If `s[i] == s[j]` → return `i`
* Else move inward → `i++`, `j--`

---

## 💻 Java Code

```java
class Solution {
    public int firstMatchingIndex(String s) {
        int i = 0, j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                return i;
            }
            i++;
            j--;
        }

        return -1;
    }
}
```

---

## 🔍 Example Walkthrough

### Example 1

```
s = "abcacbd"
```

* i=0, j=6 → a ≠ d ❌
* i=1, j=5 → b = b ✅

👉 Answer = **1**

---

### Example 2

```
s = "abc"
```

* i=0, j=2 → a ≠ c ❌
* i=1, j=1 → b = b ✅

👉 Answer = **1**

---

### Example 3

```
s = "abcdab"
```

* No matches ❌

👉 Answer = **-1**

---

## ⏱️ Complexity

* Time Complexity: **O(n)**
* Space Complexity: **O(1)**

---

## 🎯 Takeaway

👉 Use **two pointers** when dealing with symmetry or mirror conditions.

👉 Always check from **both ends** for faster solutions ⚡
