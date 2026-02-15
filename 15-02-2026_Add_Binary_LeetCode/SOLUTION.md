# ➕ Add Binary (LeetCode 67)

## 📌 Problem Statement

You are given **two binary strings** `a` and `b`.

Your task is to **add them** and return the result as a **binary string**.

---

## 🧠 Example

**Example 1**

```
Input:  a = "11", b = "1"
Output: "100"
```

**Example 2**

```
Input:  a = "1010", b = "1011"
Output: "10101"
```

---

## 🚦 Constraints

* `1 <= a.length, b.length <= 10⁴`
* Strings contain only `'0'` and `'1'`
* No leading zeros (except "0" itself)

---

## 💡 Approach (Simple Explanation)

* Start from the **end** of both strings (right to left)
* Add digits like **manual binary addition**
* Keep track of a **carry**
* Append the result bit by bit
* Reverse the final string to get correct order

---

## 🛠️ Algorithm Steps

1. Use two pointers at the end of both strings
2. Initialize `carry = 0`
3. Add digits + carry
4. Store `sum % 2` in result
5. Update `carry = sum / 2`
6. Repeat until all digits and carry are processed

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (for result string)

---

## ✅ Java Solution

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;

        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            int sum = carry;
            
            if (p1 >= 0) {
                sum += a.charAt(p1) - '0';
                p1--;
            }
            
            if (p2 >= 0) {
                sum += b.charAt(p2) - '0';
                p2--;
            }
            
            carry = sum / 2;
            res.append(sum % 2);
        }
        
        return res.reverse().toString();
    }
}
```

---

## 🎯 Key Takeaway

This problem is all about **binary addition logic** and **string traversal from right to left**.

Perfect for practicing:

* Two pointers 🧭
* String handling ✨
* Carry-based addition ➕

---
