# 🔤 Substrings of Size Three with Distinct Characters

## 📌 Problem Statement

Given a string `s`, return the number of substrings of length **3** that contain **all distinct characters**.

A substring must:

* Be contiguous
* Have exactly 3 characters
* Contain no repeated characters

---

## 🧠 Approach Used

### 🚀 Fixed Size Sliding Window

Since the substring length is fixed (3), we do not need a dynamic window.

We simply:

* Iterate from index `0` to `s.length() - 3`
* Check every group of 3 consecutive characters
* Count if all three characters are different

---

## 🔁 Steps

1. Loop through the string.
2. Pick characters at positions:

   * `i`
   * `i + 1`
   * `i + 2`
3. Check:

   * `a != b`
   * `b != c`
   * `a != c`
4. If all conditions are true → increment count.

---

## 💻 Java Implementation

```java
class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) {
                count++;
            }
        }

        return count;
    }
}
```

---

## 📊 Example

### Input

```
s = "aababcabc"
```

### Output

```
4
```

### Valid Substrings

```
"abc"
"bca"
"cab"
"abc"
```

---

## ⏱ Time Complexity

**O(n)**
We check each substring once.

## 📦 Space Complexity

**O(1)**
No extra data structures used.

---

## 🎯 Key Concept

When substring size is fixed, use:

👉 Fixed Size Sliding Window
👉 Direct character comparison (if size is small)

---

## ✅ Pattern Category

Sliding Window (Fixed Size)
