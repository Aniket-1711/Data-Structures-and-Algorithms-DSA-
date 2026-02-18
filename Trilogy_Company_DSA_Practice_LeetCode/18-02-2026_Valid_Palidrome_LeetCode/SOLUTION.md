# 🔁 Valid Palindrome (LeetCode 125)

## 📌 Problem Statement

A string is called a **palindrome** if, after:

* converting all **uppercase letters to lowercase**, and
* **removing all non-alphanumeric characters**,

it reads the same **forward and backward**.

Alphanumeric characters include **letters (a–z, A–Z)** and **digits (0–9)**.

---

## 🧠 Key Idea

* Ignore spaces, punctuation, and symbols
* Keep only **letters and numbers**
* Convert everything to **lowercase**
* Check if the cleaned string is a palindrome

---

## 🧪 Examples

| Input                              | Cleaned String          | Output  |
| ---------------------------------- | ----------------------- | ------- |
| `"A man, a plan, a canal: Panama"` | `amanaplanacanalpanama` | `true`  |
| `"race a car"`                     | `raceacar`              | `false` |
| `" "`                              | `` (empty)              | `true`  |

---

## ⚙️ Approach

1. Create a `StringBuilder`
2. Traverse the string character by character
3. Keep only **letters or digits** using `Character.isLetterOrDigit()`
4. Convert characters to **lowercase**
5. Use **two pointers** to check palindrome

---

## 💻 Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (extra string used)

---

## ✅ Important Notes

* Empty string is a valid palindrome
* Built-in `Character` methods are safer than ASCII checks
* Works for all printable ASCII characters

---
