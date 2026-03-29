# 🧩 Check if Strings Can be Made Equal With Operations I

## 🚀 Problem Summary

You are given two strings `s1` and `s2` of length **4**.

You can perform this operation any number of times:

* Pick indices `i` and `j` such that `j - i = 2`
* Swap characters at those positions

👉 Goal: Check if we can make `s1` equal to `s2`

---

## 💡 Key Insight

Only **fixed index pairs** can be swapped:

* Index **0 ↔ 2**
* Index **1 ↔ 3**

👉 So we actually have **two independent groups**:

| Group   | Indices |
| ------- | ------- |
| Group 1 | 0, 2    |
| Group 2 | 1, 3    |

---

## 🧠 Idea to Solve

We just need to check:

* Characters at (0,2) in `s1` can match (0,2) in `s2`
* Characters at (1,3) in `s1` can match (1,3) in `s2`

Since swaps are allowed, order inside each group **does not matter**.

---

## ✅ Conditions

For both groups:

✔ Either characters match directly
✔ Or they match after swapping

---

## 💻 Java Code

```java
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0))) &&
               ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));
    }
}
```

---

## 🔍 Example Walkthrough

### Example 1

```
s1 = "abcd"
s2 = "cdab"
```

* Swap (0,2) → `cbad`
* Swap (1,3) → `cdab`

✅ Result: **true**

---

### Example 2

```
s1 = "abcd"
s2 = "dacb"
```

* Groups don't match even after swaps

❌ Result: **false**

---

## ⏱️ Complexity

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

## 🎯 Takeaway

👉 Think in terms of **independent index groups** instead of full string swapping.

👉 If groups match → answer is **true**, else **false**.

---

## 🧑‍💻 Tip

Whenever swaps are restricted like this:
👉 Try to identify **which indices are connected** → treat them as groups.

That simplifies the problem a lot ⚡
