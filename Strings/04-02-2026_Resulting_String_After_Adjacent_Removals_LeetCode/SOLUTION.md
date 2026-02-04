# 🧵 Resulting String After Adjacent Removals

## 📌 Problem Summary

You are given a string `s` with lowercase English letters.

You must **repeatedly remove the leftmost adjacent pair** of characters that are **consecutive in the alphabet**, in **any order**.

✔ Alphabet is **circular** → `a` and `z` are also consecutive.

Stop when **no more such pairs exist**, and return the final string.

---

## 🔁 Operation Rule

Two characters are considered **consecutive** if:

* Their ASCII difference is `1` → (`a-b`, `c-d`, etc.)
* OR their ASCII difference is `25` → (`a-z`, `z-a`)

---

## 🧠 Approach (Stack Technique)

We simulate a **stack** using `StringBuilder`:

* Traverse the string character by character
* Compare the current character with the **top of the stack**
* If they are consecutive → ❌ remove the top character
* Else → ➕ push the current character

This ensures:

* Leftmost removal
* Efficient processing in **O(n)** time

---

## ✅ Java Solution

```java
class Solution {
    public String resultingString(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && areConsecutive(stack.charAt(len - 1), ch)) {
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(ch);
            }
        }
        return stack.toString();
    }

    public boolean areConsecutive(char a, char b) {
        int diff = Math.abs(a - b);
        return diff == 1 || diff == 25;
    }
}
```

---

## 🧪 Example Walkthrough

### Example: `s = "zadb"`

| Step | Stack | Action                |
| ---- | ----- | --------------------- |
| z    | z     | push                  |
| a    | za    | z & a → consecutive ❌ |
| d    | d     | push                  |
| b    | db    | push                  |

**Final Output:** `"db"`

---

## ⏱ Complexity Analysis

* **Time:** `O(n)`
* **Space:** `O(n)` (stack)

---

## 🎯 Key Takeaways

* Stack helps handle **adjacent removals** efficiently
* Circular alphabet check is important (`a ↔ z`)
* Greedy + stack = clean solution 🚀

---

