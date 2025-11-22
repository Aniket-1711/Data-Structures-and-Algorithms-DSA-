# 🔁 Minimum Number of Flips to Reverse Binary String
---

## 📘 Problem Overview

You are given a positive integer `n`.

* Convert `n` to its **binary string**.
* Take its **reverse**.
* You may flip any bit (`0 → 1` or `1 → 0`).
* Your goal is to find the **minimum number of flips needed** to make the original binary string equal to its reversed version.

---

## 🧠 Key Idea

To make a string equal to its reverse:

* Compare `s[i]` with `s[len - i - 1]`.
* If they differ ➝ you need a flip.
* Since both ends must match, each mismatch contributes **1 flip**.

But remember:

* The loop should run **only till half of the string**, because comparing full string duplicates work.

---

## 📝 Example

### ✔ Example 1

```
Input: n = 7
Binary: 111
Reverse: 111
Output: 0
```

Both are same. No flips needed.

### ✔ Example 2

```
Input: n = 10
Binary: 1010
Reverse: 0101
Output: 4
```

All positions differ → 4 flips.

---

## 💻 Java Code (Given by You)

```java
class Solution {
    public int minimumFlips(int n) {
        String s=Integer.toBinaryString(n);
        int len=s.length();
        int count=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                count+=1;
            }
        }
        return count;
    }
}
```

---

## ⚠️ Problem in Current Code

You're looping from `0` to `len`, comparing pairs **twice**.

Example comparing indexes:

* (0, 3)
* (1, 2)
* (2, 1) → duplicate
* (3, 0) → duplicate

This gives **double counting**.

---

## ✅ Correct Approach

Loop only till **half** of the string.

```java
class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int count = 0;

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                count += 2; // both sides need flipping
            }
        }
        return count;
    }
}
```

---

## 🚀 Time & Space Complexity

* **Time:** O(log n) → binary string length
* **Space:** O(log n)

---

## ✨ Summary

* Compare mirrored positions.
* Count mismatches.
* Multiply mismatches by **2**.
* Loop only halfway.

---

